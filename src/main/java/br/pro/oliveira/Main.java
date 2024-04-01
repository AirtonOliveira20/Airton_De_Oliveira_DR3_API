package br.pro.oliveira;
import br.pro.oliveira.controllers.CarrosController;

import static spark.Spark.*;

public class Main
{
    private static final int port = 8080;
    private static final CarrosController carrosController = new CarrosController();

    public static void main( String[] args )
    {

        port(port);
        get("/", (req, res) -> "Server on!");


        path("/carros", () -> {
            get("", carrosController::list);

            //url + recurso + 'id'
            get("/:id", carrosController::read);

            post("", carrosController::insert);

            put("/:id", carrosController::update);

            patch("/:id", carrosController::upgrade);

            delete("/:id", carrosController::delete);

        });
    }
}
