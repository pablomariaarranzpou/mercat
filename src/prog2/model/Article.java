/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Classe que modelitza els articles de la botiga.
 * @author Pablo
 */
public class Article implements Serializable{

    private String _identificador;
    private String _nom;
    private float _preu;
    private boolean _permetEnviamentUrgent;
    private long _tempsFinsEnviament;

    public boolean isPermetEnviamentUrgent() {
        return _permetEnviamentUrgent;
    }

    /**
     * Consturctor d ela classe Article
     * @param identificador identificador de l´article
     * @param nom Nom de l´article
     * @param preu Preu de l´article
     * @param tempsFinsEnviament Temps fins enviament de l´article 
     * @param permetEnviamentUrgent Lárticle admet enviament urgent.
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
     * Getter de l´identificador
     * @return IDNETIFICADOR
     */
    public String getIdentificador() {
        return _identificador;
    }

    /**
     * Setter d el´identificador
     * @param identificador
     */
    public void setIdentificador(String identificador) {
        _identificador = identificador;
    }

    /**
     * Getter del Nom de l´asrticle
     * @return NOM
     */
    public String getNom() {
        return _nom;
    }

    /**
     * Setter del nom de l´article
     * @param nom
     */
    public void setNom(String nom) {
        _nom = nom;
    }

    /**
     * Getter del preu de l´article
     * @return PREU
     */
    public float getPreu() {
        return _preu;
    }

    /**
     * Setter del preu de l´article
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
     * @return Milisegons d´enviament
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
