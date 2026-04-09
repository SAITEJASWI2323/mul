package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.net.*;

public class AppTest {
    @Test
    public void testServerResponse() throws IOException, InterruptedException {
        // Start server in a background thread for testing
        Thread serverThread = new Thread(() -> new App().start(8888));
        serverThread.setDaemon(true);
        serverThread.start();

        Thread.sleep(1000); // Wait for server to bind

        try (Socket socket = new Socket("localhost", 8888);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            out.println("hello");
            assertEquals("world", in.readLine());
        }
    }
}
