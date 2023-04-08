# Chatastic Core

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