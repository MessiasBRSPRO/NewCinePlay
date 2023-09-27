import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class SaveInJson {
    Gson archive = new Gson().newBuilder()
            .setPrettyPrinting()
            .create();

    public void writeJsonFile(Movie movie) throws IOException {
        FileWriter savesMovies = new FileWriter("SearchHistoryMovie.json");
        savesMovies.write(archive.toJson(movie));
        savesMovies.close();
    };

}
