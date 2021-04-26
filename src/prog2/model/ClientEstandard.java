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
public class ClientEstandard extends Client {

    public ClientEstandard(String nom, String correu, String adreça) {
        super(nom, correu, adreça);
    }

    @Override
    public String tipusClient() {
        return "Estandard";
    }

    @Override
    public float calcMensual() {
        return 0;   // Els clients estàndard no paguen mensualitat
    }

    @Override
    public float descompteEnv() {
        return 0; // Els clients estàndard no reben descomptes en l'enviament.
    }

}
