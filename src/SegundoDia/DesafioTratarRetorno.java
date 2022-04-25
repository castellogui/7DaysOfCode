package SegundoDia;

import Enums.Atributos;
import PrimeiroDia.DesafioRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DesafioTratarRetorno {

    public static void main(String[] args) {
        String chave = "k_eyh1xl7v";
        StringBuilder uri = new StringBuilder("https://imdb-api.com/en/API/Top250Movies/").append(chave);
        DesafioRequest desafioRequest = new DesafioRequest();
        try{
            HttpResponse<String> httpResponse = desafioRequest.buscarJson250TopFilmes(new URI(uri.toString()),chave);
            String json = formatarJson(httpResponse.body());
            String[] arrayFilmes = extrairArrayFilmesSeparados(json);

            List<String> titulos = extrairAtributos(arrayFilmes, new ArrayList<>(), Atributos.TITULO);
            List<String> urlImagens = extrairAtributos(arrayFilmes, new ArrayList<>(), Atributos.IMAGEM);
            List<String> rating = extrairAtributos(arrayFilmes, new ArrayList<>(), Atributos.RATING);
            List<String> ano = extrairAtributos(arrayFilmes, new ArrayList<>(), Atributos.ANO);

            System.out.println(titulos);
            System.out.println(urlImagens);
            System.out.println(rating);
            System.out.println(ano);
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<String> extrairAtributos(String[] arrayFilmes, ArrayList<String> lista, Atributos tipoAtributo) {
        for (String filme:arrayFilmes) {
            String atributo = filme.split("\",\"")[tipoAtributo.getValue()].substring(filme.split("\",\"")[tipoAtributo.getValue()].indexOf(":")+1).replaceAll("\"","");
            lista.add(atributo);
        }
        return lista;
    }
    private static String[] extrairArrayFilmesSeparados(String json) {
        return json.split("},");
    }

    private static String formatarJson(String json) {
        return json.substring(json.indexOf("[")+1, json.indexOf("]"));
    }

}
