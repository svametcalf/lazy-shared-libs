#!/usr/bin/groovy

def call(closure){
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
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
