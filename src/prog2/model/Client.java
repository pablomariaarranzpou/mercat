/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public abstract class Client implements Serializable{

    String _nom;
    String _correu;
    String _adreça;

    public Client(String nom, String correu, String adreça) {
        _nom = nom;
        _correu = correu;
        _adreça = adreça;
    }

    public String getId() {
        return _nom;
    }

    public void setId(String nom) {
        _nom = nom;
    }

    public String getCorreu() {
        return _correu;
    }

    public void setCorreu(String correu) {
        _correu = correu;
    }

    public String getAdreça() {
        return _adreça;
    }

    public void setAdreça(String adreça) {
        _adreça = adreça;
    }

    public abstract String tipusClient();

    public abstract float calcMensual();

    /**
     * Retorna el descompte d'enviament en percentatge.
     *
     * @return
     */
    public abstract float descompteEnv();

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
