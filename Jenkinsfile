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
                                  sandbox: true,
                                  script:  '''
                                        vappHtml = """
                                        <ul style="list-style-type: none">
                                            <li style="padding: 5px">
                                            <label>Customer Name</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Customer Phone</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Customer Email</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Customer ID</label>
                                            <input type="text" class="setting-input" name="value">
                                          </li>
                                        </ul>
                                        """
                                        
                                        return vappHtml
                                  '''
                          ]
                 ]
                ]
        ])
])
node {
    stage('checkout') {
        echo 'Pulling from git'
        echo parameters.CustomerName
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