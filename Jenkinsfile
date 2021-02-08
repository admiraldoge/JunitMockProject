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
                 omitValueField: true,
                 randomName: 'choice-parameter-7037574946164',
                 referencedParameters: 'type',
                 script: [$class: 'GroovyScript',
                          fallbackScript: [
                                  classpath: [],
                                  sandbox: false,
                                  script: 'return "<b>Not available</b>"'
                          ],
                          script: [
                                  classpath: [],
                                  sandbox: false,
                                  script: """
                                        if(type.equals("Customer")) {
                                        return "<input name=\\"value\\" value=\\"${CustomerName}\\" class=\\"setting-input\\" type=\\"text\\">"
                                        } else if(type.equals("Vehicle")) {
                                        return "<b>Not available</b>"
                                        } else if(type.equals("Customer and Vehicle")) {
                                        return "<input name='CustomerName' class='setting-input' type='text'>"
                                        } 
                                  """
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