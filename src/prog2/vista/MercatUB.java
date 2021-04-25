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
    
    public void gestioMercatUb(){
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
    /**

4 Guardar Dades: Guarda les dades de l'aplicació.
5 Carrega D ades: Carrega les dades de l'aplicació.
6 S ortir: Surt de l'aplicació.
     */
    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Gestionar Articles", // Opcion 1
        "Gestionar Clients", // Opcion 2
        "Gestionar Comandes", // Opcion 3
        "Guardar Dades", // Opcion 4
        "Carregar Dades", // Opcion 5
        "Sortir", // Opcion 6
    };

    
    public void gestioMenu(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu ", OpcionesMenu.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuEstacio.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuEstacio.mostrarMenu();
            opcionMenu = menuEstacio.getOpcio(sc);

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
    
}
