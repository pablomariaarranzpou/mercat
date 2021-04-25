/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/**
 *
 * @author Pablo
 */
public abstract class Comanda {
    
    public abstract String tipusComanda();

    public abstract boolean comandaEnviada();

    public abstract boolean comandaRebuda();

    public abstract float preuEnviament();
    
}
