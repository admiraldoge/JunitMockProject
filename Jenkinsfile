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
                 description: '',
                 name: 'CustomerName',
                 omitValueField: false,
                 randomName: 'choice-parameter-7037574946164',
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
                                  script: '''
                                        inputBox = "<input name='value' class='setting-input' type='text'>"
                                        notAvailableInputBox="<p>Not available input</p>"
                                        if(type.equals("Customer")) {
                                        return inputBox
                                        } else if(type.equals("Vehicle")) {
                                        return notAvailableInputBox
                                        } else if(type.equals("Customer and Vehicle")) {
                                        return inputBox
                                        } 
                                  '''
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