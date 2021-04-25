/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.Scanner;
import prog2.model.Dades;

/**
 *
 * @author Pablo
 */
public class MercatUB {

    Dades _data;

    public void gestioMercatUb() {
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
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
                    break;
                case M_Opcion_2_GestioClients:
                    break;
                case M_Opcion_3_GestioComandes:
                    break;
                case M_Opcion_4_GuardarDades:
                    break;
                case M_Opcion_5_CarregarDades:
                    break;
                case M_Opcion_6_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != OpcionesMenu.M_Opcion_6_Salir);
    }

    public void gestioMenuArticles(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<MercatUB.OpcionesMenu_Articles> menuMercat = new Menu<>("Menu ", MercatUB.OpcionesMenu_Articles.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Articles opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_AfegirArticle:
                    break;
                case M_Opcion_2_MostrarArticles:
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
        menuMercat.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Comandes opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {

                case M_Opcion_1_AfegirComandes:
                    break;
                case M_Opcion_2_EsborrarComanda:
                    break;
                case M_Opcion_3_MostrarComandes:
                    break;
                case M_Opcion_4_MostrarComandesUrgents:
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
        menuMercat.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        MercatUB.OpcionesMenu_Clients opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_AfegirClient:
                    break;
                case M_Opcion_2_MostrarClients:
                    break;
                case M_Opcion_3_Salir:
                    break;
                default:
                    System.out.println("Aquesta no és una opció vàlida.");
            }

        } while (opcionMenu != MercatUB.OpcionesMenu_Clients.M_Opcion_3_Salir);

    }
}
