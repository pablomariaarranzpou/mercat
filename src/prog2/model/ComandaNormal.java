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
public class ComandaNormal extends Comanda implements Serializable{

    private final float _preuEnviament = 1; // Enviament comanda normal = 1 euro
    private final long _tempsRebuda = 2; // Temps en rebre comanda normal = 2 dies
    
    /**
     * Constructor de la Classe ComandaNormal
     * @param client
     * @param article
     * @param quantitat
     */
    public ComandaNormal(Client client, Article article, int quantitat) {
        super(client, article, quantitat);
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna el tipus = "Normal"
     * @return
     */
    @Override
    public String tipusComanda() {
        return "Normal";
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna si una comanda ha sigut enviada
     * @return
     */
    @Override
    public boolean comandaEnviada() {
        Date dataActual = new Date();
        Comanda comanda = (Comanda) this;
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataEnviament = new Date(comanda.getCreacioComanda().getTime() + comanda.getArticle().getTempsFinsEnviament());
        return dataActual.after(dataEnviament);
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna si una comanda ha sigut rebuda
     * @return
     */
    @Override
    public boolean comandaRebuda() {
        Date dataActual = new Date();
        Comanda comanda = (Comanda) this;
        // Trobem la data d'enviament sumant la data de creació més el temps fins enviaments
        Date dataRebuda = new Date(comanda.getCreacioComanda().getTime() + TimeUnit.DAYS.toMillis(_tempsRebuda));
        return dataActual.after(dataRebuda);
    }

    /**
     * Sobresciptura del metode de la classe Comanda que retorna el preu de enviament.
     * @return
     */
    @Override
    public float preuEnviament() {
        Comanda comanda = (Comanda) this;
        return _preuEnviament - (_preuEnviament * (comanda.getClient().descompteEnv()/100));
    }

}
