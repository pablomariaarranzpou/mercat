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

    @Override
    public void afegir(Comanda comanda) throws MercatException {
        if (comanda.getClass().getName().equals("ComandaUrgent") &&
                !comanda.getArticle().permetEnviamentUrgent()) {
            throw new MercatException("Aquest article no permet enviament urgent.");
        } else {
            llista.add(comanda);
        }
    }

}
