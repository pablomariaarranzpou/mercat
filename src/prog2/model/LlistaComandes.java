/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.MercatException;

/**
 * Classe que hereta de Llista i modelitza una llista de Comandes
 * @author Pablo
 */
public class LlistaComandes extends Llista<Comanda> implements Serializable {

    /**
     * Constructor de LlistaComandes
     */
    public LlistaComandes() {
        super();
    }
    
    /**
     * Métode per afegir una comanda a LlistaComandes
     * @param comanda
     * @throws MercatException
     */
    @Override
    public void afegir(Comanda comanda) throws MercatException {
        if (comanda instanceof ComandaUrgent && !comanda.getArticle().permetEnviamentUrgent()) {
            throw new MercatException("Aquest article no permet enviament urgent.");
        } else {
            llista.add(comanda);
        }
    }
    
    /**
     * Métode per esborrar una comanda de la LlistaComandes.
     * @param comanda
     * @throws MercatException
     */
    @Override
    public void esborrar(Comanda comanda) throws MercatException {
        if(comanda.comandaEnviada()) throw new MercatException("La comanda ja ha estat enviada, no es pot borrar.");  
        llista.remove(comanda);
    }
}
