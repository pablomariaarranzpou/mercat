/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.List;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public class Dades implements InDades, Serializable{

    LlistaArticles _llistaArticles;
    LlistaClients _llistaClients;
    LlistaComandes _llistaComandes;
    
    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        _llistaArticles.afegir(new Article(id, nom, preu, temps, admetUrgent));
    }

    @Override
    public List<String> recuperaArticles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        Client client;
        if(esPremium)
            client = new ClientPremium(nom, email, adreca);
        else
            client = new ClientEstandard(nom, email, adreca);
        _llistaClients.afegir(client);
    }

    @Override
    public List<String> recuperaClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        Article article = _llistaArticles.getAt(articlePos);
        Client client = _llistaClients.getAt(clientPos);
        Comanda comanda;
        if(esUrgent)
            comanda = new ComandaUrgent(client, article, quantitat);
        else
            comanda = new ComandaNormal(client, article, quantitat);
        _llistaComandes.afegir(comanda);
    }

    @Override
    public void esborrarComanda(int position) throws MercatException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> recuperaComandes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> recuperaComandesUrgents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
