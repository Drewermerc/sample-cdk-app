package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.FunctionProps;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.s3.Bucket;

public class SampleCdkAppStack extends Stack {
    public SampleCdkAppStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public SampleCdkAppStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Get source code from S3 bucket
        Code sourceCode = Code.fromBucket(
                Bucket.fromBucketName(this,
                        "code-hello",
                        "test-cdk-functions"),
                "sample-lambda-1.0-SNAPSHOT.jar"
        );

        // Lambda properties
        FunctionProps properties = FunctionProps.builder()
                .runtime(Runtime.JAVA_8)
                .code(sourceCode)
                .handler("HelloFunction::handleRequest")
                .build();

        //Define a new lambda resource
        final Function hello = new Function(this, "FunctionHandler", properties);

        // Define a endpoint
        LambdaRestApi.Builder.create(this, "Endpoint")
                .handler(hello)
                .build();
    }
}
