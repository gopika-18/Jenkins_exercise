pipeline {
    agent any
    tools {
            maven 'Maven' 
          }
    stages {
        stage('Clone sources') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gopika-18/Jenkins_exercise.git']]])
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -V -U -e clean install -Dsurefire.useFile=false'
            } 
        }
        stage('Result') {
            steps {
                junit allowEmptyResults: true, checksName: '**/src/main/java/**', skipMarkingBuildUnstable: true, testResults: '**/target/surefire-reports/TEST-*.xml'
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
