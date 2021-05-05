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
 *
 * @author Pablo
 */
public abstract class Comanda implements Serializable {

    protected Client _client;
    protected Article _article;
    protected int _quantitat;
    protected Date _creacioComanda;

    /**
     * Constructor de la classe comanda
     *
     * @param client Client que enregistra la comanda.
     * @param article Article que conté la comanda.
     * @param quantitat Quantitat de l'article que conté la comanda.
     */
    public Comanda(Client client, Article article, int quantitat) {
        _client = client;
        _article = article;
        _quantitat = quantitat;
        _creacioComanda = new Date();
    }

    /**
     * Retorna el preu d'una comanda sense les despeses d'enviament.
     *
     * @return float del preu total de la comanda.
     */
    public float calcPreu() {
        return _article.getPreu() * _quantitat;
    }

    public Client getClient() {
        return _client;
    }

    public void setClient(Client _client) {
        this._client = _client;
    }

    public int getQuantitat() {
        return _quantitat;
    }

    public void setQuantitat(int _quantitat) {
        this._quantitat = _quantitat;
    }

    public Date getCreacioComanda() {
        return _creacioComanda;
    }

    public void setCreacioComanda(Date _creacioComanda) {
        this._creacioComanda = _creacioComanda;
    }

    /**
     * Métode abstracte que retorna el tipus de comanda.
     *
     * @return String segons la comanda, Normal o Urgent.
     */
    public abstract String tipusComanda();

    /**
     * Métode abstracte que retorna si una comanda ha siguit enviada
     *
     * @return boolean que indica si s'ha enviat o no la comanda.
     */
    public abstract boolean comandaEnviada();

    /**
     * Métode abstracte que retorna si una comanda ha sigut rebuda.
     *
     * @return boolean que indica si s'ha rebut la comanda o no.
     */
    public abstract boolean comandaRebuda();

    /**
     * Métode abstracte que retorna el preu d´enviament.
     *
     * @return float que representa el preu de l'enviament.
     */
    public abstract float preuEnviament();

    /**
     * Métode que retorna el Article de la comanda.
     *
     * @return Referència a l'article de la comanda.
     */
    public Article getArticle() {
        return _article;
    }

    /**
     * Métode toString() de la classe Comanda.
     *
     * @return String que conté informació sobre la comanda.
     */
    @Override
    public String toString() {
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
