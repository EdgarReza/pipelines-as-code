def call(Map pipelineParams) {
    pipeline {
        agent none

        stages {
            stage('Build and Unit test') {
                agent any
                steps {
                    script {
                        module_Maven('clean verify')
                    }
                }
                
            }
            stage('Publish to Nexus') {
                agent any
                steps {
                    script {
                        echo "This is where we publish to Nexus"
                        module_Artifact.publish()
                    }
                }
            }
        }
        
    }
}