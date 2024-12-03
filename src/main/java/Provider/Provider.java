package Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Provider<T> {
    private final String url;
    private final Class<T> type;

    public Provider(String url, Class<T> type) {
        this.url = url;
        this.type = type;
    }

    public List<T> getAll() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                response.body(),
                mapper.getTypeFactory().constructCollectionType(List.class, type)
        );
    }
}
