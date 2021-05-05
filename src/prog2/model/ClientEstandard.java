/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 * Classe Deriavda de la classe Client
 *
 * @author Pablo
 */
public class ClientEstandard extends Client implements Serializable {

    /**
     * Métode constructor de la classe ClientEstandard.
     *
     * @param nom
     * @param correu
     * @param adreça
     */
    public ClientEstandard(String nom, String correu, String adreça) {
        super(nom, correu, adreça);
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna la String amb
     * estandard
     *
     * @return
     */
    @Override
    public String tipusClient() {
        return "Estandard";
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna el cacul mensual
     * = 0.
     *
     * @return
     */
    @Override
    public float calcMensual() {
        return 0;   // Els clients estàndard no paguen mensualitat
    }

    /**
     * Sobresciptura del metode de la classe Client que retorna el descompte
     * d´enviament = 0.
     *
     * @return
     */
    @Override
    public float descompteEnv() {
        return 0; // Els clients estàndard no reben descomptes en l'enviament.
    }

}
