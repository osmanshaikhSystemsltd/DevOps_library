#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils

def print(String msg){
    echo ${msg}
}

def dockerPush(String project, String hubUser, String credentialsId) {
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
