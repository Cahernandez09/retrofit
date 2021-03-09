package com.example.retrofit.io;

import com.example.retrofit.io.response.DiseasesResponse;
import com.example.retrofit.model.Diseases;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DiagnosticVetApiService {
    //Aquí vamos a definir métodos abstractos.
  //1-Metodo: Peticion GET A LA RUTA diseases. La respuesta sera un listado de
  //enfermedades. Y esta respuesta se va a procesar gracias a la clase DiseasesResponse.

    //diseases es una ruta especifica ..ya que la ruta completa es https://mi-pagina.com/api/diseases quedaria faltando el diseases
    @GET("diseases") //anotacion
    //cuando necesitemos  hacer una peticion a la ruta "diseases" nosotros llamaremos al metodo getDiseasable
    Call<ArrayList<Diseases>> getDiseases();
    // y la respuesta en JSOn que obtengamos se va a parcear automaticamente en base a la clase DiseaseResponse
    //siempre el formato que vamos a parcear va ha estar entre <> , ya que tambien podemos tener peticiones variadas

  //llegando de la clase DiseasesResponse remplzar el <DiseasesResponse > directamente por un arrayList
 //luego voy al MainActivitiy
}

