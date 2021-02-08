#!groovy
node {
    stage('checkout') {
        echo 'Pulling from git'
        def type = choice(choices: ['Customer', 'Vehicle', 'Customer ' + 'and ' + 'Vehicle'],
                description: '', name: 'type')
        properties([parameters([type])])
        if(type.equals("Customer")) {
            def customerName = string(defaultValue: '', description: '', name: 'CustomerName', trim: false)
            properties([parameters[customerName]])
        }
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