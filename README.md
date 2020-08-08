# Sample-cdk-app project: Sample lambda function that send a json message when make request from an endpoint

## What is this?
This a simple app to learn how to work cdk and create a cdk stack and lambda function with API gateway endpoint.

## Instructions
Deploy cloud infrastructure on AWS

Root directory sample-cdk-app which is an AWS CDK project, here you will need the following requirements.

- Need an AWS account with permissions to deploy all services, for detail see the CDK Stack implementation in this project.
- HAve AWS cli installed and configuration already set locally for cdk deploy to pick it up
- Will need S3 bucket to hold package lambda. Refer to script `sample-lambda/package-and-upload-lambda.sh`
- This is a maven project, make sure to have maven installed to build the project.

sample setup:

```bash
# from /project-root
mvn package

# from sample-cdk-app/sample-lambda
# this package and upload lambda jar file into S3 bucket, this will be picked up by CDK stack
./package-and-upload-lambda.sh

# provision everython on AWS as a Stack
cdk deploy --profile `your-aws-profile`
```