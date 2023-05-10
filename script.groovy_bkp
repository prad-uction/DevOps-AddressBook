def buildApp() {
            
            echo 'Inside the script'
            git 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git' 
            echo 'After fetch'
}

def compileApp() {
            bat 'mvn clean compile'
}

def testApp() {
                bat 'mvn test'
}

def qaApp() {
                bat 'mvn pmd:pmd'
}

def pkgApp() {
                bat 'mvn package'
}

return this
