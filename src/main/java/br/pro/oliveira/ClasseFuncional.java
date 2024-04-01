package br.pro.oliveira;

import spark.Request;
import spark.Response;

public class ClasseFuncional implements Funcional{

    @Override
    public String response(Request req, Response res) {
        return "Qualquer coisa";
    }
}
