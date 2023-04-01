def buildApp() {
            
            echo 'Inside the script'
            git 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git' 
            echo 'After fetch'
/*            post {
                success {
                    echo 'Build is successful'
                }
                failure {
                    echo 'Build failed'
                }
            }*/
}
def compileApp() {
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
