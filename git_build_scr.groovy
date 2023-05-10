def buildApp() {
            checkout scmGit(branches: [[name: "*/${BRANCH-NM}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'git-cred', name: 'origin', url: 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git']]) 
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
