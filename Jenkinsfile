// pipeline {
//     agent any
//
//     environment {
//         // Définir les variables d'environnement si nécessaire
//         JAVA_HOME = '/usr/lib/jvm/java-17-amazon-corretto.x86_64'
//         MAVEN_HOME = '/usr/bin/mvn'
//         PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
//     }
//
//     stages {
//         stage('Checkout') {
//             steps {
//                 // Récupérer le code depuis le référentiel Git
//                 git branch: 'main', url: 'https://github.com/ElTakuma/pratice-devop-1.git'
//             }
//         }
//
//         stage('Build') {
//             steps {
//                 // Construire le projet avec Maven
//                 sh 'mvn clean package -DskipTests=true'
//             }
//         }
//
//         stage('Test') {
//             steps {
//                 // Exécuter les tests avec Maven
//                 sh 'mvn test'
//             }
//         }
//
//
//         stage('Deploy') {
//             steps {
//                 // Déployer le projet sur un serveur Tomcat par exemple
//                 sh 'scp target/*.war admin@44.204.15.118:8080:/destination'
// //                 sh 'mvn tomcat7:deploy -Dtomcat.url=http://44.204.15.118:8080 -Dtomcat.username=admin -Dtomcat.password=primus@237 -DskipTests=true'
//             }
//         }
//     }
//
//     post {
//         // Actions à effectuer après l'exécution du pipeline
//         success {
//             echo 'Le pipeline a été exécuté avec succès! Déployez votre application.'
//         }
//         failure {
//             echo 'Le pipeline a échoué. Vérifiez les logs et corrigez les erreurs.'
//         }
//     }
// }


pipeline {
    agent any

    environment {
        TOMCAT_HOST = '44.204.15.98'
        TOMCAT_PORT = '8080'
        TOMCAT_USERNAME = 'admin'
        TOMCAT_PASSWORD = credentials('a901f112-a7f3-42e0-af05-422a847e6391	')
        WAR_FILE = '*.war'
    }

    stages {
        stage('Build') {
            steps {
                // Build your Spring application (e.g., using Maven or Gradle)
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                // Copy the WAR file to the remote Tomcat server
                sh "scp -o StrictHostKeyChecking=no -P ${TOMCAT_PORT} target/${WAR_FILE} ${TOMCAT_USERNAME}@${TOMCAT_HOST}:/path/to/tomcat/webapps"

                // Restart Tomcat to deploy the application
                sh "sshpass -p ${TOMCAT_PASSWORD} ssh -o StrictHostKeyChecking=no -p ${TOMCAT_PORT} ${TOMCAT_USERNAME}@${TOMCAT_HOST} '/path/to/tomcat/bin/shutdown.sh && sleep 5 && /path/to/tomcat/bin/startup.sh'"
            }
        }
    }
}
