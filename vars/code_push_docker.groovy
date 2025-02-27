def call(String credId , String ImageId)
{
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
                sh "docker image tag ${ImageId} ${env.dockerHubUser}/${ImageId}"
                sh "docker push ${env.dockerHubUser}/${ImageId}"
}
