/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public class Dades implements InDades, Serializable {

    LlistaArticles _llistaArticles;
    LlistaClients _llistaClients;
    LlistaComandes _llistaComandes;

    public Dades() {
        _llistaArticles = new LlistaArticles();
        _llistaClients = new LlistaClients();
        _llistaComandes = new LlistaComandes();
    }

    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        _llistaArticles.afegir(new Article(id, nom, preu, temps, admetUrgent));
    }

    @Override
    public List<String> recuperaArticles() {

        //Com la clase List es abstracte cridem a la seva clase filla ArrayList
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaArticles.getSize(); i++) {
            llista.add(_llistaArticles.getAt(i).toString());
        }

        return llista;
    }

    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        Client client;
        if (esPremium) {
            client = new ClientPremium(nom, email, adreca);
        } else {
            client = new ClientEstandard(nom, email, adreca);
        }
        _llistaClients.afegir(client);
    }

    @Override
    public List<String> recuperaClients() {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaClients.getSize(); i++) {
            llista.add(_llistaClients.getAt(i).toString());
        }

        return llista;
    }

    @Override
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        Article article = _llistaArticles.getAt(articlePos);
        Client client = _llistaClients.getAt(clientPos);
        Comanda comanda;
        if (esUrgent) {
            comanda = new ComandaUrgent(client, article, quantitat);
        } else {
            comanda = new ComandaNormal(client, article, quantitat);
        }
        _llistaComandes.afegir(comanda);
    }

    @Override
    public void esborrarComanda(int position) throws MercatException {
        _llistaComandes.esborrar(_llistaComandes.getAt(position));
    }

    @Override
    public List<String> recuperaComandes() {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaComandes.getSize(); i++) {
            llista.add(_llistaComandes.getAt(i).toString());
        }

        return llista;
    }

    @Override
    public List<String> recuperaComandesUrgents() {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaComandes.getSize(); i++) {
            if (_llistaComandes.getAt(i) instanceof ComandaUrgent) {
                llista.add(_llistaComandes.getAt(i).toString());
            }
        }

        return llista;

    }

    public void guardaDades(String path) throws FileNotFoundException, IOException {
        File fitxer = new File(path);
        FileOutputStream fout;
        ObjectOutputStream oos;
        fout = new FileOutputStream(fitxer);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
        fout.close();
    }

    public Dades carregaDades(String path) throws IOException, ClassNotFoundException {
        File fitxer = new File(path);
        FileInputStream fin;
        ObjectInputStream ois;
        Dades carrega = null;

        fin = new FileInputStream(fitxer);
        ois = new ObjectInputStream(fin);
        carrega = (Dades) ois.readObject();
        fin.close();
        ois.close();

        return carrega;

    }
}
