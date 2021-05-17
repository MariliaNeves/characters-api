package com.charactersapi.enuns;

public enum EnumTipoActivity {

    COMICS(1, "Comics"),
    EVENTS(2, "Events"),
    SERIES(3, "Series"),
    STORIES(4, "Stories");

    private int value;
    private String nome;

    public static EnumTipoActivity getEnum(int value){
        switch (value){
            case 1:
                return COMICS;
            case 2:
                return EVENTS;
            case 3:
                return SERIES;
            case 4:
                return STORIES;
            default:
                return null;
        }
    }

    EnumTipoActivity(int value, String nome) {
        this.value = value;
        this.nome = nome;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
