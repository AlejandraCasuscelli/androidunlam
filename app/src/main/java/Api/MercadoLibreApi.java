package Api;

import Modelo.Producto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MercadoLibreApi {

    @GET("items/{itemId}")
    Call<Producto> getProducto(@Path("itemId") String id);

//    @GET("sites/MLA/search")
//    Call<SearchResult> search(@Query("q") String query);
}
