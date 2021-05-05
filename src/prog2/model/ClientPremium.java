/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 * Classe Derivada de la classe Client
 *
 * @author Pablo
 */
public class ClientPremium extends Client implements Serializable {

    /**
     * Constructor de la Classe CLientPremium
     *
     * @param nom
     * @param correu
     * @param adreça
     */
    public ClientPremium(String nom, String correu, String adreça) {
        super(nom, correu, adreça);
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna la String amb
     * Premium
     *
     * @return
     */
    @Override
    public String tipusClient() {
        return "Premium";
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna el cacul mensual
     * = 4.0.
     *
     * @return
     */
    @Override
    public float calcMensual() {
        return 4f; // Els clients premium paguen una mensualitat de 4 euros.
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna el descompte
     * d´enviament -20%.
     *
     * @return
     */
    @Override
    public float descompteEnv() {
        return 20f; // Els clients premium reben un 20% de descompte en l'enviament.
    }

}
