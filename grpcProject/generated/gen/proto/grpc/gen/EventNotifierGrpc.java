package gen.proto.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.0)",
    comments = "Source: event.proto")
public final class EventNotifierGrpc {

  private EventNotifierGrpc() {}

  public static final String SERVICE_NAME = "event.EventNotifier";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gen.proto.grpc.gen.EventType,
      gen.proto.grpc.gen.Event> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = gen.proto.grpc.gen.EventType.class,
      responseType = gen.proto.grpc.gen.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<gen.proto.grpc.gen.EventType,
      gen.proto.grpc.gen.Event> getSubscribeMethod() {
    io.grpc.MethodDescriptor<gen.proto.grpc.gen.EventType, gen.proto.grpc.gen.Event> getSubscribeMethod;
    if ((getSubscribeMethod = EventNotifierGrpc.getSubscribeMethod) == null) {
      synchronized (EventNotifierGrpc.class) {
        if ((getSubscribeMethod = EventNotifierGrpc.getSubscribeMethod) == null) {
          EventNotifierGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<gen.proto.grpc.gen.EventType, gen.proto.grpc.gen.Event>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.proto.grpc.gen.EventType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.proto.grpc.gen.Event.getDefaultInstance()))
              .setSchemaDescriptor(new EventNotifierMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventNotifierStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventNotifierStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventNotifierStub>() {
        @java.lang.Override
        public EventNotifierStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventNotifierStub(channel, callOptions);
        }
      };
    return EventNotifierStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventNotifierBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventNotifierBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventNotifierBlockingStub>() {
        @java.lang.Override
        public EventNotifierBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventNotifierBlockingStub(channel, callOptions);
        }
      };
    return EventNotifierBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventNotifierFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventNotifierFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventNotifierFutureStub>() {
        @java.lang.Override
        public EventNotifierFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventNotifierFutureStub(channel, callOptions);
        }
      };
    return EventNotifierFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EventNotifierImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(gen.proto.grpc.gen.EventType request,
        io.grpc.stub.StreamObserver<gen.proto.grpc.gen.Event> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                gen.proto.grpc.gen.EventType,
                gen.proto.grpc.gen.Event>(
                  this, METHODID_SUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class EventNotifierStub extends io.grpc.stub.AbstractAsyncStub<EventNotifierStub> {
    private EventNotifierStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventNotifierStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventNotifierStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(gen.proto.grpc.gen.EventType request,
        io.grpc.stub.StreamObserver<gen.proto.grpc.gen.Event> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventNotifierBlockingStub extends io.grpc.stub.AbstractBlockingStub<EventNotifierBlockingStub> {
    private EventNotifierBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventNotifierBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventNotifierBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<gen.proto.grpc.gen.Event> subscribe(
        gen.proto.grpc.gen.EventType request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventNotifierFutureStub extends io.grpc.stub.AbstractFutureStub<EventNotifierFutureStub> {
    private EventNotifierFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventNotifierFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventNotifierFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventNotifierImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventNotifierImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((gen.proto.grpc.gen.EventType) request,
              (io.grpc.stub.StreamObserver<gen.proto.grpc.gen.Event>) responseObserver);
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

  private static abstract class EventNotifierBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventNotifierBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gen.proto.grpc.gen.EventProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventNotifier");
    }
  }

  private static final class EventNotifierFileDescriptorSupplier
      extends EventNotifierBaseDescriptorSupplier {
    EventNotifierFileDescriptorSupplier() {}
  }

  private static final class EventNotifierMethodDescriptorSupplier
      extends EventNotifierBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventNotifierMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventNotifierGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventNotifierFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
