package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class DummyServer {
    public static void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpHandler getServerStatus = DummyServer::getServerStatus;
        server.createContext("/", getServerStatus);
    }

    static void getServerStatus(HttpExchange exchange) throws IOException {
        String resp = "Bot is running!";
        exchange.sendResponseHeaders(200, resp.getBytes().length);
        exchange.getResponseBody().write(resp.getBytes());
        exchange.close();
    }
}
