def GV 

pipeline {
    agent any
    tools {
        maven 'M2_HOME'
    }
    parameters {
        string defaultValue: 'develop', description: 'Source Branch', name: 'BRANCG-NM'
    }
    stages {
        stage ('init') {
            steps {
                script {
                    GV = load "git_build_scr.groovy"
                }
            }
        }
        stage ('Build') {
            steps {
                echo 'using git build scr functions'
                script {
                    GV.buildApp()
		    GV.compileApp()
		    GV.pkgApp()
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
/*        stage ('Docker Connect to AWS') {
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
        } */
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
