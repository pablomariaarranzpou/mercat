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
 *
 * @author janal
 */
public class ComandaUrgent extends Comanda implements Serializable{

    private final float _preuEnviament = 4; // Enviament comanda urgent = 4 euros
    private final long _tempsRebuda = 2; // Temps en rebre comanda normal = 1 dia

    public ComandaUrgent(Client client, Article article, int quantitat) {
        super(client, article, quantitat);
    }

    @Override
    public String tipusComanda() {
        return "Urgent";
    }

    @Override
    public boolean comandaEnviada() {
        Date dataActual = new Date();
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataEnviament = new Date(_creacioComanda.getTime() + _article.getTempsFinsEnviament() / 2);
        return dataActual.after(dataEnviament);
    }

    @Override
    public boolean comandaRebuda() {
        Date dataActual = new Date();
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataRebuda = new Date(_creacioComanda.getTime() + TimeUnit.DAYS.toMillis(_tempsRebuda));
        return dataActual.after(dataRebuda);
    }

    @Override
    public float preuEnviament() {
        return _preuEnviament - (_preuEnviament * (_client.descompteEnv() / 100));
    }

}
