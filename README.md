# ChatApp

ChatApp is a simple Java-based client-server chat application that allows two users to communicate over a network connection.

## Features

- Server-client architecture
- Real-time bidirectional communication
- Simple command-line interface
- Ability to exit the chat gracefully

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Basic understanding of networking concepts

## How to Run

1. Compile both Server.java and Client.java:
   ```
   javac Server.java
   javac Client.java
   ```

2. Start the server:
   ```
   java Server
   ```

3. In a separate terminal, start the client:
   ```
   java Client
   ```

4. Start chatting! Type messages in either the server or client console and press Enter to send.

5. To exit the chat, type "exit" in either the server or client console.

## Project Structure

- `Server.java`: Contains the server-side logic
- `Client.java`: Contains the client-side logic

## How It Works

1. The server starts and listens for incoming connections on port 7777.
2. The client connects to the server using the localhost IP (127.0.0.1) and port 7777.
3. Once connected, both the server and client can send and receive messages.
4. The application uses separate threads for reading and writing messages, allowing simultaneous communication.

## Limitations and Future Improvements

- Currently supports only one client connection at a time.
- No graphical user interface (GUI).
- Limited error handling and recovery.

## Contributing

Feel free to fork this project and submit pull requests with improvements or bug fixes.
