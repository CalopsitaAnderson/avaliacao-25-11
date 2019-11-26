package br.com.etechoracio.avaliacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etechoracio.avaliacao.service.ProjetoAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    private EditText txtNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = findViewById( R.id.txtNum);

        this.service = new Retrofit.Builder().baseUrl("http://172.16.58.22:8001/api/funcoes/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ProjetoAPIService.class);
    }

    private ProjetoAPIService service;


    public void onCalcular(View V) {
        Call<String> call = service.executar(txtNum.getText().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String calculo = response.body();
                Toast.makeText(getApplicationContext(), calculo, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });




    }

}
