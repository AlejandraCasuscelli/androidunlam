package Modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Busqueda {

    @SerializedName("results")
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
