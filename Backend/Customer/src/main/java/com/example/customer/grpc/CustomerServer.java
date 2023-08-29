package com.example.customer.grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


public class CustomerServer {
    private Server server;
    public void startServer(){
        int port = 9095;
         try {
            server = ServerBuilder.forPort(port)
                    .addService(new CustomerService())
                    .build()
                    .start();
            System.out.println("grpc server started");

            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    
                    try {
                        CustomerServer.this.stopServer();
                    } catch (InterruptedException exception) {
                       System.out.println("Server shutdown interrupted");
                    }
                }
            });
        } catch (IOException exception) {
         System.out.println(exception); 
        }
    }
    public void stopServer() throws InterruptedException {
        if(server!=null){
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if(server!=null){
            server.awaitTermination();
        }
    }
}
