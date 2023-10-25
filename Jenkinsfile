pipeline {
  agent { label 'ubuntu-agent' }
    //  agent any

    environment {


        SONARCLOUD_TOKEN = 'bfb91f68b4d10ca03123bf97cd39e3edbb296ca2'
        SONARCLOUD_HOST = 'https://sonarcloud.io'
        SONARCLOUD_ORGANIZATION = 'devops-project-jenkins'

        SONAR_TOKEN = 'squ_4edd633ffc222848c6d2e7da2ba61acd86b98500'
        SONAR_USERNAME = 'admin'
        SONAR_PASSWORD = 'sonar'

        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = 'admin'

        DOCKER_REGISTRY = '192.168.1.120:8085'
        DOCKER_IMAGE_NAME = 'achatproject'
        DOCKER_IMAGE_TAG = 'latest'

        NEXUS_URL = '192.168.1.120:8081'
        NEXUS_REPOSITORY = 'maven-releases'
        NEXUS_CREDENTIALS = 'nexus-credentials'

        GROUP_ID = 'com.esprit.examen'
        ARTIFACT_ID = 'tpAchatProject'
        ARTIFACT_VERSION = '1.0'

        MYSQL_ROOT_PASSWORD='root'
    }

    stages {

 /*
       stage ('GIT') {
            steps {
               echo "Getting Project from Git";
                git branch: "main",
                    url: "https://github.com/AtefMaddouri/DevOps-Project.git",
                    credentialsId: "Git-Credentials";
            }
        } */

       stage('Unit Testing ') {
                   steps {
                       sh 'mvn clean test -Ptest'
                   }
               }

       stage('SRC analysis Testing') {
            steps {
//               sh 'mvn verify sonar:sonar -Dsonar.login=${SONAR_USERNAME} -Dsonar.password=${SONAR_PASSWORD}'
//               sh 'mvn verify sonar:sonar -Dsonar.token=${SONAR_TOKEN}'
              sh 'mvn verify sonar:sonar -Dsonar.host.url=${SONARCLOUD_HOST} -Dsonar.organization=${SONARCLOUD_ORGANIZATION} -Dsonar.token=${SONARCLOUD_TOKEN}'
            }
        }



        stage("build package") {
            steps {
                sh "chmod +x ./mvnw"
                sh "mvn clean package -Pprod"
             //    sh "mvn clean package -DskipTests" pour une machine linux
            }
        }

        stage('Build Docker Image') {
          steps {
            // sh 'sudo docker build -t achatproject/achatproject . '
            sh "sudo docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."
          }
        }

        stage("Deploy Artifact to Nexus") {
            steps {
             sh "mvn deploy -Pprod"
            }
        }

        stage("deploy image to Nexus") {
            steps {
             sh "sudo docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
            }
        }


      /*  stage('Start Containers') {
         steps {
            sh 'sudo docker-compose up -d'
          }
        }*/



    }

    /*post {
        always {
            cleanWs()
        }
    }*/

}