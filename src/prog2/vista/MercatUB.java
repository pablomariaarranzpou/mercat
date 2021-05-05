/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.io.IOException;
import java.util.Scanner;
import prog2.controlador.Controlador;

/**
 * Classe MercatUB que gestiona tota la Vista.
 * @author Pablo
 */
public class MercatUB {

    Controlador _controlador;

    /**
     * Métode d´inici del Mercat.
     */
    public void gestioMercatUb() {
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Creació del controlador
        _controlador = new Controlador();
        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    private static enum OpcionesMenu {
        M_Opcion_1_GestioArticles,
        M_Opcion_2_GestioClients,
        M_Opcion_3_GestioComandes,
        M_Opcion_4_GuardarDades,
        M_Opcion_5_CarregarDades,
        M_Opcion_6_Salir
    };

    private static enum OpcionesMenu_Articles {
        M_Opcion_1_AfegirArticle,
        M_Opcion_2_MostrarArticles,
        M_Opcion_3_Salir
    };

    private static enum OpcionesMenu_Clients {
        M_Opcion_1_AfegirClient,
        M_Opcion_2_MostrarClients,
        M_Opcion_3_Salir
    };

    private static enum OpcionesMenu_Comandes {
        M_Opcion_1_AfegirComandes,
        M_Opcion_2_EsborrarComanda,
        M_Opcion_3_MostrarComandes,
        M_Opcion_4_MostrarComandesUrgents,
        M_Opcion_5_Salir
    };

    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Gestionar Articles", // Opcion 1
        "Gestionar Clients", // Opcion 2
        "Gestionar Comandes", // Opcion 3
        "Guardar Dades", // Opcion 4
        "Carregar Dades", // Opcion 5
        "Sortir", // Opcion 6
    };

    private static final String[] descMenu_Clients = {
        "Afegir Client", // Opcion 1
        "Mostrar Clients", // Opcion 2
        "Sortir", // Opcion 3
    };

    private static final String[] descMenu_Articles = {
        "Afegir Article", // Opcion 1
        "Mostrar Articles", // Opcion 2
        "Sortir", // Opcion 3
    };

    private static final String[] descMenu_Comandes = {
        "Afegir Comanda", // Opcion 1
        "Esborrar Comanda", // Opcion 2
        "Mostrar Comandes", // Opcion 3
        "Mostrar Comandes Urgents", // Opcion 4
        "Sortir", // Opcion 5
    };

