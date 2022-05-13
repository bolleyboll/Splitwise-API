pipeline {
    environment{
        imageName = ""
    }
    agent any

    stages {
        stage('Git Pull') {
            steps {
                git branch: 'main', credentialsId: 'cred-github', url: 'https://github.com/bolleyboll/Splitwise-API.git'
            }
        }
        stage('Maven Build') {
            steps {
                script{
                    sh 'mvn clean install'
                }
            }
        }
        stage('Docker Image Build') {
            steps {
                script{
                    imageName = docker.build "patro30/backend:latest"
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script{
                    docker.withRegistry('', 'cred-docker'){
                        imageName.push()
                    }
                }
            }
        }
        stage('Ansible Pull Docker Image') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, credentialsId: 'cred-ssh',installation: 'Ansible', inventory: 'ansible/inventory.txt', playbook: 'ansible/playbook.yml', sudoUser: null
            }
        }
    }
}