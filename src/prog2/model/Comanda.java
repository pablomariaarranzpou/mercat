/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe Comanda classe abstracta que modelitza les comandes de la botiga
 * @author Pablo
 */
public abstract class Comanda implements Serializable{
    Client _client;
    Article _article;
    int _quantitat;
    Date _creacioComanda;
    
    /**
     * Constructor de la classe comanda
     * @param client
     * @param article
     * @param quantitat
     */
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
    
    /**
     * Métode abstracte que retorna el tipus de comanda.
     * @return
     */
    public abstract String tipusComanda();

    /**
     * Métode abstracte que retorna si una comanda ha siguit enviada
     * @return
     */
    public abstract boolean comandaEnviada();

    /**
     * Métode abstracte que retorna si una comanda ha sigut rebuda.
     * @return
     */
    public abstract boolean comandaRebuda();

    /**
     * Métode abstracte que retorna el preu d´enviament.
     * @return
     */
    public abstract float preuEnviament();
    
    /**
     * Métode que retorna el Article de la comanda.
     * @return
     */
    public Article getArticle(){
        return _article;
    }
    
    /**
     * Métode toString() de la classe Comanda.
     * @return
     */
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
