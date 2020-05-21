package com.saojose.estudoapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.saojose.estudoapi.Adapter.FuncionarioAdapter;
import com.saojose.estudoapi.Model.Funcionario;
import com.saojose.estudoapi.Model.Pais;
import com.saojose.estudoapi.R;
import com.saojose.estudoapi.Requisicoes.FuncionarioService;
import com.saojose.estudoapi.Requisicoes.RequisicaoHttp;
import com.saojose.estudoapi.Retrofit.RetrofitConfiguracao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    FuncionarioAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Funcionario> funcionarios;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_Funcionario);
        funcionarios = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        llm = new LinearLayoutManager(MainActivity.this);

        Call<ArrayList<Funcionario>> call = new RetrofitConfiguracao().getFuncionarioService().BuscarFuncionarios();

        call.enqueue(new Callback<ArrayList<Funcionario>>() {
            @Override
            public void onResponse(Call<ArrayList<Funcionario>> call, Response<ArrayList<Funcionario>> response) {
                funcionarios= response.body();
                adapter = new FuncionarioAdapter(funcionarios,( MainActivity.this));
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Funcionario>> call, Throwable t) {

            }
        });

        recyclerView.setLayoutManager(llm);

    }
}
