package com.saojose.estudoapi.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saojose.estudoapi.Model.Funcionario;
import com.saojose.estudoapi.Requisicoes.FuncionarioService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguracao {

    private final Retrofit retrofit;

    public RetrofitConfiguracao()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://estudoapi.conveyor.cloud/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public FuncionarioService getFuncionarioService() {
        return this.retrofit.create(FuncionarioService.class);
    }

}
