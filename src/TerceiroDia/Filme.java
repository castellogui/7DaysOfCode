package TerceiroDia;

public class Filme {
    private String titulo;
    private String url;
    private Double nota;
    private Integer ano;

    public Filme() {
    }

    public Filme(String titulo, String url, Double nota, Integer ano) {
        this.titulo = titulo;
        this.url = url;
        this.nota = nota;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
