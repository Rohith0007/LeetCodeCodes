import java.util.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSON {
    public static void main(String[] args) {
        System.out.println(function(2011, 2019).toString());
    }
    public static List<String> function(int startDate, int endDate) {
        List<String> ls = new ArrayList<>();
        String url = "https://jsonmock.hackerrank.com/api/tvseries";

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                System.out.println(responseBody);
            } else {
                System.out.println("Failed to retrieve data. Response Code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return ls;
    }
}
