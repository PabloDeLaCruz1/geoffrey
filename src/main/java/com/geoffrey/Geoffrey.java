/**
 * Description: Meet your assistant, Geoffrey. Ask it anything you want. 
 *
 * @author  Pablo De la Cruz
 * @version 1.0
 * @since   2023-22-01
 */

package com.geoffrey;

import java.util.Scanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Geoffrey {
    public static void main(String[] args) throws Exception {
        // Prompt the user for an answer
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your question? ");
        String question = scanner.nextLine();
        scanner.close();

        // Create an OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Build the request
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci/completions")
                .addHeader("Content-Type", "application/json")
              //.addHeader("Authorization", "Bearer " + API_KEY) 
                .addHeader("Authorization", "Bearer " + System.getenv("geoffrey")) 
                .post(RequestBody.create("{\"prompt\":\"" + question + "\",\"max_tokens\":200,\"temperature\":0.6}",
                MediaType.parse("application/json")))
                .build();

        // Execute the request and get the response
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        // Parse the response using Jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(responseString);
        String answer = jsonNode.get("choices").get(0).get("text").asText().trim();
        System.out.println("Answer: " + answer);
    }
}
