/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.MercatException;

/**
 * Classe abstracta que modelitza una llista de classes T qualsevol
 * @author Pablo
 * @param <T>
 */
public class Llista<T> implements Serializable {

   
    protected ArrayList<T> llista;

    /**
     * Cosntructor de la classe Llista<T>
     */
    public Llista() {        
       llista = new ArrayList<>();
    }

    /**
     * Getter de la mesura de la llista.
     * @return
     */
    public int getSize() {
          return llista.size();
    }

    /**
     * Afegir un element a la llista.
     * @param t
     * @throws MercatException
     */
    public void afegir(T t) throws MercatException {
          llista.add(t);
    }

    /**
     * Esborrar un element de la llista.
     * @param t
     * @throws MercatException
     */
    public void esborrar(T t) throws MercatException {
          llista.remove(t);
    }
    
    /**
     * Retrona un element d´una poscició en concret
     * @param position
     * @return
     */
    public T getAt(int position) {
          return llista.get(position);
    }

    /**
     * Buida la llista.
     */
    public void clear() {
          llista.clear();
    }
    
    /**
     * Indica si la llista esta Buida.
     * @return
     */
    public boolean isEmpty() {
          return llista.isEmpty();
    }

    /**
     * Passa a ArrayList la Llista.
     * @return
     */
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }
}
