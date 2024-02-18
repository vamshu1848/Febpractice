def call (credID, warname, username, IP) {
  sshagent(['credID']) {
                    sh "scp -o StrictHostKeyChecking=no target/${warname} ${username}@${IP}:/opt/tomcat9/webapps"
                    sh "ssh ${username}@${IP} /opt/tomcat9/bin/shutdown.sh"
                    sh "ssh ${username}@${IP} /opt/tomcat9/bin/startup.sh"
  }
}
