package PrimeiroDia;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DesafioRequest {
    public static void main(String[] args) {
        String chave = "k_eyh1xl7v";
        StringBuilder uri = new StringBuilder("https://imdb-api.com/en/API/Top250Movies/").append(chave);
//        System.out.println("Insira a chave para realizar a pesquisa: ");
//        Scanner scanner = new Scanner(System.in);
//        String chave = scanner.next();
//        scanner.close();
        try{

            System.out.println(new DesafioRequest().buscarJson250TopFilmes(new URI(uri.toString()),chave).body());
        }catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public HttpResponse<String> buscarJson250TopFilmes(URI uri, String chave) throws IOException, InterruptedException, URISyntaxException {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(uri.toString())).GET().build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
            return httpResponse;
    }
}
