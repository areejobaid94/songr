package com.example.songr.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Stretch Goals
public class Service {
    public static String getJsonFromAPI(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        String content = "";
        if(status == 200) {
            BufferedReader reader = getBufferedReader(connection);
            content = getContent(reader);
            reader.close();
        } else{
            System.out.println("Error in the API");
        }

        connection.disconnect();

        return content;
    }
    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }
    private static String getContent(BufferedReader reader) throws IOException {    //String vs StringBuilder
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();

        while(currentLine != null){
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        return builder.toString();
    }
}