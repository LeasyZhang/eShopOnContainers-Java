package com.eshop.api.catalog;

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
    comments = "Source: catalog.proto")
public class CatalogGrpc {

  private CatalogGrpc() {}

  public static final String SERVICE_NAME = "CatalogApi.Catalog";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest,
      com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse> METHOD_GET_ITEM_BY_ID =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "CatalogApi.Catalog", "GetItemById"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest,
      com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse> METHOD_GET_ITEMS_BY_IDS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "CatalogApi.Catalog", "GetItemsByIds"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatalogStub newStub(io.grpc.Channel channel) {
    return new CatalogStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CatalogBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CatalogFutureStub(channel);
  }

  /**
   */
  public static abstract class CatalogImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * &gt;&gt;
     *option (google.api.http) = {
     *get: "/api/v1/catalog/items/{id}"
     *};
     *&lt;&lt; 
     * </pre>
     */
    public void getItemById(com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ITEM_BY_ID, responseObserver);
    }

    /**
     */
    public void getItemsByIds(com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ITEMS_BY_IDS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ITEM_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest,
                com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse>(
                  this, METHODID_GET_ITEM_BY_ID)))
          .addMethod(
            METHOD_GET_ITEMS_BY_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest,
                com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse>(
                  this, METHODID_GET_ITEMS_BY_IDS)))
          .build();
    }
  }

  /**
   */
  public static final class CatalogStub extends io.grpc.stub.AbstractStub<CatalogStub> {
    private CatalogStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CatalogStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CatalogStub(channel, callOptions);
    }

    /**
     * <pre>
     * &gt;&gt;
     *option (google.api.http) = {
     *get: "/api/v1/catalog/items/{id}"
     *};
     *&lt;&lt; 
     * </pre>
     */
    public void getItemById(com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ITEM_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getItemsByIds(com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest request,
        io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ITEMS_BY_IDS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CatalogBlockingStub extends io.grpc.stub.AbstractStub<CatalogBlockingStub> {
    private CatalogBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CatalogBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CatalogBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &gt;&gt;
     *option (google.api.http) = {
     *get: "/api/v1/catalog/items/{id}"
     *};
     *&lt;&lt; 
     * </pre>
     */
    public com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse getItemById(com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ITEM_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse getItemsByIds(com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ITEMS_BY_IDS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CatalogFutureStub extends io.grpc.stub.AbstractStub<CatalogFutureStub> {
    private CatalogFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CatalogFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CatalogFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &gt;&gt;
     *option (google.api.http) = {
     *get: "/api/v1/catalog/items/{id}"
     *};
     *&lt;&lt; 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse> getItemById(
        com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ITEM_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse> getItemsByIds(
        com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ITEMS_BY_IDS, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ITEM_BY_ID = 0;
  private static final int METHODID_GET_ITEMS_BY_IDS = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CatalogImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(CatalogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ITEM_BY_ID:
          serviceImpl.getItemById((com.eshop.api.catalog.CatalogOuterClass.CatalogItemRequest) request,
              (io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.CatalogItemResponse>) responseObserver);
          break;
        case METHODID_GET_ITEMS_BY_IDS:
          serviceImpl.getItemsByIds((com.eshop.api.catalog.CatalogOuterClass.CatalogItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.eshop.api.catalog.CatalogOuterClass.PaginatedItemsResponse>) responseObserver);
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

  private static final class CatalogDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.eshop.api.catalog.CatalogOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CatalogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatalogDescriptorSupplier())
              .addMethod(METHOD_GET_ITEM_BY_ID)
              .addMethod(METHOD_GET_ITEMS_BY_IDS)
              .build();
        }
      }
    }
    return result;
  }
}
