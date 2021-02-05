#!groovy
properties([
        parameters([
                [$class: 'ChoiceParameter',
                 choiceType: 'PT_SINGLE_SELECT',
                 description: 'This parameter selects the type of tests that the job will run.',
                 filterLength: 1,
                 filterable: false,
                 name: 'type',
                 randomName: 'choice-parameter-37159498587213',
                 script: [$class: 'GroovyScript',
                          fallbackScript: [
                                  classpath: [],
                                  sandbox: false,
                                  script: 'return [\'Select a type of test to run.\']'],
                          script: [
                                  classpath: [],
                                  sandbox: false,
                                  script: 'return [\'Customer\', \'Vehicle\', \'Customer and Vehicle\']']]],
                [$class: 'DynamicReferenceParameter',
                 choiceType: 'ET_FORMATTED_HTML',
                 description: 'These are the input values for different inputs according to each case.',
                 name: '',
                 omitValueField: false,
                 randomName: 'choice-parameter-37159504908864',
                 referencedParameters: 'type',
                 script: [$class: 'GroovyScript',
                          fallbackScript: [
                                  classpath: [],
                                  sandbox: false,
                                  script: 'return \'<p>No option has been selected</p>\''],
                          script: [classpath: [], sandbox: false, script: '''switch(type) { 
                                       case \'Customer\': 
                                       return \'<input type="text" value="name"/>\'
                                       case \'Vehicle\': 
                                       return \'<input type="text" value="name"/>\'
                                       case \'Customer and Vehicle\': 
                                       return \'<input type="text" value="name"/>\'
                                       default:
                                        return \'<p>No option has been selected</p>\'} '''
                          ]
                 ]
                ]
        ])
])
pipeline {
    agent any
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