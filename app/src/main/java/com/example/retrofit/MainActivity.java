package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.io.DiagnosticVetApiAdapter;
import com.example.retrofit.model.Diseases;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Diseases>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vamos hacer nuestra primera peticion GET
        //El objeto de Retrofit que necesitamos lo  vamos a obtener lo vamos
        //a obtener a traves de nuestro singlenton, por lo tanto

        Call<ArrayList<Diseases>> call =DiagnosticVetApiAdapter.getApiService().getDiseases(); //el metodo getDiseases nos va devolver un objeto Call
        //es decir una llamada/peticion, esta peticion es asincrona, por loque vamos a requerir de un callback que
        //se va llamar automaticamente cuando el servidor ya nos haya respondido
        //Retrofic hace el desaroollo de hilos por detras.

        //Ahora daremos la orden para que se realice con el siguiente metodo
        call.enqueue(this);//encolar , colocar mi peticion en cola, porque podrian haber mas petinciones que pueden estar en espera en realizarse
        //Android studio no sugire pasarle un callback(es una funcion que se va llamar cuando ocurra un evento determinado) En este caso este callback se va llamar
        //cuando el servidor ya haya dado respuesta, puede que tarde un segundo o que tarde menos, pero tenemos la certeza que ese metodo se va llamar a si ocurra un error o
        //acabe el tiempo de espera para hacer la peticion. De lo anterior hay varias formas de resolver
        //uNA forma es usando clases anonimas o this, si le pasamos this quiere decir que el callback va ha estar definido por la misma clase MainActivity, le damos alt+enter al this (y hacemos que nuestra clase MainActivity implemente la clase callback de retrofic
        //eso hara que nuestra clase tenga que implementar dos metodos (onResponse y onFailure
    }

    @Override
    public void onResponse(Call<ArrayList<Diseases>> call, Response<ArrayList<Diseases>> response) {
        //Se va lamar si se obtuvo una respuesta
        if(response.isSuccessful()){//Si la respuesta es exitosa se hara lo siguiente
            //nota: yo me pregunto-Por que pregunto si la respuesta es exitosa si ya esta dentro del metodo Onresponse, lo que pasa es que puede llegar ese metodo pero el parseo fue inadecuado
            //es decir l respuesta que hemos obtenido no concuerda con la clase es por esto que definimos que nos aseguramos de obtener una respuesta adecuada
            //Con lo anterior obtenemos el cuerpo de la respuesta que va hacer un arrayList de enfermedades
            ArrayList<Diseases>diseases=response.body();
            //ahora imprimimos por consola el tamaño de este arreglo
            Log.d("onResponse diseases ", "Size of diseases => "+diseases.size() );
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Diseases>> call, Throwable t) {

    }
}