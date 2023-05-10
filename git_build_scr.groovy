def buildApp() {
            checkout scmGit(branches: [[name: "*/${BRANCH-NM}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'Test_Credentials', name: 'origin', url: '<url_details>']]) 
            echo "Git pull from ${BRANCH-NM}"
}

def compileApp() {
            bat 'mvn clean compile'
			echo 'clean compile done'
}

def testApp() {
                bat 'mvn test'
}

def qaApp() {
                bat 'mvn pmd:pmd'
}

def pkgApp() {
                bat 'mvn package'
				echo 'build done'
}

return this