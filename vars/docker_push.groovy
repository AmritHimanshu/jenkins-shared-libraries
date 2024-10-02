def call(String dockerHubUser, String ProjectName, String ImageTag){
  withCredentials([usernamePassword(credentialsId:'DockerHubCred', passwordVariable:'dockerHubPass', usernameVariable:'dockerHubUser')]){
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${ProjectName}:${ImageTag}"
}
