package Modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Producto {

    private String id;

    @SerializedName("title")
    private String titulo;

    @SerializedName("available_quantity")
    private Integer stock;

    @SerializedName("warranty")
    private String garantia;

    @SerializedName("sold_quantity")
    private Integer vendidos;

    @SerializedName("condition")
    private String condicion;

    @SerializedName("pictures")
    private List<Imagen> imagenes;

    @SerializedName("price")
    private Double precio;

    @SerializedName("thumbnail")
    private String urlImagenMiniatura;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Integer getVendidos() {
        return vendidos;
    }

    public void setVendidos(Integer vendidos) {
        this.vendidos = vendidos;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrlImagenMiniatura() {
        return urlImagenMiniatura;
    }

    public void setUrlImagenMiniatura(String urlImagenMiniatura) {
        this.urlImagenMiniatura = urlImagenMiniatura;
    }
}
