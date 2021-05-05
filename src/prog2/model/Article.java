/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Pablo
 */
public class Article implements Serializable{

    String _identificador;
    String _nom;
    float _preu;
    boolean _permetEnviamentUrgent;
    long _tempsFinsEnviament;

    /**
     *
     * @param identificador
     * @param nom
     * @param preu
     * @param tempsFinsEnviament
     * @param permetEnviamentUrgent
     */
    public Article(String identificador, String nom, float preu,
            long tempsFinsEnviament, boolean permetEnviamentUrgent) {
        _identificador = identificador;
        _nom = nom;
        _preu = preu;
        _tempsFinsEnviament = tempsFinsEnviament;
        _permetEnviamentUrgent = permetEnviamentUrgent;
    }

    /**
     *
     * @return
     */
    public String getIdentificador() {
        return _identificador;
    }

    /**
     *
     * @param identificador
     */
    public void setIdentificador(String identificador) {
        _identificador = identificador;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return _nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        _nom = nom;
    }

    /**
     *
     * @return
     */
    public float getPreu() {
        return _preu;
    }

    /**
     *
     * @param preu
     */
    public void setPreu(float preu) {
        _preu = preu;
    }

    /**
     *
     * @return
     */
    public boolean permetEnviamentUrgent() {
        return _permetEnviamentUrgent;
    }

    /**
     *
     * @param permetEnviamentUrgent
     */
    public void setPermetEnviamentUrgent(boolean permetEnviamentUrgent) {
        _permetEnviamentUrgent = permetEnviamentUrgent;
    }

    /**
     * Retorna en milisegons el temps fins enviament de l'article.
     *
     * @return
     */
    public long getTempsFinsEnviament() {
        return TimeUnit.DAYS.toMillis(_tempsFinsEnviament);
    }

    /**
     *
     * @param tempsFinsEnviament
     */
    public void setTempsFinsEnviament(long tempsFinsEnviament) {
        _tempsFinsEnviament = tempsFinsEnviament;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "Id=" + _identificador;
        s += ", Nom=" + _nom;
        s += ", Preu=" + _preu;
        s += ", Temps fins enviament=" + _tempsFinsEnviament;
        s += ", Enviament Urgent=" + String.valueOf(_permetEnviamentUrgent);
        return s;
    }

}
