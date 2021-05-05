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
 * Classe façana entre el model i el controlador
 *
 * @author Pablo
 */
public class Dades implements InDades, Serializable {

    private LlistaArticles _llistaArticles;
    private LlistaClients _llistaClients;
    private LlistaComandes _llistaComandes;

    /**
     * Constructor de classe Dades
     */
    public Dades() {
        _llistaArticles = new LlistaArticles();
        _llistaClients = new LlistaClients();
        _llistaComandes = new LlistaComandes();
    }

    /**
     * Afegir article a objecte LlistaArticles
     *
     * @param id Identificador de l'article.
     * @param nom Nom de l'article.
     * @param preu Preu de l'article.
     * @param temps Temps fins l'enviament de l'article.
     * @param admetUrgent Si l'article admet enviament urgent o no.
     * @throws MercatException Si l'article ja existeix, es tira excepció.
     */
    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        _llistaArticles.afegir(new Article(id, nom, preu, temps, admetUrgent));
    }

    /**
     * Retorna llista amb els toString de cada Article
     *
     * @return List<String> amb els articles existents.
     */
    @Override
    public List<String> recuperaArticles() {

        //Com la clase List es abstracte cridem a la seva clase filla ArrayList
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaArticles.getSize(); i++) {
            llista.add(_llistaArticles.getAt(i).toString());
        }

        return llista;
    }

    /**
     * Afegir Client a objecte LlistaClients
     *
     * @param email Correu del client.
     * @param nom Nom del client.
     * @param adreca Adreça del client.
     * @param esPremium Indica si el client és premium o no.
     * @throws MercatException Si el client ja existeix, es tira excepció.
     */
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

    /**
     * Retorna llista amb els toString de cada Client
     *
     * @return List<String> amb els clients existents.
     */
    @Override
    public List<String> recuperaClients() {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaClients.getSize(); i++) {
            llista.add(_llistaClients.getAt(i).toString());
        }

        return llista;
    }

    /**
     * Afegir Comanda a objecte LlistaComandes
     *
     * @param articlePos Posició de l'article en la llista.
     * @param clientPos Posició del client en la llista.
     * @param quantitat Quantitat de l'article.
     * @param esUrgent Indica si la comanda és urgent o no.
     * @throws MercatException Si la comanda és urgent però l'article no ho permet, es tira excepció.
     */
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

    /**
     * Esborra una Comanda a objecte LlistaComandes
     *
     * @param position Posició de la comanda en la llista.
     * @throws MercatException
     */
    @Override
    public void esborrarComanda(int position) throws MercatException {
        _llistaComandes.esborrar(_llistaComandes.getAt(position));
    }

    /**
     * Retorna una llista amb els toString de TOTES les comandes.
     *
     * @return List<String> amb les comandes existents.
     */
    @Override
    public List<String> recuperaComandes() {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < _llistaComandes.getSize(); i++) {
            llista.add(_llistaComandes.getAt(i).toString());
        }

        return llista;
    }

    /**
     * Retorna una llista amb els toString de NOMES les comandes urgents.
     *
     * @return List<String> amb les comandes urgents existents.
     */
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

    /**
     * Métode per guardar dades d´un fitxer
     *
     * @param path Path al fitxer.
     * @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     * Métode per recuperar dades d´un fitxer
     *
     * @param path Path al fitxer.
     * @return Retorna un objecte Dades.
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
