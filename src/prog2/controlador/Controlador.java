/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.controlador;

import java.io.IOException;
import java.util.List;
import prog2.model.Dades;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public class Controlador {

    Dades dades;

    public Controlador() {
        this.dades = new Dades();
    }

    public void addArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        dades.afegirArticle(id, nom, preu, temps, admetUrgent);
    }

    public void recuperarArticles() {
        List<String> llista = dades.recuperaArticles();
        for (int i = 0; i < llista.size(); i++) {
            System.out.println(llista.get(i));
        }
    }

    public void addClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        dades.afegirClient(email, nom, adreca, esPremium);
    }

    public void recuperarClients() {
        List<String> llista = dades.recuperaClients();
        for (int i = 0; i < llista.size(); i++) {
            System.out.println(llista.get(i));
        }
    }

    public void addComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        dades.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
    }

    public void recuperarComandes() {
        List<String> llista = dades.recuperaComandes();
        for (int i = 0; i < llista.size(); i++) {
            System.out.println(llista.get(i));
        }
    }

    public void eliminarComanda(int pos) throws MercatException {
        dades.esborrarComanda(pos);
    }

    public void recuperarComandesUrgents() {
        List<String> llista = dades.recuperaComandesUrgents();
        for (int i = 0; i < llista.size(); i++) {
            System.out.println(llista.get(i));
        }
    }

    public void guardar() throws MercatException, IOException {
        dades.guardaDades("dades.dat");
    }

    public void recuperar() throws MercatException, IOException, ClassNotFoundException {
        this.dades = dades.carregaDades("dades.dat");
    }

}
