package Enums;

public enum Atributos {
    TITULO(2),
    IMAGEM(5),
    RATING(7),
    ANO(4);

    private int value;

    Atributos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
