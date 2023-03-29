def buildApp() {
            steps {
                git 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git'
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
def compileApp() {
            steps {
                bat 'mvn compile'
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
def testApp() {
            steps {
                bat 'mvn test'
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
def qaApp() {
            steps {
                bat 'mvn pmd:pmd'
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
def pkgApp() {
            steps {
                bat 'mvn package'
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

return this
