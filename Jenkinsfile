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
                 name: 'CustomerData',
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
                                            <label>Name</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Phone</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Email</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>ID</label>
                                            <input type="text" class="setting-input" name="value">
                                          </li>
                                        </ul>
                                        """
                                        error = """
                                        <p>Not available</p>
                                        """
                                        if(type.equals("Customer") || type.equals("Customer and Vehicle")) {
                                            return vappHtml
                                        } else {
                                            return error
                                        }
                                  '''
                          ]
                 ]
                ],
                [$class: 'DynamicReferenceParameter',
                 choiceType: 'ET_FORMATTED_HTML',
                 description: '',
                 name: 'VehicleData',
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
                                            <label>VIN</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Make</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Year</label>
                                            <input type="text" class="setting-input" name="value">
                                            <label>Model</label>
                                            <input type="text" class="setting-input" name="value">
                                          </li>
                                        </ul>
                                        """
                                        error = """
                                        <p>Not available</p>
                                        """
                                        if(type.equals("Vehicle") || type.equals("Customer and Vehicle")) {
                                            return vappHtml
                                        } else {
                                            return error
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
        print "Customer Data = ${env.CustomerData}"
    }
    stage('Build') {
        echo 'Building...'
        sh 'mvn clean install'
    }
    stage('Test') {
        echo 'Running tests'
        sh "mvn -Dtest=TestCircle=CalculatorTests2 -Dcustomer.data=${env.CustomerData} test"
    }
}