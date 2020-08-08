#!/bin/bash
# Package and upload lambda to S3, require your own configuration

S3Bucket="s3://test-cdk-functions"
HelloFunctionJar="target/sample-lambda-1.0-SNAPSHOT.jar"
AwsProfile="test-lambdas"
mvn package shade:shade

aws s3 cp $HelloFunctionJar $S3Bucket --profile $AwsProfile