    /**
     * Gestio del menú principal.
     * @param sc
     */
    public void gestioMenu(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuMercat = new Menu<>("Menu ", OpcionesMenu.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_GestioArticles:
                    gestioMenuArticles(sc);
                    break;
                case M_Opcion_2_GestioClients:
                    gestioMenuClients(sc);
                    break;
                case M_Opcion_3_GestioComandes:
                    gestioMenuComandes(sc);
                    break;
                case M_Opcion_4_GuardarDades:
                    try {
                        _controlador.guardar();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case M_Opcion_5_CarregarDades:
                    try {
                        _controlador.recuperar();
                    } catch (IOException | ClassNotFoundException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case M_Opcion_6_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != OpcionesMenu.M_Opcion_6_Salir);
    }

    /**
     * Gestio del menú secundari d´ Articles
     * @param sc
     */
    public void gestioMenuArticles(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<MercatUB.OpcionesMenu_Articles> menuMercat = new Menu<>("Menu ", MercatUB.OpcionesMenu_Articles.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu_Articles);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Articles opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_AfegirArticle:
                    System.out.println("ID de l´Article:");
                    String id = sc.next();
                    System.out.println("Nom de l´Article:");
                    String nom = sc.next();
                    System.out.println("Temps? ");
                    int temps = sc.nextInt();
                    System.out.println("Preu?");
                    float preu = sc.nextFloat();
                    boolean admetUrgent = checkIfAdmetUrgent(sc);
                    
                    try {
                        _controlador.addArticle(id, nom, preu, temps, admetUrgent);
                    } catch (MercatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case M_Opcion_2_MostrarArticles:
                    _controlador.recuperarArticles();
                    break;
                case M_Opcion_3_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Articles.M_Opcion_3_Salir);
    }
    
    /**
     * Métode que comprova si admet urgent.
     * @param sc
     * @return 
     */
    private boolean checkIfAdmetUrgent(Scanner sc) {
        boolean admetUrgent = false;
        System.out.println("Admet urgent? (S/N)");
        String ans = sc.next();
        ans = ans.toUpperCase();
        if (ans.charAt(0) == 'S') {
            admetUrgent = true;
        } else if (ans.charAt(0) == 'N') {
            admetUrgent = false;
        }
        while (ans.charAt(0) != 'S' && ans.charAt(0) != 'N') {

            System.out.println("Admet urgent? (S/N)");
            ans = sc.next();
            ans = ans.toUpperCase();

            if (ans.charAt(0) == 'S') {
                admetUrgent = true;
            } else if (ans.charAt(0) == 'N') {
                admetUrgent = false;
            }
        }
        return admetUrgent;
    }

    /**
     * Gestio del menú secundari de comandes
     * @param sc Scanner per escriure per consola
     */
    public void gestioMenuComandes(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<MercatUB.OpcionesMenu_Comandes> menuMercat = new Menu<>("Menu ", MercatUB.OpcionesMenu_Comandes.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu_Comandes);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Comandes opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {

                case M_Opcion_1_AfegirComandes:
                    if (!_controlador.recuperarArticles()) {
                        System.out.println("No hi ha articles per afegir.");
                        break;
                    }
                    System.out.println("Quin article vol afegir a la comanda? (posicio)");
                    int posArticle = sc.nextInt() - 1;  // Index des de 1
                    System.out.println("Quants?");
                    int quantitat = sc.nextInt();
                    if (!_controlador.recuperarClients()) {
                        System.out.println("No hi ha clients. Afegeix-ne per crear una comanda.");
                        break;
                    }
                    System.out.println("De quin client? (posicio)");
                    int posClient = sc.nextInt() - 1; // Index des de 1
                    boolean urgent = checkIfIsUrgent(sc);

                    try {
                        _controlador.addComanda(posArticle, posClient, quantitat, urgent);
                    } catch (MercatException | ArrayIndexOutOfBoundsException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;

                case M_Opcion_2_EsborrarComanda:
                    if(!_controlador.recuperarComandes()){
                        System.out.println("No hi ha comandes a mostrar.");
                    }
                    System.out.println("Quina comanda vol eliminar? (posicio)");
                    int pos = sc.nextInt() - 1;

                    try {
                        _controlador.eliminarComanda(pos);
                    } catch (MercatException | ArrayIndexOutOfBoundsException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case M_Opcion_3_MostrarComandes:
                    if(!_controlador.recuperarComandes()){
                        System.out.println("No hi ha comandes a mostrar.");
                    }
                    break;
                case M_Opcion_4_MostrarComandesUrgents:
                    if(!_controlador.recuperarComandesUrgents()){
                        System.out.println("No hi ha comandes urgents a mostrar.");
                    }
                    break;
                case M_Opcion_5_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Comandes.M_Opcion_5_Salir);
    }
    
    /**
     * Métode de suport per saber si es urgent
     * @param sc
     * @return 
     */
    private boolean checkIfIsUrgent(Scanner sc) {
        boolean urgent = false;
        System.out.println("Es Urgent?(S/N)");
        String esUrgent = sc.next();
        esUrgent = esUrgent.toLowerCase();
        if (esUrgent.equals("s")) {
            urgent = true;
        }
        while (!esUrgent.equals("s") && !esUrgent.equals("n")) {
            System.out.println("Resposta invàlida");
            System.out.println("Es Urgent?(s/n)");
            esUrgent = sc.next();
            esUrgent = esUrgent.toLowerCase();
            if (esUrgent.equals("s")) {
                urgent = true;
            }
        }
        return urgent;
    }

    /**
     * Gestio del menú secundari de CLients
     * @param sc
     */
    public void gestioMenuClients(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<MercatUB.OpcionesMenu_Clients> menuMercat = new Menu<>("Menu ", MercatUB.OpcionesMenu_Clients.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu_Clients);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Clients opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_AfegirClient:
                    boolean premium = checkIfPremium(sc);
                    System.out.println("Correu del Client?");
                    String correu = sc.next();
                    System.out.println("Nom del client?");
                    String nom = sc.next();
                    System.out.println("Adreça del client?");
                    sc.nextLine(); // nextLine extra per eliminar l'últim \n
                    String adreca = sc.nextLine();

                    try {
                        _controlador.addClient(correu, nom, adreca, premium);
                    } catch (MercatException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case M_Opcion_2_MostrarClients:
                    _controlador.recuperarClients();
                    break;
                case M_Opcion_3_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Clients.M_Opcion_3_Salir);

    }
    
    /**
     * Métode per a indicar si un Client és premium
     * @param sc
     * @return 
     */

    private boolean checkIfPremium(Scanner sc) {
        String esPremium;
        boolean premium = false;
        System.out.println("El cient es premium o estandard?");
        esPremium = sc.next();
        esPremium = esPremium.toLowerCase();
        if (esPremium.equals("premium")) {
            premium = true;
        }
        while (!esPremium.equals("premium") && !esPremium.equals("estandard")) {
            System.out.println("Tipus de client no vàlid");
            System.out.println("El cient es premium o estandard?");
            esPremium = sc.next();
            esPremium = esPremium.toLowerCase();
            if (esPremium.equals("premium")) {
                premium = true;
            }
        }
        return premium;
    }
}
