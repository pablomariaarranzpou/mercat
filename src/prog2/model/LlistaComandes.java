/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public class LlistaComandes extends Llista<Comanda> implements Serializable {

    public LlistaComandes() {
        super();
    }
    
    @Override
    public void afegir(Comanda comanda) throws MercatException {
        System.out.println("Comanda urgent? " + comanda.getClass().getName());
        if (comanda instanceof ComandaUrgent &&
                !comanda.getArticle().permetEnviamentUrgent()) {
            throw new MercatException("Aquest article no permet enviament urgent.");
        } else {
            llista.add(comanda);
        }
    }
    
    @Override
    public void esborrar(Comanda comanda) throws MercatException {
        if(comanda.comandaEnviada()) throw new MercatException("La comanda ja ha estat enviada, no es pot borrar.");  
        llista.remove(comanda);
    }
}
