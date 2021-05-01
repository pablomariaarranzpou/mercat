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
 *
 * @author Pablo
 */
public class MercatUB {

    Controlador _control;

    public void gestioMercatUb() throws MercatException {
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Creació del controlador
        _control = new Controlador();
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

    public void gestioMenu(Scanner sc) throws MercatException {
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
                        _control.guardar();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());;
                    }

                    break;
                case M_Opcion_5_CarregarDades:
                    try {
                        _control.recuperar();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    } catch (ClassNotFoundException ex) {
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

    public void gestioMenuArticles(Scanner sc) throws MercatException {
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

                    String nom,
                     id;
                    float _preu;
                    int _temps;
                    boolean _admetUrgent = false;
                    String ans;

                    System.out.println("ID de l´Article:");
                    id = sc.next();
                    System.out.println("Nom de l´Article:");
                    nom = sc.next();
                    System.out.println("Temps? ");
                    _temps = sc.nextInt();
                    System.out.println("Preu?");
                    _preu = sc.nextFloat();
                    System.out.println("Admet urgent? (S/N)");
                    ans = sc.next();
                    ans = ans.toUpperCase();

                    if (ans.charAt(0) == 'S') {
                        _admetUrgent = true;
                    } else if (ans.charAt(0) == 'N') {
                        _admetUrgent = false;
                    }
                    while (ans.charAt(0) != 'S' && ans.charAt(0) != 'N') {

                        System.out.println("Admet urgent? (S/N)");
                        ans = sc.next();
                        ans = ans.toUpperCase();

                        if (ans.charAt(0) == 'S') {
                            _admetUrgent = true;
                        } else if (ans.charAt(0) == 'N') {
                            _admetUrgent = false;
                        }
                    }
                    try {
                        _control.addArticle(id, nom, _preu, _temps, _admetUrgent);
                    } catch (MercatException ex) {
                        System.err.println(ex.getMessage());
                    }

                    break;
                case M_Opcion_2_MostrarArticles:
                    _control.recuperarArticles();
                    break;
                case M_Opcion_3_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Articles.M_Opcion_3_Salir);
    }

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
                    int posArticle,
                     posClient;
                    String esUrgent;

                    _control.recuperarArticles();
                    System.out.println("Quin article vol afegir a la comanda?(posicio)");
                    posArticle = sc.nextInt();
                    _control.recuperarClients();
                    System.out.println("De quin article? (posicio)");
                    posClient = sc.nextInt();
                    System.out.println("Es Urgent?(s/n)");
                    esUrgent = sc.next();

                    while (!esUrgent.equals("s") && !esUrgent.equals("n")) {
                        System.out.println("Resposta invàlida");
                        System.out.println("Es Urgent?(s/n)");
                        esUrgent = sc.next();
                    }

                    try {
                        _control.addComanda(posArticle, posClient, posClient, true);
                    } catch (MercatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;

                case M_Opcion_2_EsborrarComanda:
                    int pos;
                    _control.recuperarComandes();
                    System.out.println("Quina comanda vol eliminar?");
                    pos = sc.nextInt();

                    try {
                        _control.eliminarComanda(pos);
                    } catch (MercatException ex) {
                        System.err.println(ex.getMessage());
                    }

                    break;
                case M_Opcion_3_MostrarComandes:
                    _control.recuperarComandes();
                    break;
                case M_Opcion_4_MostrarComandesUrgents:
                    _control.recuperarComandesUrgents();
                    break;
                case M_Opcion_5_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Comandes.M_Opcion_5_Salir);
    }

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
                    String esPremium,
                     correu,
                     nom,
                     adreca;

                    System.out.println("El cient es premium o estandard?");
                    esPremium = sc.next();

                    while (!esPremium.equals("premium") && !esPremium.equals("estandard")) {
                        System.out.println("Tipus de client no vàlid");
                        System.out.println("El cient es premium o estandard?");
                        esPremium = sc.next();
                    }

                    System.out.println("Correu del Client?");
                    correu = sc.next();
                    System.out.println("Nom del client?");
                    nom = sc.next();
                    System.out.println("Adreça del client?");
                    adreca = sc.next();

                    if (esPremium.equals("premium")) {
                        try {
                            _control.addClient(correu, nom, adreca, true);
                        } catch (MercatException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        try {
                            _control.addClient(correu, nom, adreca, false);
                        } catch (MercatException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case M_Opcion_2_MostrarClients:
                    _control.recuperarClients();
                    break;
                case M_Opcion_3_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Clients.M_Opcion_3_Salir);

    }
}
