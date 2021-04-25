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
public abstract class Client {
    
    String id, correu, adreça;

    public Client(String id, String correu, String adreça) {
        this.id = id;
        this.correu = correu;
        this.adreça = adreça;
    }
    
    
    public abstract String tipusClient();

    public abstract float calcMensual();

    public abstract float descompteEnv();
}
