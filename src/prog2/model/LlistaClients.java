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
 *
 * @author Pablo
 */
public class LlistaClients extends Llista<Client> implements Serializable {

    public LlistaClients() {
        super();
    }
    
    
    @Override
    public void afegir(Client client) throws MercatException {
        if (contains(client)) {
            throw new MercatException("Aquest client ja existeix.");
        } else {
            llista.add(client);
        }
    }

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
