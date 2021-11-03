def call(String cmd, String creds) {
    sshagent([${creds}]) {
        sh ${cmd}
    }
}
