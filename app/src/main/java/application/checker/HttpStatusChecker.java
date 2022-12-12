package application.checker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String URI_PATH = "https://http.cat/";

    public String getStatusImage(int code) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URI_PATH + code))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            throw new FileNotFoundException("There is not image for HTTP status " + code);
        } else {
            return "https://http.cat/" + code + ".jpg";
        }
    }
}
