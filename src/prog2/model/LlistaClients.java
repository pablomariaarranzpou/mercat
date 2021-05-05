/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;

/**
 * Classe que hereta de Llista i modelitza una llista de clients. 
 * @author Pablo
 */
public class LlistaClients extends Llista<Client> implements Serializable {

    /**
     * Constructor de LlistaClients
     */
    public LlistaClients() {
        super();
    }
    
    /**
     * Métode per afegir un objecte a LlistaClients
     * @param client
     * @throws MercatException
     */
    @Override
    public void afegir(Client client) throws MercatException {
        if (contains(client)) {
            throw new MercatException("Aquest client ja existeix.");
        } else {
            llista.add(client);
        }
    }
    
    /**
     * Métode que retorna true si un Client es a la llistaClients
     * @param client
     * @return 
     */
    private boolean contains(Client client) {
        Iterator it = llista.iterator();
        while(it.hasNext()) {
            if (client.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
    
}
