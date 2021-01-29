#!groovy

pipeline {
    agent any
    parameters {
        string(name: 'BRANCH_PASSED_OVER', defaultValue: 'defaultvalue',
                description: 'pass branch value')
        string(name: 'PERSON2', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }
    stage ('Select'){
        choice1 = input( id: 'userInput', message: 'Select your choice', parameters: [ [\$class: 'ChoiceParameterDefinition', choices: 'aa\nbb', description: '', name: ''] ])
        if(choice1.equals("aa")){
            choice2 = input( id: 'userInput', message: 'Select your choice', parameters: [ [\$class: 'ChoiceParameterDefinition', choices: 'yy\nww', description: '', name: ''] ])
        }else{
            choice2 = input( id: 'userInput', message: 'Select your choice', parameters: [ [\$class: 'ChoiceParameterDefinition', choices: 'gg\nkk', description: '', name: ''] ])
        }
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