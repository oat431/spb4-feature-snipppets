package panomete.project.spb4featsnip.gprc;

import com.example.demo.grpc.HelloReply;
import com.example.demo.grpc.HelloRequest;
import com.example.demo.grpc.SimpleServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

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
