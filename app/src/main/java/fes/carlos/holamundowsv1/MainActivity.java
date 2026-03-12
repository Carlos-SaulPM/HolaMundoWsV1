package fes.carlos.holamundowsv1;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fes.carlos.holamundowsv1.models.CodigoPostalModel;
import fes.carlos.holamundowsv1.models.EstadoModel;
import fes.carlos.holamundowsv1.services.ApiCallback;
import fes.carlos.holamundowsv1.services.CodigoPostalService;

public class MainActivity extends AppCompatActivity {
    
    CodigoPostalService service = new CodigoPostalService();
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // obtenerEstados();
        buscarAsentamiento("Roma");
    }

    private void buscarAsentamiento(String asentamiento) {
        service.buscarAsentamiento(asentamiento, new ApiCallback<List<CodigoPostalModel>>() {
            @Override
            public void onSuccess(List<CodigoPostalModel> estados) {
                for (CodigoPostalModel codigoPostalModel :
                        estados) {
                    Log.d("Asentamientos", codigoPostalModel.getAsentamiento());
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void obtenerEstados() {
        service.obtenerTodosLosEstados(new ApiCallback<List<EstadoModel>>() {
            @Override
            public void onSuccess(List<EstadoModel> estados) {
                for (EstadoModel estadoModel :
                        estados) {
                    Log.d("Estado", estadoModel.getNombre());
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }
}