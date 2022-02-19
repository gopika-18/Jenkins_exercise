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
                sh 'mvn compile -Dsurefire.useFile=false -Dmaven.test.skip=true'
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
                   sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=Jekins_pipeline_exercise -Dsonar.host.url=http://3.123.27.181:9000 -Dsonar.login=bae084151cf30234e8d951870094645d3763137d'    
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
