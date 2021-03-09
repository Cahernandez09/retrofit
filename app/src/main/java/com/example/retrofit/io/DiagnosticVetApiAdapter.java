package com.example.retrofit.io;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiagnosticVetApiAdapter {//En el Appi Adapter vamos a devolver una instancia del appiService
    //El Appi services es una interfaz por lo tanto no puedo devolver una instancia de una interfaz lo que devolvemos es una instancia donde este objeto que esta implementando la interfaz api services por lo tanto va tener disponible los metodos de nuestra appi server
    //es decir el objeto que vamos a devolver, va hacer posible que los metodos que definamos e la interfaz(otro archivo) se ejecuten desde nuestra actividad, desde nuestro codigo java y al ejecutar estos metodos estaran realizando las peticiones http

    ///***es una clase que se encargará de instanciar un objeto Retrofit (aplicando el patrón de diseño Singleton),
    // y este objeto hará posible las peticiones. **//

    private static DiagnosticVetApiService API_SERVICE;
    public static DiagnosticVetApiService getApiService(){
        //este metodo getApiserice esta haciendo uso del patron de diseño singlenton, se asegura de que solo use una instancia por ejemplo

        //Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging= new HttpLoggingInterceptor(); //ver algunos datos de la peticion que se ha realizado
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient  = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //definimos nuestra ruta base de nuestra api
        String baseUrl="https://mi-pagina.com/api/";


        //por ejemplo si appiservice es null se va a instanciar, de caso contrario si es que ya se ha instanciado una vez antes directamente se va devolver ese objeto (return)
        if(API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())//*usamos el log level
                    .build();

            API_SERVICE=retrofit.create(DiagnosticVetApiService.class);
        }
        return API_SERVICE;
    }
}
