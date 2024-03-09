pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage("SCM checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Akash-91/jenkins-ci-cd.git']])
            }
        }
        stage('Build Process') {
            steps {
                script {
                    // Execute Maven command directly without using 'nohup'
                    bat 'mvn clean install'
                }
            }
        }
        stage('Deploy to container'){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }
    }

    post{
        always{
            emailext attachLog: true, body: '''<body>
                                    <p>Hi,</p>
                                    <p>This is an automated email notification from Jenkins.</p>
                                    <p>Build status : ${BUILD_STATUS}</p>
                                    <p>Build Number : ${BUILD_NUMBER}</p>
                                    <p>Build URL : ${BUILD_URL}</p>
                                    <p>Regards,</p>
                                    <p>Jenkins</p>
                                </body>''', mimeType: 'text/html', replyTo: 'akash.akki07@gmail.com', subject: 'Pipeline Status : ${BUILD_NUMBER}', to: 'akash.pyal22@gmail.com'
        }
    }
}
