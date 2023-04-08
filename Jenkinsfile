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
                    bat 'docker build -t addressbook:V1.0 .'
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
        stage ('Docker Connect to AWS') {
            steps{
                script {
                    bat 'aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 791930564431.dkr.ecr.ap-northeast-1.amazonaws.com'
                }
            }
            post {
                success {
                    echo 'Docker AWS connection successfully'
                }
                failure {
                    echo 'Docker AWS connection failed'
                }
            }  
        }
        stage ('Docker tag') {
            steps{
                script {
                    bat 'docker tag addressbook:V1.0 791930564431.dkr.ecr.ap-northeast-1.amazonaws.com/addbk_ecr_ap_ne_1:V1.0'
                }
            }
            post {
                success {
                    echo 'Docker tag successfully'
                }
                failure {
                    echo 'Docker tag failed'
                }
            }  
        }
        stage ('Docker push to AWS') {
            steps{
                script {
                    bat 'docker push 791930564431.dkr.ecr.ap-northeast-1.amazonaws.com/addbk_ecr_ap_ne_1:V1.0'
                }
            }
            post {
                success {
                    echo 'Docker push to AWS successfully'
                }
                failure {
                    echo 'Docker push to AWS failed'
                }
            }  
        }
    }
    
    post {
        
        always {
            echo 'Build process initiated and'
        }
        
        success {
            echo 'build process completed successfully'
        }
        
        failure {
            echo 'build process failed'
        }
    }
}
