pipeline {
    agent any
    tools {
            maven 'Maven' 
          }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gopika-18/Jenkins_exercise.git']]])
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn clean compile -Dsurefire.useFile=false -Dmaven.test.skip=true'
            } 
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('Result') {
            steps {
                junit allowEmptyResults: true, checksName: '**/src/main/java/**', skipMarkingBuildUnstable: true, testResults: '**/target/surefire-reports/TEST-*.xml'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'sonar_login') {
                   sh 'mvn sonar:sonar'  
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: false
             build job: 'java_pipeline'
        }
    }   
} 
