def buildApp() {
            echo 'Before'
	    git branch: "${BRANCH-NM}", credentialsId: 'git-cred', url: 'https://github.com/kotagiriramachandra/DevOpsClassCodes.git'
            echo 'After'
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
