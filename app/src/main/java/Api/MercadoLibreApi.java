package Api;

import Modelo.Busqueda;
import Modelo.Producto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MercadoLibreApi {

    @GET("items/{itemId}")
    Call<Producto> getProducto(@Path("itemId") String id);

    @GET("sites/MLA/search")
    Call<Busqueda> getListadoProductos(@Query("q") String query);
}
