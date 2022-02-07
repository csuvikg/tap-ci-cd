pipeline {
    agent any
    stages {
        stage('Build project') {
            steps {
                sh './mvnw clean install -Dmaven.test.skip=true'
            }
        }
        stage('Run tests') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Run SonarQube') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONARQUBE_TOKEN')]) {
                    sh "./mvnw sonar:sonar -Dsonar.host.url=$SONARQUBE_HOST -Dsonar.login=$SONARQUBE_TOKEN"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
