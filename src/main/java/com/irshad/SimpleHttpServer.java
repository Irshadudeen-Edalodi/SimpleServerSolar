package com.irshad;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;

public class SimpleHttpServer {

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

    server.createContext("/electricPermitRequest", new ElectricPermitRequestHandler());
    server.createContext("/electricStatusRequest", new ElectricStatusRequestHandler());
    server.createContext("/structuralPermitRequest", new StructuralPermitRequestHandler());
    server.createContext("/structuralStatusRequest", new StructuralStatusRequestHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }



  static class ElectricPermitRequestHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	   
	      String response = "Submitted";
	      t.sendResponseHeaders(200, response.length());
	      OutputStream os = t.getResponseBody();
	      os.write(response.getBytes());
	      os.close();
	    }
	  }
  
  static class StructuralPermitRequestHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	      String response = "Submitted";
	      t.sendResponseHeaders(200, response.length());
	      OutputStream os = t.getResponseBody();
	      os.write(response.getBytes());
	      os.close();
	    }
	  }
 
  static class ElectricStatusRequestHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	      String response = "Approved";
	      t.sendResponseHeaders(200, response.length());
	      OutputStream os = t.getResponseBody();
	      os.write(response.getBytes());
	      os.close();
	    }
	  }

static class StructuralStatusRequestHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	      String response = "Approved";
	      t.sendResponseHeaders(200, response.length());
	      OutputStream os = t.getResponseBody();
	      os.write(response.getBytes());
	      os.close();
	    }
	  }
}