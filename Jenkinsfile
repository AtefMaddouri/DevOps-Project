pipeline {
  agent {
    node {
      label 'maven'
    }

  }
  stages {
    stage('Tests') {
      parallel {
        stage('Unit Testing ') {
          steps {
            sh 'mvn test -Ptest'
          }
        }

        stage('SRC analysis Testing') {
          steps {
            sh 'mvn verify sonar:sonar -Dsonar.login=admin -Dsonar.password=Atef123*'
          }
        }

      }
    }

    stage('Build ') {
      parallel {
        stage('Build artifact') {
          steps {
            sh 'mvn clean package -Pprod'
          }
        }

        stage('Build Docker Image') {
          steps {
            sh 'docker build -t achatproject/achatproject . '
          }
        }

      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy artifact to Nexus') {
          steps {
            sh 'mvn deploy -Pprod'
          }
        }

        stage('Deploy image to Nexus') {
          steps {
            sh 'docker push 172.17.0.1:8082/achatproject:latest '
          }
        }

      }
    }

    stage('Start Containers') {
      steps {
        sh 'docker-compose up -d'
      }
    }

  }
}