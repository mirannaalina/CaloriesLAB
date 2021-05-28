pipeline {

    agent any

    stages{
        stage('Compile Stage'){

        steps {
            with Maven(maven: 'maven_3_5_0') {
                sh 'mvn clean compile'
            }

        }

       }

       stage('Testing Stage'){

        steps {
                   with Maven(maven: 'maven_3_5_0') {
                       sh 'mvn test'
                   }

               }
        }
          stage('Deployment Stage'){

               steps {
                          with Maven(maven: 'maven_3_5_0') {
                              sh 'mvn deploy'
                          }

                      }
              }

    }

}