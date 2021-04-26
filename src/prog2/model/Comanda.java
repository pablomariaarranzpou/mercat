/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Date;

/**
 *
 * @author Pablo
 */
public abstract class Comanda {
    Client _client;
    Article _article;
    int _quantitat;
    Date _creacioComanda;
    
    public Comanda(Client client, Article article, int quantitat){
        _client = client;
        _article = article;
        _quantitat = quantitat;
        _creacioComanda = new Date();
    }
    
    /**
     * Retorna el preu d'una comanda sense les despeses d'enviament.
     * @return 
     */
    public float calcPreu(){
        return _article.getPreu() * _quantitat;
    }
    
    public abstract String tipusComanda();

    public abstract boolean comandaEnviada();

    public abstract boolean comandaRebuda();

    public abstract float preuEnviament();
    
    @Override
    public String toString(){
        String s = "";
        s += "Tipus=" + tipusComanda();
        s += ", Article=" + _article;
        s += ", Client=" + _client;
        s += ", Quantitat=" + _quantitat;
        s += ", Data de creacio=" + _creacioComanda.toString();
        s += ", Enviat=" + String.valueOf(comandaEnviada());
        s += ", Rebuda=" + String.valueOf(comandaRebuda());
        s += ", Preu Articles=" + calcPreu();
        s += ", Preu Enviament=" + preuEnviament();
        return s;
    }
    
}
