/*
 * Clase para arranque del sistema, en ella se espicifica que clases llamar y cuando
 */
package main;

import interfaces.FrmLogin;

/**
 *
 * @author awelo
 */

public class Main {
    public static void main(String[] args) {        
        //Creacion de la instancia del login y llamado del mismo
        FrmLogin login = new FrmLogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
