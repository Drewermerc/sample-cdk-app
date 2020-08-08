package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class SampleCdkAppApp {
    public static void main(final String[] args) {
        App app = new App();

        new SampleCdkAppStack(app, "SampleCdkAppStack");

        app.synth();
    }
}
