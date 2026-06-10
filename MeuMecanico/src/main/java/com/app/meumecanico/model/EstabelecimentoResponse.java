package com.app.meumecanico.model;

public class EstabelecimentoResponse {

    private String nome;
    private String telefone;
    private double latitude;
    private double longitude;
    private double distanciaKm;

    public EstabelecimentoResponse(String nome, String telefone,
                                   double latitude, double longitude,
                                   double distanciaKm) {
        this.nome = nome;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanciaKm = distanciaKm;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double getDistanciaKm() { return distanciaKm; }
}