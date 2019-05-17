// vim: set filetype=groovy:

pipeline {

  agent {
    kubernetes {
      cloud 'zeebe-ci'
      label "zeebe-ci-build_${env.JOB_BASE_NAME}-${env.BUILD_ID}"
      defaultContainer 'jnlp'
      yaml '''\
apiVersion: v1
kind: Pod
metadata:
  labels:
    agent: zeebe-ci-build
spec:
  nodeSelector:
    cloud.google.com/gke-nodepool: slaves
  tolerations:
    - key: "slaves"
      operator: "Exists"
      effect: "NoSchedule"
  containers:
    - name: maven
      image: maven:3.6.0-jdk-8
      command: ["cat"]
      tty: true
      resources:
        limits:
          cpu: 1
          memory: 1Gi
        requests:
          cpu: 1
          memory: 1Gi
'''
    }
  }

  environment {
    NEXUS = credentials('camunda-nexus')
  }

  parameters {
    booleanParam(name: 'RELEASE', defaultValue: false, description: 'Build a release from current commit?')
    string(name: 'RELEASE_VERSION', defaultValue: '0.1.0', description: 'Which version to release?')
    string(name: 'DEVELOPMENT_VERSION', defaultValue: '0.2.0-SNAPSHOT', description: 'Next development version?')
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '10'))
    timestamps()
    timeout(time: 15, unit: 'MINUTES')
  }

  stages {
    stage('Build') {
      steps {
        container('maven') {
            sh 'mvn -B -s .ci/settings.xml clean verify'
        }
      }

      post {
        always {
          junit testResults: "**/*/TEST-*.xml", keepLongStdio: true
        }
      }
    }

    stage('Upload') {
      steps {
        container('maven') {
            sh 'mvn -B -s .ci/settings.xml deploy'
        }
      }
    }

    stage('Release') {
      when {
        expression { params.RELEASE }
      }

      environment {
        NEXUS = credentials('maven_central_deployment_credentials')
        GPG_PASS = credentials('password_maven_central_gpg_signing_key')
        GPG_PUB_KEY = credentials('maven_central_gpg_signing_key_pub')
        GPG_SEC_KEY = credentials('maven_central_gpg_signing_key_sec')
      }

      steps {
        container('maven') {
          sh 'apt-get update && apt-get install gnupg'
          sh 'gpg -q --import ${GPG_PUB_KEY} '
          sh 'gpg -q --allow-secret-key-import --import ${GPG_SEC_KEY}'
          sh "mvn -B -s .ci/settings.xml -DskipTests -DdryRun=true release:prepare -DreleaseVersion=${params.RELEASE_VERSION} -DdevelopmentVersion=${params.DEVELOPMENT_VERSION} -Dgpg.passphrase=\${GPG_PASS}"
        }
      }
    }
  }
}
