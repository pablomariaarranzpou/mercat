/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que modelitza els clients de la botiga
 *
 * @author Pablo
 */
public abstract class Client implements Serializable {

    protected String _nom;
    protected String _correu;
    protected String _adreca;

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        _nom = nom;
    }

    /**
     * Constructor de la classe Client
     *
     * @param nom Nom del client
     * @param correu Correu del client
     * @param adreça Adreça del client
     */
    public Client(String nom, String correu, String adreça) {
        _nom = nom;
        _correu = correu;
        _adreca = adreça;
    }

    /**
     * Getter de ID
     *
     * @return Retorna la ID del client
     */
    public String getId() {
        return _nom;
    }

    /**
     * Setter de ID
     *
     * @param nom Canvia el nom del client
     */
    public void setId(String nom) {
        _nom = nom;
    }

    /**
     * Getter correu
     *
     * @return Retorna el correu del client
     */
    public String getCorreu() {
        return _correu;
    }

    /**
     * Setter correu
     *
     * @param correu Canvia el correu del client
     */
    public void setCorreu(String correu) {
        _correu = correu;
    }

    /**
     * Getter Adreça
     *
     * @return Retorna l'adreça del client
     */
    public String getAdreça() {
        return _adreca;
    }

    /**
     * Setter adreça
     *
     * @param adreça Canvia l'adreça del client
     */
    public void setAdreça(String adreça) {
        _adreca = adreça;
    }

    /**
     * Métode abstracte que retorna el tipus de client. S´ha de implementar a
     * les clases derivades
     *
     * @return String que indica el tipus de client, si Estandard o Premium.
     */
    public abstract String tipusClient();

    /**
     * Metode abstracte que retorna el calcul mensual. S´ha de implementar a les
     * clases derivades
     *
     * @return float de la mensualitat del client.
     */
    public abstract float calcMensual();

    /**
     * Retorna el descompte d'enviament en percentatge. S´ha de implementar a
     * les clases derivades
     *
     * @return float que representa el percentatge de descompte.
     */
    public abstract float descompteEnv();

    /**
     * Métode toString de la classe CLient.
     *
     * @return String que conté tota la informació del client.
     */
    @Override
    public String toString() {
        String s = "";
        s += "Tipus=" + tipusClient();
        s += ", Email=" + _correu;
        s += ", Nom=" + _nom;
        s += ", Adreça=" + _adreca;
        s += ", Descompte Enviament=" + descompteEnv();
        s += ", Mensualitat=" + calcMensual();
        return s;
    }

}
