node {
    stage "Checkout"
    projectRootDirectory = pwd()
    println ("project root: " + projectRootDirectory)
    println ("cleaning project root: " + projectRootDirectory)
    sh "sudo rm -rf ${projectRootDirectory} || true ; mkdir -p ${projectRootDirectory}"
    checkout scm
    withCredentials([string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY'),
                     string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_KEY')]) {
        parameters {
            string(name: 'TERRAFORM_FILE', defaultValue: 'tim.tf', description: 'Specify the Terraform file to run')
            string(name: 'TARGET_NAME', defaultValue: 'www-rr', description: 'Target Name of the CNAME')
            string(name: 'TARGET_RECORD', defaultValue: 'prod.example.com', description: 'Target Record')
            string(name: 'NEW_WEIGHT', defaultValue: '0', description: 'New Weight for record change')
        }
        stage('Update file') {
            
      }
    }
}
    
