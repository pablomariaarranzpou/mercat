/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.time.Duration;

/**
 *
 * @author Pablo
 */
public class Article {

    String _identificador;
    String _nom;
    float _preu;
    boolean _permetEnviamentUrgent;
    Duration _tempsFinsEnviament;

    public Article(String identificador, String nom, float preu,
            boolean permetEnviamentUrgent, Duration tempsFinsEnviament) {
        _identificador = identificador;
        _nom = nom;
        _preu = preu;
        _permetEnviamentUrgent = permetEnviamentUrgent;
        _tempsFinsEnviament = tempsFinsEnviament;
    }

    public String getIdentificador() {
        return _identificador;
    }

    public void setIdentificador(String identificador) {
        _identificador = identificador;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        _nom = nom;
    }

    public float getPreu() {
        return _preu;
    }

    public void setPreu(float preu) {
        _preu = preu;
    }

    public boolean isPermetEnviamentUrgent() {
        return _permetEnviamentUrgent;
    }

    public void setPermetEnviamentUrgent(boolean permetEnviamentUrgent) {
        _permetEnviamentUrgent = permetEnviamentUrgent;
    }

    public Duration getTempsFinsEnviament() {
        return _tempsFinsEnviament;
    }

    public void setTempsFinsEnviament(Duration tempsFinsEnviament) {
        _tempsFinsEnviament = tempsFinsEnviament;
    }

    @Override
    public String toString() {
        String s = "Id=" + _identificador;
        s += ", Nom=" + _nom;
        s += ", Preu=" + _preu;
        s += ", Temps fins enviament=" + _tempsFinsEnviament.getSeconds();
        s += ", Enviament Urgent=" + String.valueOf(_permetEnviamentUrgent);
        return s;
    }

}
