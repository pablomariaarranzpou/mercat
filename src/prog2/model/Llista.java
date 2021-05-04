/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.MercatException;

public class Llista<T> implements Serializable {
   protected ArrayList<T> llista;

   public Llista() {        
       llista = new ArrayList<>();
    }

    public int getSize() {
          return llista.size();
    }

    public void afegir(T t) throws MercatException {
          llista.add(t);
    }

    public void esborrar(T t) throws MercatException {
          llista.remove(t);
    }
    
    public T getAt(int position) {
          return llista.get(position);
    }

    public void clear() {
          llista.clear();
    }
    
    public boolean isEmpty() {
          return llista.isEmpty();
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }
}
