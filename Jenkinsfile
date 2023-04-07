def GV 

pipeline {
    agent { label 'windows' }
    tools {
        maven 'M2_HOME'
    }
    parameters {
        booleanParam (name:'executeTests', defaultValue: false, description: '' )
    }
    stages {
        stage ('init') {
            steps {
                script {
                    GV = load "script.groovy"
                }
            }
        }
        stage ('Checkout') {
            steps {
                echo 'Before using function from script'
                script {
                    GV.buildApp()
                }
            }
            post {
                success {
                    echo 'Build is successful'
                }
                failure {
                    echo 'Build failed'
                }
            }
        }
        stage ('Compile') {
            steps {
                script {
                    GV.compileApp()
                }     
            }
            post {
                success {
                    echo 'Code compile is successful'
                }
                failure {
                    echo 'Code compilation failed'
                }
            }
        }
        stage ('Test') {
            steps {
                script {
                    GV.testApp()
                } 
            }
            post {
                success {
                    echo 'Testing is successful'
                }
                failure {
                    echo 'Testing failed'
                }
            }
        }
        stage ('Quality') {
/*            when {
                expression {
                    params.executeTests
                }
            } */
            steps {
                script {
                    GV.qaApp()
                } 
            }
            post {
                success {
                    echo 'QA is successful'
                }
                failure {
                    echo 'QA failed'
                }
            }
        }
        stage ('Package') {
            steps {
                script {
                    GV.pkgApp()
                } 
            }
            post {
                success {
                    echo 'Package is successful'
                }
                failure {
                    echo 'Package failed'
                }
            }
        }
        stage ('Docker Image') {
            steps{
                script {
                    sh 'docker build -t addressbook:V1.0 .'
                }
            }
            post {
                success {
                    echo 'Docker Image is built successfully'
                }
                failure {
                    echo 'Docker Image built failed'
                }
        }
    }
    
    post {
        
        always {
            echo 'build process initiated and'
        }
        
        success {
            echo 'build process conpleted successfully'
        }
        
        failure {
            echo 'build process failed'
        }
    }
}
