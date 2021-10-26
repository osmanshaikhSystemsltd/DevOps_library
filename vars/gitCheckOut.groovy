def call(String repo, String branch, String CredentialID){
  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '${CredentialID}', url: '${repo}']]])
}
