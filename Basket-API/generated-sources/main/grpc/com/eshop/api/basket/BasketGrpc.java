package com.eshop.api.basket;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.1.2)",
    comments = "Source: basket.proto")
public class BasketGrpc {

  private BasketGrpc() {}

  public static final String SERVICE_NAME = "BasketApi.Basket";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.eshop.api.basket.BasketOuterClass.BasketRequest,
      com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> METHOD_GET_BASKET_BY_ID =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "BasketApi.Basket", "GetBasketById"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.basket.BasketOuterClass.BasketRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest,
      com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> METHOD_UPDATE_BASKET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "BasketApi.Basket", "UpdateBasket"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BasketStub newStub(io.grpc.Channel channel) {
    return new BasketStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BasketBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BasketBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static BasketFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BasketFutureStub(channel);
  }

  /**
   */
  public static abstract class BasketImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBasketById(com.eshop.api.basket.BasketOuterClass.BasketRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BASKET_BY_ID, responseObserver);
    }

    /**
     */
    public void updateBasket(com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_BASKET, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_BASKET_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.eshop.api.basket.BasketOuterClass.BasketRequest,
                com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse>(
                  this, METHODID_GET_BASKET_BY_ID)))
          .addMethod(
            METHOD_UPDATE_BASKET,
            asyncUnaryCall(
              new MethodHandlers<
                com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest,
                com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse>(
                  this, METHODID_UPDATE_BASKET)))
          .build();
    }
  }

  /**
   */
  public static final class BasketStub extends io.grpc.stub.AbstractStub<BasketStub> {
    private BasketStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BasketStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BasketStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BasketStub(channel, callOptions);
    }

    /**
     */
    public void getBasketById(com.eshop.api.basket.BasketOuterClass.BasketRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BASKET_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateBasket(com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_BASKET, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BasketBlockingStub extends io.grpc.stub.AbstractStub<BasketBlockingStub> {
    private BasketBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BasketBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BasketBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BasketBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse getBasketById(com.eshop.api.basket.BasketOuterClass.BasketRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BASKET_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse updateBasket(com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_BASKET, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BasketFutureStub extends io.grpc.stub.AbstractStub<BasketFutureStub> {
    private BasketFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BasketFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BasketFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BasketFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> getBasketById(
        com.eshop.api.basket.BasketOuterClass.BasketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BASKET_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse> updateBasket(
        com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_BASKET, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BASKET_BY_ID = 0;
  private static final int METHODID_UPDATE_BASKET = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BasketImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(BasketImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BASKET_BY_ID:
          serviceImpl.getBasketById((com.eshop.api.basket.BasketOuterClass.BasketRequest) request,
              (io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse>) responseObserver);
          break;
        case METHODID_UPDATE_BASKET:
          serviceImpl.updateBasket((com.eshop.api.basket.BasketOuterClass.CustomerBasketRequest) request,
              (io.grpc.stub.StreamObserver<com.eshop.api.basket.BasketOuterClass.CustomerBasketResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BasketDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.eshop.api.basket.BasketOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BasketGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BasketDescriptorSupplier())
              .addMethod(METHOD_GET_BASKET_BY_ID)
              .addMethod(METHOD_UPDATE_BASKET)
              .build();
        }
      }
    }
    return result;
  }
}
