pipeline {
    agent any

    environment {
        // Définir les variables d'environnement si nécessaire
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        MAVEN_HOME = '/usr/bin/mvn'
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code depuis le référentiel Git
                git 'https://github.com/votre-utilisateur/votre-projet.git'
            }
        }

        stage('Build') {
            steps {
                // Construire le projet avec Maven
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage('Test') {
            steps {
                // Exécuter les tests avec Maven
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Créer le package JAR exécutable
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Déployer le projet sur un serveur Tomcat par exemple
                sh 'scp target/monprojet.jar utilisateur@serveur:/chemin/de/destination'
            }
        }
    }

    post {
        // Actions à effectuer après l'exécution du pipeline
        success {
            echo 'Le pipeline a été exécuté avec succès! Déployez votre application.'
        }
        failure {
            echo 'Le pipeline a échoué. Vérifiez les logs et corrigez les erreurs.'
        }
    }
}
