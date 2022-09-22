#!/usr/bin/groovy

def call(closure){
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                node('jenkinsb0'){
                    script {
                        def values = [:]
                    
                        closure.resolveStrategy = Closure.DELEGATE_FIRST
                        closure.delegate = values
                    
                        closure.call(env)
                    
                        echo values.toString()
                    }
                }
                
            }
        }
    }

}
}
