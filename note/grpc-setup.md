# Spring Boot 4 gRPC Setup Guide

## Step 1: Add (lots of) Dependencies

Add the following dependencies to your `build.gradle` file:

```groovy

plugins {
    id 'com.google.protobuf' version '0.9.6'
}

dependencies {
    
    // Spring Boot gRPC starter
    implementation 'net.devh:grpc-server-spring-boot-starter:3.1.0.RELEASE'

    // grpc core
    implementation 'io.grpc:grpc-stub:1.60.0'
    implementation 'io.grpc:grpc-protobuf:1.60.0'

    // needed for grpc with java 17+
    compileOnly 'org.apache.tomcat:annotations-api:6.0.53'
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        grpc {
            artifact = 'io.grpc:protoc-gen-grpc-java:1.60.0'
        }
    }
    generateProtoTasks {
        all()*.plugins {
            grpc {}
        }
    }
}

```

# Step 2: Create Your .proto File

`src/main/proto/helloworld.proto`

```proto
syntax = "proto3";

option java_multiple_files = true;
option java_package = "com.example.demo.grpc";

service SimpleService {
  rpc SayHello (HelloRequest) returns (HelloReply) {}
}

message HelloRequest {
  string firstName = 1;
  string lastName = 2;
}

message HelloReply {
  string greeting = 1;
}
```

after creating the proto file, run `./gradlew build` to generate the gRPC classes.

# Step 3: Implement the gRPC Service

```java
@GrpcService
@Slf4j
public class SimpleGrpcService extends SimpleServiceGrpc.SimpleServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello " + request.getFirstName() + " " + request.getLastName();
        log.info("received request from: {}", request.getFirstName());

        HelloReply reply = HelloReply.newBuilder()
                .setGreeting(message)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
```
You can test with a gRPC client like BloomRPC or Postman.
