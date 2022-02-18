pipeline {
    agent any
  tools{
    maven 'Maven'
  }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
       stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    } 
post {
        always {
            archiveArtifacts artifacts: 'target/*.jar'
            build job: 'java_pipline', parameters: [string(name: 'buildartifact', value: 'checkme')
        }
    }
}
