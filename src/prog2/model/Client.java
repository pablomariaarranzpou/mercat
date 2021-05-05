/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que modelitza els clients de la botiga
 * @author Pablo
 */
public abstract class Client implements Serializable{

    protected String _nom;
    protected String _correu;
    protected String _adreça;

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    /**
     * Constructor de la classe Client
     * @param nom
     * @param correu
     * @param adreça
     */
    public Client(String nom, String correu, String adreça) {
        _nom = nom;
        _correu = correu;
        _adreça = adreça;
    }

    /**
     * Getter de ID
     * @return
     */
    public String getId() {
        return _nom;
    }

    /**
     * Setter de ID
     * @param nom
     */
    public void setId(String nom) {
        _nom = nom;
    }

    /**
     * Getter correu
     * @return
     */
    public String getCorreu() {
        return _correu;
    }

    /**
     * Setter correu
     * @param correu
     */
    public void setCorreu(String correu) {
        _correu = correu;
    }

    /**
     * Getter Adreça
     * @return
     */
    public String getAdreça() {
        return _adreça;
    }

    /**
     * Setter adreça
     * @param adreça
     */
    public void setAdreça(String adreça) {
        _adreça = adreça;
    }

    /**
     * Métode abstracte que retorna el tipus de client. S´ha de implementar a les clases derivades
     * @return
     */
    public abstract String tipusClient();

    /**
     * Metode abstracte que retorna el calcul mensual. S´ha de implementar a les clases derivades
     * @return
     */
    public abstract float calcMensual();

    /**
     * Retorna el descompte d'enviament en percentatge. S´ha de implementar a les clases derivades
     *
     * @return
     */
    public abstract float descompteEnv();

    /**
     * Métode toString de la classe CLient.
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        s += "Tipus=" + tipusClient();
        s += ", Email=" + _correu;
        s += ", Nom=" + _nom;
        s += ", Adreça=" + _adreça;
        s += ", Descompte Enviament=" + descompteEnv();
        s += ", Mensualitat=" + calcMensual();
        return s;
    }

}
