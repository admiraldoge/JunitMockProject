#!groovy

pipeline {
    agent any
    parameters {
        string(name: 'BRANCH_PASSED_OVER', defaultValue: 'defaultvalue',
                description: 'pass branch value')
        string(name: 'PERSON2', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }
    stages {
        stage('checkout') {
            steps {
                echo 'Pulling from git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }
    }
}