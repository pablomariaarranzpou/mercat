/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.List;
import prog2.vista.MercatException;

/**
 *
 * @author Pablo
 */
public interface InDades {
    
    /**
     *
     * @param id
     * @param nom
     * @param preu
     * @param temps
     * @param admetUrgent
     * @throws MercatException
     */
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException;
    
    /**
     *
     * @return
     */
    public List<String> recuperaArticles();

    /**
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esPremium
     * @throws MercatException
     */
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException;

    /**
     *
     * @return
     */
    public List<String> recuperaClients();

    /**
     *
     * @param articlePos
     * @param clientPos
     * @param quantitat
     * @param esUrgent
     * @throws MercatException
     */
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException; 
    
    /**
     *
     * @param position
     * @throws MercatException
     */
    public void esborrarComanda(int position) throws MercatException;
    
    /**
     *
     * @return
     */
    public List<String> recuperaComandes(); 
    
    /**
     *
     * @return
     */
    public List<String> recuperaComandesUrgents();
}
