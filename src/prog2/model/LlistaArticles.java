/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public class LlistaArticles extends Llista<Article> implements Serializable {

    /**
     * Classe que hereta de Llista i modelitza una llista d’articles
     */
    public LlistaArticles() {
        super();
    }
  
    /**
     * Métode per afegir Artices a la Llista
     * @param article
     * @throws MercatException
     */
    @Override
    public void afegir(Article article) throws MercatException {
        if (contains(article)) {
            throw new MercatException("Aquest article ja existeix a la llista");
        } else {
            llista.add(article);
        }
    }
    
    /**
     * Retorna true si l´Articla és ja a la llista.
     * @param article
     * @return 
     */
    private boolean contains(Article article) {
        Iterator it = llista.iterator();
        while(it.hasNext()) {
            if (article.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

}
