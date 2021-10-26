def call(String project, String hubUser, String credentialsId) {
    sshagent(['ssh-jenkins-build-machine']) {
    // some block
        sh 'ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51'
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'whoami'"
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'pwd'"
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'ls'"
    }
}
