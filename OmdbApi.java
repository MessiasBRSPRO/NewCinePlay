
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbApi {
    public Movie searchMovie(String movieName) throws IOException, InterruptedException {
        String apiAndress = "http://www.omdbapi.com/?t="+ movieName.replace(" ", "+")+"&apikey=5c92a716";;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiAndress))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        var serverResponse = response.body().toLowerCase();
        return new Gson().fromJson(serverResponse, Movie.class);

    };
}
