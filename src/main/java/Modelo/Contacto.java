/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Contacto {
    
    private String NombreCom;
    private String TelCon;
    private String email;
    private double saldo;

    
    
    public Contacto(){
        
    }

    public Contacto(String NombreCom, String TelCon, String email) {
        this.NombreCom = NombreCom;
        this.TelCon = TelCon;
        this.email = email;
        saldo=0;
    }

    public Contacto(String NombreCom, String TelCon, String email, double saldo) {
        this.NombreCom = NombreCom;
        this.TelCon = TelCon;
        this.email = email;
        this.saldo = saldo;
    }

    public String getNombreCom() {
        return NombreCom;
    }

    public void setNombreCom(String NombreCom) {
        this.NombreCom = NombreCom;
    }

    public String getTelCon() {
        return TelCon;
    }

    public void setTelCon(String TelCon) {
        this.TelCon = TelCon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
