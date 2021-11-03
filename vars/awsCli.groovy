def call(String cmd, String creds) {
    sshagent([creds]) {
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 echo "GIT"'
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 git --version'
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 echo "CMD"'
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 ${cmd}'
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 echo "AWS Manual Command"'
        sh 'ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null systemsltd@20.74.128.141 aws --version'
    }
}
