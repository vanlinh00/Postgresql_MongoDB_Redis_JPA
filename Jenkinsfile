pipeline {
    agent any
   tools {
                maven 'Maven3.8'
            }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/vanlinh00/Postgresql_MongoDB_Redis_JPA', branch: 'master'
            }
        }

//         stage('Build') {
//             steps {
//                 sh 'mvn clean install -DskipTests'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh 'mvn test'
//             }
//         }
    }
}
