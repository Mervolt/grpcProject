import event_pb2
import event_pb2_grpc
import grpc
import threading
import logging
import event_pb2
import event_pb2_grpc
import time

def create_request():
    try:
        for response in stub.subscribe(event):
            print("-------------------------------------")
            print(response)
            print("-------------------------------------")
    except grpc._channel._Rendezvous as err:
        print("Connection down - Trying to reconnect")
        listen_for_response()


def listen_for_response():
    threading.Thread(target=create_request, daemon=True,
                     args=[]).start()
    while True:
        pass

logging.basicConfig()
# open a gRPC channel
channel = grpc.insecure_channel('localhost:50052')


# create a stub (client)
stub = event_pb2_grpc.EventNotifierStub(channel)
print("Connected to server")
print("Please write subscription in format City-Subject.. Leave blank if you want all e.g. all Cities job -> -Job")
wantedSub = input()
sub = wantedSub.split("-")

# create a valid request message
event = event_pb2.EventType(city=sub[0], subject=sub[1])

listen_for_response()


