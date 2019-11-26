package br.com.etechoracio.avaliacao.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProjetoAPIService {

    @GET("quadrado/{num}")
    Call<String> executar( @Path("num") String value);
}
