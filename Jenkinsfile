#!groovy
properties([
        parameters([
                [$class: 'ChoiceParameter',
                 choiceType: 'PT_SINGLE_SELECT',
                 description: 'Select the Env Name from the Dropdown List',
                 filterLength: 1,
                 filterable: true,
                 name: 'Env',
                 randomName: 'choice-parameter-5631314439613978',
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
                 description: 'Select the Server from the Dropdown List',
                 filterLength: 1,
                 filterable: true,
                 name: 'Server',
                 randomName: 'choice-parameter-5631314456178619',
                 referencedParameters: 'Env',
                 script: [
                         $class: 'GroovyScript',
                         fallbackScript: [
                                 classpath: [],
                                 sandbox: false,
                                 script:
                                         'return[\'Could not get Environment from Env Param\']'
                         ],
                         script: [
                                 classpath: [],
                                 sandbox: false,
                                 script:
                                         ''' if (Env.equals("Dev")){
                                return["devaaa001","devaaa002","devbbb001","devbbb002","devccc001","devccc002"]
                            }
                            else if(Env.equals("QA")){
                                return["qaaaa001","qabbb002","qaccc003"]
                            }
                            else if(Env.equals("Stage")){
                                return["staaa001","stbbb002","stccc003"]
                            }
                            else if(Env.equals("Prod")){
                                return["praaa001","prbbb002","prccc003"]
                            }
                        '''
                         ]
                 ]
                ]
        ])
])

pipeline {
    agent any
    stages {
        stage('Setup parameters') {
            steps {
                script {
                    properties([
                        parameters([
                                choice(
                                        choices: ['Customer', 'Vehicle'],
                                        name: 'Test'
                                ),
                                booleanParam(
                                        defaultValue: true,
                                        description: '',
                                        name: 'BOOLEAN'
                                ),
                                text(
                                        defaultValue: '''
                            this is a multi-line 
                            string parameter example
                            ''',
                                        name: 'MULTI-LINE-STRING'
                                ),
                                string(
                                        defaultValue: 'scriptcrunch',
                                        name: 'STRING-PARAMETER',
                                        trim: true
                                )
                        ])
                    ])
                }
            }
        }
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