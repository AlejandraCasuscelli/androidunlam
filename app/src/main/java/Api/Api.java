package Api;

import com.google.gson.Gson;

import Modelo.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static MercadoLibreApi getApi(){
        Retrofit retrofit = new Retrofit.Builder()

                .addConverterFactory(GsonConverterFactory.create( new Gson() ))
                .baseUrl("https://api.mercadolibre.com/")
                .build();

        return retrofit.create(MercadoLibreApi.class);
    }

    public static void obtenerArticulo(String idArticulo, Callback<Producto> callback){
        Call<Producto> call = getApi().getProducto(idArticulo);
        call.enqueue(callback);
    }
}
