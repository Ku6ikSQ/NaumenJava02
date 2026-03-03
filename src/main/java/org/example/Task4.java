package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {
    private static final String URL = "https://httpbin.org/user-agent";

    public void run() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            String userAgent = extractUserAgent(json);

            System.out.println("[Task4]: User-Agent = " + userAgent);

        } catch (IOException | InterruptedException e) {
            System.out.println("[Task4]: Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    private String extractUserAgent(String json) {
        Pattern pattern = Pattern.compile("\"user-agent\"\\s*:\\s*\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Не удалось извлечь user-agent";
    }
}