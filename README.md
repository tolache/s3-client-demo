# S3 Client Demo

Minimal Java app to upload files to S3-compatible storage (e.g., MinIO) using AWS SDK v1.

## Prerequisites

- Java 8 or higher
- Maven 3.5+

## Configure

In `src/main/java/com/example/S3Client.java`, set your values:
```java
String accessKey   = "<YOUR_ACCESS_KEY>";
String secretKey   = "<YOUR_SECRET_KEY>";
String endpoint    = "https://<HOST>:<PORT>";
String region      = "<REGION>";
String bucketName  = "<BUCKET_NAME>";
String objectKey   = "<OBJECT_KEY>";
String filePath    = "<LOCAL_FILE_PATH>";
```

## Build & Run

```bash
mvn clean compile exec:java
```

This command compiles the project and runs `S3Client`, uploading the file at `filePath` to `bucketName` with the key `objectKey`.

