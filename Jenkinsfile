#!groovy
properties([
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
])
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