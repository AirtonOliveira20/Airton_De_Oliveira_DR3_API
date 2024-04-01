package br.pro.oliveira.controllers;

import br.pro.oliveira.models.Carro;
import br.pro.oliveira.repositories.CarrosRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class CarrosController {

    CarrosRepository carrosRepository = new CarrosRepository();
    Gson gson = new Gson();

    // GET /carros (req, res) -> String
    public String list(Request req, Response res){
        var carros = carrosRepository.list();

        return response(carros, res);
    }

    public String read(Request req, Response res){
        //:id
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        Carro carro = carrosRepository.read(id);

        if (carro != null){
            return  response(carro, res);
        } else {
            res.status(204);
            return "Sem conteúdo";
        }


    }

    public String insert(Request req, Response res){
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Carro.class); //Convertendo em objeto Carro
        Carro carro = carrosRepository.insert(body);
        return response(carro, res);
    }

    public String update(Request req, Response res){

        //Pegar o ID
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        //Pegar o body
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Carro.class);

        Carro carro = carrosRepository.update(id, body);

        if(carro != null){
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }

    }

    public String upgrade(Request req, Response res){
        //Pegar o ID
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        //Pegar o body
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Carro.class);

        Carro carro = carrosRepository.upgrade(id, body);

        if(carro != null){
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }

    public String delete(Request req, Response res){
        //Pegar o ID
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);

        Carro carro = carrosRepository.delete(id);

        if(carro != null){
            return response(carro, res);
        } else {
            res.status(404);
            return "Carro não encontrado";
        }
    }


    private String response(Object body, Response res) {
        String bodyJson = gson.toJson(body);
        res.type("application/json");

        return bodyJson;
    }

}
