package com.example.retrofit.io.response;

public class DiseasesResponse {

    //se va relacionar con la respuesta en GSON qye vamos a obtener de la url
    //pasamos esa url completa http://104.236.28.76/api/diseases en el postman.
    //Con esta ruta obtenemos un arreglo que tiene varios objetos expresados en formato GSON
    //donde cada objeto representa una enfermedad que tine un ID, NOMBRE, EXAMEN, TRATAMIENTO.

    //Los datos que estan en el postman se van a mapear a objetos Deseas pero nuestra rta en general
    //pero nuestra rta en si no es un objeto deseas, sino un arreglo de obejtos por lo tanto nuestra clase DeseasResponse.
    //Por lo tanto nuestra clase DeseaesResponse vendria siendo un arreglo de enfermedades.

    //Para simplificar esto podemos hacer en este caso es ir a la interfaz DiagnosticVetApiService


}
