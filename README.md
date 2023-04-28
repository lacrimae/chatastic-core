# Chatastic Core

## Design Notes

### Storing Data

To improve scalability and ensure fault tolerance, we utilize Kafka to store messages in a separate topic. A dedicated
service retrieves messages from that topic and periodically saves them to MongoDB. This approach reduces the number of
write operations to the database, improving scalability. Additionally, it guarantees that even if the server or
application crashes, messages will not be lost. This design ensures high availability and fault tolerance in our chat
application.

## Generate the Java code from proto

   ```bash
    protoc --java_out=. *.proto
   ```

## WebSocket Connection Testing

1. To test your WebSocket connection, make sure that you have `socat` installed on your machine. If you don't
   have `socat`installed, you can install it using your package manager or by following the instructions on the official
   socat website.

   ```bash
    brew install socat
   ```

2. Once socat is installed, you can use it to test your WebSocket server by running the following command in your
   terminal:

   ```bash
   socat - TCP4:<host>:<port>
   ```
   ```
   socat - TCP4:localhost:8081
   ```

3. Once the connection is established, you can send and receive messages using the terminal.