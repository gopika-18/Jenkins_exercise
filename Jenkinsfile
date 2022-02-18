pipeline {
    agent any
    tools {
            maven 'Maven' 
          }
    stages {
        stage('Clone sources') {
            steps {
                git url: 'https://github.com/gopika-18/Jenkins_exercise.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -V -U -e clean install -Dsurefire.useFile=false'
            } 
        }
        stage('Test') {
            steps {
                sh 'mvn -U -V -e -DdependenciesToScan -Dgroupid=org.knime.devops.exercise test'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "mvn -V -U -e sonar:sonar"
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
             build job: 'java_pipeline'
        }
    } 
}
