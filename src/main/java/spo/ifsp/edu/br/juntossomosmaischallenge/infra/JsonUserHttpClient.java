package spo.ifsp.edu.br.juntossomosmaischallenge.infra;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.configuration.UriConfiguration;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.helpers.JsonUserHelper;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.IUserHttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class JsonUserHttpClient implements IUserHttpClient {

    private HttpClient httpClient;

    private UriConfiguration uriConfiguration;

    public JsonUserHttpClient() {
        this.httpClient =  HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        this.uriConfiguration = new UriConfiguration();
    }

    @Override
    public List<User> getUsers() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json"))
                .header("accept", "app")
                .GET()
                .build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        List<User> users = JsonUserHelper.getUsersFromJson(response.body().toString());
        return users;
    }
}
