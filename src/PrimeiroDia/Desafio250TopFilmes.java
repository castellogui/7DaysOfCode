package PrimeiroDia;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio250TopFilmes {
    public static void main(String[] args) {
        System.out.println("Insira a chave para realizar a pesquisa: ");
        Scanner scanner = new Scanner(System.in);
        String chave = scanner.next();
        scanner.close();
        //String chave = "";

        StringBuilder uri = new StringBuilder("https://imdb-api.com/en/API/Top250Movies/").append(chave);
        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(uri.toString())).GET().build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = httpResponse.body();
            //TODO FAZER TRATAMENTO DO RETORNO

        }catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e + "\nErro ao construir requisição.");
        }
    }
}
