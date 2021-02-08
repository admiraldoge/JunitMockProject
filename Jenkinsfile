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
                 choiceType: 'ET_TEXT_BOX',
                 description: '',
                 name: 'CustomerName',
                 omitValueField: false,
                 randomName: 'choice-parameter-5385897094462',
                 referencedParameters: 'type',
                 script: [$class: 'GroovyScript',
                          fallbackScript: [
                                  classpath: [],
                                  sandbox: false,
                                  script: ''
                          ],
                          script: [
                                  classpath: [],
                                  sandbox: false,
                                  script: '''if(type.equals("Customer")) {
                                              return \'Parameter selected\'
                                         }'''
                          ]
                 ]
                ]
        ])
])
node {
    stage('checkout') {
        echo 'Pulling from git'
    }
    stage('Build') {
        echo 'Building...'
        sh 'mvn clean install'
    }
    stage('Test') {
        echo 'Running tests'
        sh 'mvn test'
    }
}