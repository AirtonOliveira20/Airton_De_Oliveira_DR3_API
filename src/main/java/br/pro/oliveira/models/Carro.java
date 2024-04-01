package br.pro.oliveira.models;

public class Carro {
    public long id;
    public String modelo;
    public String fabricante;
    public String cor;


    public Carro(String modelo, String fabricante, String cor) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
    }

    public Carro(long id, String modelo, String fabricante, String cor) {
        this(modelo, fabricante,cor);
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
