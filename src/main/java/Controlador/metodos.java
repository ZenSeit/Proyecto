/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Contacto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class metodos {

    Scanner indou = new Scanner(System.in);

    /*Scanner em = new Scanner(System.in);
    Scanner leer = new Scanner(System.in);*/

    public Double versaldoneg(Double sal) {

        while (sal < 0) {
            System.out.println("Ingresa un saldo que no sea negativo");
            sal = indou.nextDouble();
        }
        return sal;
    }

    public String uniqueemail(String email, ArrayList<String> lisemail) {

        while (lisemail.contains(email)) {
            System.out.println("Ingresa un correo que NO este registrado: ");
            email = indou.nextLine();
        }
        return email;

    }
    
    public String findemail(String email, ArrayList<String> lisemail) {

        while (!lisemail.contains(email)) {
            System.out.println("Ingresa un correo que NO este registrado: ");
            email = indou.nextLine();
        }
        return email;

    }

    public String uniquetel(String tel, ArrayList<String> lisemail) {

        while (lisemail.contains(tel)) {
            System.out.println("El telefono ya se encuentra registrado. Ingresa otro diferente por favor: ");
            tel = indou.nextLine();
        }
        return tel;

    }
    
    public String findtel(String tel, ArrayList<String> lisemail) {

        while (!lisemail.contains(tel)) {
            System.out.println("El telefono ya se encuentra registrado. Ingresa otro diferente por favor: ");
            tel = indou.nextLine();
        }
        return tel;

    }

    public String findUS(String opbus, ArrayList<Contacto> Liscon, ArrayList<String> Lisconstr) {
        Contacto rescon;
        if (Lisconstr.contains(opbus)) {
            int pos = Lisconstr.indexOf(opbus);
            rescon=Liscon.get(pos);
            return rescon.toString();
        }
            return "El usuario no se encuentra registrado.";
    }

}
