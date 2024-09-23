pipeline{
    environment{
        DOCKERHUB_CRED = credentials("Dockerhub-Credentials-ID")
    }
    agent any
    stages{
        stage("Stage 1 : Git Clone"){
            steps{
                git "https://github.com/RamsaiKoushik/Calculator.git"
            }
        }
        
        stage("Stage 2 : Maven Build"){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage("Stage 3 : Build Docker Image"){
            steps{
                sh "docker build -t anshul1601/calculator:latest ."
            }
        }
        
        stage("Stage 4 : Push Docker Image to Dockerhub"){
            steps{
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push anshul1601/calculator:latest"
            }
        }
        
        stage("Stage 5 : Clean Unwanted Docker Images"){
            steps{
                sh "docker container prune -f"
                sh "docker image prune -a -f"
            }
        }
        
        stage('Stage 6 : Ansible Deployment') {
            steps {
                ansiblePlaybook colorized: true,
                credentialsId: 'localhost',
                installation: 'Ansible',
                inventory: 'inventory',
                playbook: 'Deploy-Calculator.yml'
            }
        }
    }
}