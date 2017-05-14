/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author awelo
 */
public class Usuario {
    private String user;
    private String password;
    private int permisos;
    
    public Usuario(){
        permisos=0;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the permisos
     */
    public int getPermisos() {
        return permisos;
    }

    /**
     * @param permisos the permisos to set
     */
    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }
    
}
