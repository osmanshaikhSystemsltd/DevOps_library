def call(String project, String hubUser, String credentialsId) {
    sshagent(['ssh-jenkins-build-machine']) {
    // some block
        sh 'ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51'
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'whoami'"
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'pwd'"
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'ls'"
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'docker ps'"        
        sh "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no osmanshaikh@20.54.72.51 'docker image build -t ${hubUser}/${project}:beta-"branch"-${env.BUILD_NUMBER} $WORKSPACE'"
        withCredentials([usernamePassword(
                credentialsId: credentialsId,
                usernameVariable: "USER",
                passwordVariable: "PASS"
        )]) {
        sh "docker login -u '$USER' -p '$PASS'"
        sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        }
    }
}
