/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author janal
 */
public class ComandaNormal extends Comanda {

    private final float _preuEnviament = 1; // Enviament comanda normal = 1 euro
    private final long _tempsRebuda = 2; // Temps en rebre comanda normal = 2 dies
    
    public ComandaNormal(Client client, Article article, int quantitat) {
        super(client, article, quantitat);
    }

    @Override
    public String tipusComanda() {
        return "Normal";
    }

    @Override
    public boolean comandaEnviada() {
        Date dataActual = new Date();
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataEnviament = new Date(_creacioComanda.getTime() + _article.getTempsFinsEnviament());
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
        return _preuEnviament - (_preuEnviament * (_client.descompteEnv()/100));
    }

}
