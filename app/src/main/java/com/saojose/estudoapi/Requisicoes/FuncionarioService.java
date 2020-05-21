package com.saojose.estudoapi.Requisicoes;

import com.saojose.estudoapi.Model.Funcionario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FuncionarioService {

    @GET("api/funcionario/{id}")
    Call<Funcionario>BuscarFuncionarioPorId(@Path("id") int id);

    @GET("api/funcionario/")
    Call<ArrayList<Funcionario>>BuscarFuncionarios();

}
