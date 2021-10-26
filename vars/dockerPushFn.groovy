def call(String project, String hubUser, String credentialsId) {
    sshagent(['ssh-jenkins-build-machine']) {
    // some block
        sh 'ssh osmanshaikh@20.54.72.51'
        sh "docker image build -t ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER} ."
        withCredentials([usernamePassword(
                credentialsId: credentialsId,
                usernameVariable: "USER",
                passwordVariable: "PASS"
        )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
    }
}
