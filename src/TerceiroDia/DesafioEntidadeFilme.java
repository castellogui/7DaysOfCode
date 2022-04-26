package TerceiroDia;

import Enums.Atributos;
import PrimeiroDia.DesafioRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class DesafioEntidadeFilme {

    public static void main(String[] args) {
        String chave = "k_eyh1xl7v";
        StringBuilder uri = new StringBuilder("https://imdb-api.com/en/API/Top250Movies/").append(chave);
        DesafioRequest desafioRequest = new DesafioRequest();
        try{
            HttpResponse<String> httpResponse = desafioRequest.buscarJson250TopFilmes(new URI(uri.toString()),chave);
            String json = formatarJson(httpResponse.body());
            String[] arrayFilmes = extrairArrayFilmesSeparados(json);

            List<Filme>filmes = criarListaDeFilmes(arrayFilmes);
            for(Filme filme : filmes){
                System.out.println("Titulo: "+filme.getTitulo()+"\n"+"URL Imagem: "+filme.getUrl()+"\n"+
                        "Rating: "+ filme.getNota()+"\n"+ "Ano: "+filme.getAno()+"\n");
            }
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Filme> criarListaDeFilmes(String[] arrayFilmes) {
        List<Filme>listaDeFilmes = new ArrayList<>();
        for (String filmeInfos:arrayFilmes) {
            Atributos[] lista = Atributos.values();
            Filme filme = new Filme();
            for(Atributos atributo:lista){
                extrairESetarAtributos(filmeInfos, filme, atributo);
            }
            listaDeFilmes.add(filme);
        }
        return listaDeFilmes;
    }

    private static void extrairESetarAtributos(String filmeInfos, Filme filme, Atributos tipoAtributo) {
        String atributo = filmeInfos.split("\",\"")[tipoAtributo.getValue()].substring(filmeInfos.split("\",\"")[tipoAtributo.getValue()].indexOf(":")+1).replaceAll("\"","");
        switch (tipoAtributo){
            case TITULO:
                filme.setTitulo(atributo);
                break;
            case IMAGEM:
                filme.setUrl(atributo);
                break;
            case ANO:
                filme.setAno(Integer.parseInt(atributo));
                break;
            case RATING:
                filme.setNota(Double.parseDouble(atributo));
                break;
        }
    }
    private static String[] extrairArrayFilmesSeparados(String json) {
        return json.split("},");
    }

    private static String formatarJson(String json) {
        return json.substring(json.indexOf("[")+1, json.indexOf("]"));
    }
}
