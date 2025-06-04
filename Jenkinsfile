pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/vanlinh00/Postgresql_MongoDB_Redis_JPA', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                echo 'Build stage - just testing'
            }
        }
    }
}