package br.pro.oliveira.repositories;

import br.pro.oliveira.models.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarrosRepository {
    private List<Carro> carros = new ArrayList<Carro>();
    long lastId = 10;

    public CarrosRepository(){
        carros.add(new Carro(1,"Fiesta", "Ford", "Prata"));
        carros.add(new Carro(2,"Civic", "Honda", "Preto"));
        carros.add(new Carro(3,"Gol", "Volkswagen", "Branco"));
        carros.add(new Carro(4,"Corolla", "Toyota", "Azul"));
        carros.add(new Carro(5,"Onix", "Chevrolet", "Vermelho"));
        carros.add(new Carro(6,"HB20", "Hyundai", "Cinza"));
        carros.add(new Carro(7,"Cruze", "Chevrolet", "Prata"));
        carros.add(new Carro(8,"C3", "Citroen", "Amarelo"));
        carros.add(new Carro(9,"Fusca", "Volkswagen", "Verde"));
        carros.add(new Carro(10,"Jeep Compass", "Jeep", "Marrom"));
    }

    public List<Carro> list(){
        return carros;
    }

    public Carro read(long id) {

        for(Carro carro : carros){
            if(carro.getId() == id){
                return carro;
            }
        }
        return null;
    }

    public Carro insert(Carro carro) {
        carro.setId(++lastId);
        carros.add(carro);
        return carro;
    }

    public Carro update(long id, Carro carro) {
        Carro newCarro = null;

        for(Carro oldCarro : carros){
            if(oldCarro.getId() == id) {
                //carro.setUpdatedAt();
                oldCarro.setModelo(carro.getModelo());
                oldCarro.setFabricante(carro.getFabricante());
                oldCarro.setCor(carro.getCor());

                newCarro = oldCarro;
                break;
            }
        }
        return newCarro;
    }

    public Carro upgrade(long id, Carro carro){
        Carro newCarro = null;

        for(Carro oldCarro : carros){
            if(oldCarro.getId() == id) {
                //carro.setUpdatedAt();
                if(carro.getModelo() != null) oldCarro.setModelo(carro.getModelo());
                if(carro.getFabricante() != null) oldCarro.setFabricante(carro.getFabricante());
                if(carro.getCor() != null) oldCarro.setCor(carro.getCor());

                newCarro = oldCarro;
                break;
            }
        }
        return newCarro;

    }

    public Carro delete(long id){
        Carro deletedCarro = null;
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                deletedCarro = carro;
                carros.remove(carro);
                break;
            }
        }
        return deletedCarro;
    }
}
