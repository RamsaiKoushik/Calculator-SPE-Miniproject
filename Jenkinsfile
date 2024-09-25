pipeline{
    environment{
        DOCKERHUB_CRED = credentials("DockerHub-Credentials-ID")
    }
    agent any
    stages{
        
        
        stage("Stage 1 : Maven Build"){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage("Stage 2: Build Docker Image"){
            steps{
                sh "docker build -t ramsai987/calculator:latest ."
            }
        }
        
        stage("Stage 3: Push Docker Image to Dockerhub"){
            steps{
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push ramsai987/calculator:latest"
            }
        }
        
        stage("Stage 4: Clean Unwanted Docker Images"){
            steps{
                sh "docker container prune -f"
                sh "docker image prune -a -f"
            }
        }
        
        stage('Stage 5: Ansible Deployment') {
            steps {
                ansiblePlaybook colorized: true,
                credentialsId: 'localhost',
                installation: 'Ansible',
                inventory: 'inventory',
                playbook: 'deploy-calculator.yml'
            }
        }
    }
}
