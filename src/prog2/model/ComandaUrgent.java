/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Classe que hereta de Comanda, i modelitza una comanda normal
 * @author janal
 */
public class ComandaUrgent extends Comanda implements Serializable{

    private final float _preuEnviament = 4; // Enviament comanda urgent = 4 euros
    private final long _tempsRebuda = 2; // Temps en rebre comanda normal = 1 dia

    /**
     * Constructor de la Classe ComandaUrgent
     * @param client
     * @param article
     * @param quantitat
     */
    public ComandaUrgent(Client client, Article article, int quantitat) {
        super(client, article, quantitat);
    }

    /**
     * Sobresciptura del metode de la classe Comanda quer etorna el tipus = "Urgent"
     * @return
     */
    @Override
    public String tipusComanda() {
        return "Urgent";
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna si una comanda ha sigut enviada.
     * @return
     */
    @Override
    public boolean comandaEnviada() {
        Date dataActual = new Date();
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataEnviament = new Date(_creacioComanda.getTime() + _article.getTempsFinsEnviament() / 2);
        return dataActual.after(dataEnviament);
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna si una comanda ha sigut rebuda
     * @return
     */
    @Override
    public boolean comandaRebuda() {
        Date dataActual = new Date();
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataRebuda = new Date(_creacioComanda.getTime() + TimeUnit.DAYS.toMillis(_tempsRebuda));
        return dataActual.after(dataRebuda);
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna el preu de l´enviament.
     * @return
     */
    @Override
    public float preuEnviament() {
        return _preuEnviament - (_preuEnviament * (_client.descompteEnv() / 100));
    }

}
