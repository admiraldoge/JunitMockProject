#!groovy
properties([
    parameters([
        [$class: 'ChoiceParameter',
         choiceType: 'PT_SINGLE_SELECT',
         description: 'Select the Env Name from the Dropdown List',
         filterLength: 1,
         filterable: false,
         name: 'lab',
         script: [
                 $class: 'GroovyScript',
                 fallbackScript: [
                         classpath: [],
                         sandbox: false,
                         script:
                                 'return[\'Could not get Env\']'
                 ],
                 script: [
                         classpath: [],
                         sandbox: false,
                         script:
                                 'return["Dev","QA","Stage","Prod"]'
                 ]
         ]
        ],
        [$class: 'CascadeChoiceParameter',
         choiceType: 'PT_SINGLE_SELECT',
         description: 'Select a choice',
         filterLength: 1,
         filterable: true,
         name: 'choice1',
         referencedParameters: 'PT_SINGLE_SELECT',
         script: [$class: 'GroovyScript',
                  fallbackScript: [
                          classpath: [],
                          sandbox: true,
                          script: 'return ["ERROR"]'
                  ],
                  script: [
                          classpath: [],
                          sandbox: true,
                          script: """
                        if (ENVIRONMENT == 'lab') { 
                            return['aaa','bbb']
                        }
                        else {
                            return['ccc', 'ddd']
                        }
                    """.stripIndent()
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