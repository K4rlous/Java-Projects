package com.app.meumecanico.model;

public class Estabelecimento {

    private String nome;
    private String telefone;
    private double latitude;
    private double longitude;

    public Estabelecimento(String nome, String telefone, double latitude, double longitude) {
        this.nome = nome;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}