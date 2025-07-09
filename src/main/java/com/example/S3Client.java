package com.example;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3Client
{
    public static void main(String[] args) {
        String accessKey = "minioadmin";
        String secretKey = "minioadmin";
        String endpoint = "https://nginx:9000";
        String region = "eu-west-1";
        String bucketName = "test-bucket";
        String objectKey = "test3.txt";
        String filePath = "test3.txt";

        BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);

        AwsClientBuilder.EndpointConfiguration endpointConfig =
                new AwsClientBuilder.EndpointConfiguration(endpoint, region);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig)
                .withPathStyleAccessEnabled(true)
                .withClientConfiguration(new ClientConfiguration())
                .withCredentials(new AWSStaticCredentialsProvider(creds))
                .build();

        try {
            s3Client.putObject(new PutObjectRequest(bucketName, objectKey, new File(filePath)));
            System.out.println("\nUpload complete.\n");
        } finally {
            s3Client.shutdown();
        }
    }
}
