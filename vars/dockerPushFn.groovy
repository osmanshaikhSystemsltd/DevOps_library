def call(String project, String hubUser, String credentialsId) {
    sshagent(['ssh-jenkins-build-machine']) {
    // some block
        sh 'ssh -o UserKnownHostsFile=/dev/null osmanshaikh@20.54.72.51'
    }
}
