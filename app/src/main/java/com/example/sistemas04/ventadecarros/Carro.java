package com.example.sistemas04.ventadecarros;
/**
 * Created by sistemas04 on 10/05/2017.
 */

public class Carro {
    String Foto;
    String Placa;
    String Marca;
    int Modelo;
    String Color;
    int Precio;

    public Carro(String foto, String placa, String marca, int modelo, String color, int precio) {
        Foto = foto;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Color = color;
        Precio = precio;
    }

    public String getFoto() {

        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
