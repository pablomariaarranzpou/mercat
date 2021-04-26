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
public class LlistaClients extends Llista<Client> implements Serializable {

    @Override
    public void afegir(Client client) throws MercatException {
        if (contains(client)) {
            throw new MercatException("Aquest client ja existeix.");
        } else {
            llista.add(client);
        }
    }

    private boolean contains(Client client) {
        for (int i = 0; i < llista.size(); i++) {
            if (client.equals(llista.get(i))) {
                return true;
            }
        }
        return false;
    }
    
}
