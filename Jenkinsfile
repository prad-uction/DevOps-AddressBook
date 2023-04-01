Def gv 
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
                    gv = load "script.groovy"
                }
            }
        }
        stage ('Checkout') {
            steps {
/*                git 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git'*/
                echo 'Before using function from script'
                script {
                    gv.buildApp()
                }
            }
/*            post {
                success {
                    echo 'Build is successful'
                }
                failure {
                    echo 'Build failed'
                }
            }*/
        }
        stage ('Compile') {
            steps {
/*                bat 'mvn compile' */
                script {
                    gv.compileApp()
                }     
            }
/*            post {
                success {
                    echo 'Code compile is successful'
                }
                failure {
                    echo 'Code compilation failed'
                }
            }*/
        }
        stage ('Test') {
            steps {
/*                bat 'mvn test' */
                script {
                    gv.testApp()
                } 
            }
/*            post {
                success {
                    echo 'Testing is successful'
                }
                failure {
                    echo 'Testing failed'
                }
            }*/
        }
        stage ('Quality') {
/*            when {
                expression {
                    params.executeTests
                }
            } */
            steps {
/*                bat 'mvn pmd:pmd' */
                script {
                    gv.qaApp()
                } 
            }
/*            post {
                success {
                    echo 'QA is successful'
                }
                failure {
                    echo 'QA failed'
                }
            }*/
        }
        stage ('Package') {
            steps {
/*                bat 'mvn package' */
                script {
                    gv.pkgApp()
                } 
            }
/*            post {
                success {
                    echo 'Package is successful'
                }
                failure {
                    echo 'Package failed'
                }
            }*/
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
