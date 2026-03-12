package fes.carlos.holamundowsv1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

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
    Spinner spinner;
    ProgressBar progressBar;

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
        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        obtenerEstados();

    }

    private void obtenerEstados() {
        service.obtenerTodosLosEstados(new ApiCallback<List<EstadoModel>>() {
            @Override
            public void onSuccess(List<EstadoModel> estados) {
                llenarSpinner(estados);
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                Toast.makeText(getBaseContext(), "Estados cargados", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void llenarSpinner(List<EstadoModel> estados) {
        estados.add(0, new EstadoModel(0, "Seleccione "));
        ArrayAdapter<EstadoModel> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                estados
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}