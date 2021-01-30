#!groovy
pipeline {
    agent any
    parameters([
            [
                    $class: 'ChoiceParameter',
                    choiceType: 'PT_SINGLE_SELECT',
                    name: 'Environment',
                    script: [
                            $class: 'ScriptlerScript',
                            scriptlerScriptId:'Environments.groovy'
                    ]
            ],
            [
                    $class: 'CascadeChoiceParameter',
                    choiceType: 'PT_SINGLE_SELECT',
                    name: 'Host',
                    referencedParameters: 'Environment',
                    script: [
                            $class: 'ScriptlerScript',
                            scriptlerScriptId:'HostsInEnv.groovy',
                            parameters: [
                                    [name:'Environment', value: '$Environment']
                            ]
                    ]
            ]
    ])
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