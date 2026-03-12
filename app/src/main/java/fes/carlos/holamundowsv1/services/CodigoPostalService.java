package fes.carlos.holamundowsv1.services;

import java.util.List;

import fes.carlos.holamundowsv1.models.CodigoPostalModel;
import fes.carlos.holamundowsv1.models.EstadoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class CodigoPostalService {
    private static final String BASE_URL = "https://utilidades.vmartinez84.xyz/";

    private ApiService apiService;

    //Constructor
    public CodigoPostalService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    //Exponemos método público
    public void obtenerTodosLosEstados(ApiCallback<List<EstadoModel>> callback) {

        Call<List<EstadoModel>> call = apiService.obtenerEstados();

        call.enqueue(new Callback<List<EstadoModel>>() {
            @Override
            public void onResponse(Call<List<EstadoModel>> call,
                                   Response<List<EstadoModel>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<EstadoModel>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void buscarAsentamiento(String asentamiento, ApiCallback<List<CodigoPostalModel>> callback){
        Call<List<CodigoPostalModel>> call = apiService.buscarAsentamiento(asentamiento);
        call.enqueue(new Callback<List<CodigoPostalModel>>() {
            @Override
            public void onResponse(Call<List<CodigoPostalModel>> call, Response<List<CodigoPostalModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<CodigoPostalModel>> call, Throwable t) {

            }
        });
    }

    //Interface interna
    private interface ApiService {
        @GET("api/CodigosPostales/Estados")
        Call<List<EstadoModel>> obtenerEstados();

        @GET("api/CodigosPostales/{asentamiento}/Buscar")
        Call<List<CodigoPostalModel>> buscarAsentamiento(@Path("asentamiento")String asentamiento);
    }
}
