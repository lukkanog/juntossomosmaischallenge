package spo.ifsp.edu.br.juntossomosmaischallenge.infra;

import org.springframework.beans.factory.annotation.Autowired;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.configuration.UriConfiguration;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.helpers.CsvUserHelper;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.IUserHttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class CsvUserHttpClient implements IUserHttpClient {

    private HttpClient httpClient;

    @Autowired
    private UriConfiguration uriConfiguration;

    public CsvUserHttpClient() {
        this.httpClient =  HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        this.uriConfiguration = new UriConfiguration();
    }

    public List<User> getUsers() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv"))
                .header("accept", "app")
                .GET()
                .build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        List<User> users = CsvUserHelper.getUsersFromCsv(response.body().toString());
        return users;
    }
}
