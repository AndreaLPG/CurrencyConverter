package org.example;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryCurrency {

    public double converter(String base_code, String target_code){
        String apiKey = "f72ea0341caf5ae9f153941b";
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"+base_code+"/"+target_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();


        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("The currency doesn´t exist");
        }


    }
}
