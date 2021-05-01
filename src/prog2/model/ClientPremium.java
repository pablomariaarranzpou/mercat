/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class ClientPremium extends Client implements Serializable{

    public ClientPremium(String nom, String correu, String adreça) {
        super(nom, correu, adreça);
    }

    @Override
    public String tipusClient() {
        return "Premium";
    }

    @Override
    public float calcMensual() {
        return 4f; // Els clients premium paguen una mensualitat de 4 euros.
    }

    @Override
    public float descompteEnv() {
        return 20f; // Els clients premium reben un 20% de descompte en l'enviament.
    }

}
