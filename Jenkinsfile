pipeline {
    agent any

    stages {
        stage('git pull') {
            steps {
                git branch: 'main', url: 'https://github.com/bolleyboll/Splitwise-API.git'
            }
        }
        stage('mvn build') {
            steps {
                script{
                    sh 'mvn clean install pacakge'
                }
            }
        }
        stage('Docker Image Generation & Upload to DockerHub') {
            steps {
                script{
                    img = docker.build "freshlyjuiced/splitwise-api:latest"
                    docker.withRegistry('', 'cred-docker'){
                        img.push()
                    }
                }
            }
        }
        stage('Ansible pull Docker Image') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, credentialsId: 'cred-ssh', installation: 'Ansible', inventory: 'ansible/inventory.txt', playbook: 'ansible/playbook.yml', sudoUser: null
            }
        }
    }
}
