def call(String cmd, String creds) {
    sshagent([creds]) {
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141:${cmd}'
    }
}
