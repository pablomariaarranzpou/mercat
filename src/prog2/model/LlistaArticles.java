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

    public LlistaArticles() {
        super();
    }
  
    @Override
    public void afegir(Article article) throws MercatException {
        if (contains(article)) {
            throw new MercatException("Aquest article ja existeix a la llista");
        } else {
            llista.add(article);
        }
    }

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
