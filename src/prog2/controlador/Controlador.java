/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.controlador;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import prog2.model.Dades;
import prog2.vista.MercatException;

/**
 * Classe controlador. S’encarrega de comunicar el model i la vista.
 * @author Pablo
 */
public class Controlador {

    Dades _dades;

    /**
     * Constructor classe controlador.
     */
    public Controlador() {
        _dades = new Dades();
    }

    /**
     * Métode que crida a Dades per afegir un Article
     * @param id
     * @param nom
     * @param preu
     * @param temps
     * @param admetUrgent
     * @throws MercatException
     */
    public void addArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        _dades.afegirArticle(id, nom, preu, temps, admetUrgent);
    }

    /**
     * Métode que crida a Dades per Recuperar els Articles
     * @return
     */
    public boolean recuperarArticles() {
        List<String> llista = _dades.recuperaArticles();
        if (llista.isEmpty()) {
            return false;
        }
        Iterator it = llista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return true;
    }

    /**
     * Métode que crida a Dades per afegir un Client
     * @param email
     * @param nom
     * @param adreca
     * @param esPremium
     * @throws MercatException
     */
    public void addClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        _dades.afegirClient(email, nom, adreca, esPremium);
    }

    /**
     * Métode que crida a Dades per imprimir llista clients
     * @return
     */
    public boolean recuperarClients() {
        List<String> llista = _dades.recuperaClients();
        if (llista.isEmpty()) {
            return false;
        }
        Iterator it = llista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return true;
    }

    /** 
     * Métode que crida a Dades per afegir una comanda.
     * @param articlePos
     * @param clientPos
     * @param quantitat
     * @param esUrgent
     * @throws MercatException
     */
    public void addComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        _dades.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
    }

    /**
     * Métode que crida a Dades per imprimir totes les Comandes
     * @return
     */
    public boolean recuperarComandes() {
        List<String> llista = _dades.recuperaComandes();
        if (!llista.isEmpty()) {
            return false;
        }
        Iterator it = llista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return true;
    }

    /**
     * Métode que crida a Dades per esborrar una comanda.
     * @param pos
     * @throws MercatException
     */
    public void eliminarComanda(int pos) throws MercatException {
        _dades.esborrarComanda(pos);
    }

    /**
     * Métode que crida a Dades per imprimir les comandes urgents.
     * @return
     */
    public boolean recuperarComandesUrgents() {
        List<String> llista = _dades.recuperaComandesUrgents();
        if(!llista.isEmpty()) return false;
        Iterator it = llista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        return true;
    }

    /**
     * Métode que crida a Dades per guardar les dades a un fitxer.
     * @throws IOException
     */
    public void guardar() throws IOException {
        _dades.guardaDades("dades.dat");
    }

    /**
     * Métode que crida a Dades per recuperar les dades a un fitxer
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void recuperar() throws IOException, ClassNotFoundException {
        _dades = _dades.carregaDades("dades.dat");
    }

}
