package toRun;

import Controlador.metodos;
import Modelo.Contacto;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author diego
 */
public class MainToRun {

    public static void main(String[] args) {
        int select = 0;
        metodos met = new metodos();
        ArrayList<Contacto> Liscon = new ArrayList<>();
        ArrayList<String> Lisconemail = new ArrayList<>();
        ArrayList<String> Liscontel = new ArrayList<>();
        do {
            System.out.println("Ingresa la opcion que deseas realizar: ");
            System.out.println("1.Agregar contacto");
            System.out.println("2.Listar contactos");
            System.out.println("3.Ingresar saldo");
            System.out.println("4.Buscar contacto");
            System.out.println("5.Modificar contacto");
            System.out.println("6.Transferir saldo a otro contacto");
            System.out.println("0.Finalizar proceso");
            Scanner op1 = new Scanner(System.in);
            Scanner emailt = new Scanner(System.in);
            Scanner salt = new Scanner(System.in);
            select = op1.nextInt();

            switch (select) { //Switch para poder ejecutar las opciones del usuario

                case 1:
                    Scanner leer = new Scanner(System.in);
                    System.out.println("Ingrese el nombre para guardar en la agenda:");
                    String nomtem = leer.nextLine();
                    System.out.println("Ingrese el numero de celular:");
                    String teltem = leer.nextLine();
                    teltem = met.uniquetel(teltem, Liscontel);
                    System.out.println("Ingrese el correo electronico:");
                    String emailtem = leer.nextLine();
                    emailtem = met.uniqueemail(emailtem, Lisconemail); //verficacion de un unico correo en el sistema  
                    System.out.println("Deseas ingresar saldo a la cuenta?(S/N):");
                    String op = leer.nextLine();

                    while ((op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n")) == false) {
                        System.out.println("Caracter invalido. Intenta de nuevo");
                        System.out.println("Deseas ingresar saldo a la cuenta?(S/N):");
                        op = leer.nextLine();
                    }
                    double saltem = 0;
                    if (op.equalsIgnoreCase("s")) {
                        System.out.println("Ingresa el saldo: ");
                        saltem = leer.nextDouble();
                        saltem = met.versaldoneg(saltem); //verificacion de saldo negativo
                    }

                    Contacto cont1 = new Contacto(nomtem, teltem, emailtem, saltem);

                    Liscon.add(cont1);
                    Lisconemail.add(cont1.getEmail());//Se guardan los correos en un array para despues ser listados ya que no tenemos base de datos
                    Liscontel.add(cont1.getTelCon());
                    break;

                case 2:
                    System.out.println("*******Lista de contactos*******"); //Se listan los contactos guardados en el array y se usa un bucle for para poder recorrer las posiciones
                    for (Contacto con : Liscon) {
                        System.out.println("Nombre: " + con.getNombreCom() + " - Correo: " + con.getEmail() + " - Saldo: " + con.getSaldo());
                    }
                    System.out.println("==================================");
                    break;
                case 3:
                    System.out.println("Ingresa el correo del usuario al que vas a ingresar saldo: ");
                    String emailin = emailt.nextLine();
                    if (Lisconemail.contains(emailin)) {
                        int pos = Lisconemail.indexOf(emailin);
                        System.out.println("Ingresa la cantidad a depositar: ");
                        double saldot = salt.nextDouble();
                        Liscon.get(pos).setSaldo(saldot);
                    } else {
                        System.out.println("Correo no registrado en el sistema");
                    }
                    break;

                case 4:
                    System.out.println("Deseas hacer la busqueda por numero de telefono o email?: ");
                    System.out.println("1.Email ");
                    System.out.println("2.Telefono ");
                    select = op1.nextInt();
                    switch (select) {
                        case 1:
                            System.out.println("Ingresa el email: ");
                            String emt = emailt.nextLine();
                            String e = met.findemail(emt, Lisconemail);
                            System.out.println(met.findUS(e, Liscon, Lisconemail));
                            break;
                        case 2:
                            System.out.println("Ingresa el telefono: ");
                            String tet = emailt.nextLine();
                            String t = met.findtel(tet, Liscontel);
                            
                            System.out.println(met.findUS(t, Liscon, Liscontel));
                            break;

                    }
                    break;

                case 5:
                    System.out.println("Ingresa el correo del usuario que deseas modificar: ");
                    String emtin = emailt.nextLine();
                    if (Lisconemail.contains(emtin)) {
                        int pos = Lisconemail.indexOf(emtin);
                        Contacto contemp = Liscon.get(pos);
                        System.out.println("Cual parametro deseas modificar?");
                        System.out.println("1.Nombre: " + Liscon.get(pos).getNombreCom());
                        System.out.println("2.Telefono: " + Liscon.get(pos).getTelCon());
                        System.out.println("3.Email: " + Liscon.get(pos).getEmail());
                        /*System.out.println("4.Saldo: " + Liscon.get(pos).getSaldo());*/
                        select = op1.nextInt();
                        switch (select) {
                            case 1:
                                System.out.println("Ingresa el nuevo nombre: ");
                                String nomt = emailt.nextLine();
                                contemp.setNombreCom(nomt);
                                System.out.println("Nombre modificado con exito");
                                System.out.println(contemp.toString());
                                break;
                            case 2:
                                System.out.println("Ingresa el nuevo telefono: ");
                                String tet = emailt.nextLine();
                                contemp.setTelCon(tet);
                                System.out.println("Telefono modificado con exito");
                                System.out.println(contemp.toString());
                                break;
                            case 3:
                                System.out.println("Ingresa el nuevo email: ");
                                String mailt = emailt.nextLine();
                                contemp.setEmail(mailt);
                                System.out.println("Email modificado con exito");
                                System.out.println(contemp.toString());
                                break;
                            /*case 4:
                                System.out.println("Ingresa el nuevo saldo: ");
                                double sne = salt.nextDouble();

                                contemp.setSaldo(met.versaldoneg(sne));

                                System.out.println("Saldo modificado con exito");
                                System.out.println(contemp.toString());
                                break;*/
                            default:
                                System.out.println("Seleccion invalida.");
                        }
                    } else {
                        System.out.println("Correo no registrado en el sistema");
                    }
                    Lisconemail.clear();
                    Liscontel.clear();
                    for (Contacto con : Liscon){
                        Lisconemail.add(con.getEmail());
                        Liscontel.add(con.getTelCon());
                    }
                    break;

                case 6:
                    System.out.println("Ingresa el correo del usuario que transfiere el saldo: ");
                    String mailt = emailt.nextLine();
                    String ema2="";
                    if (Lisconemail.contains(mailt)) {
                        int pos = Lisconemail.indexOf(mailt);
                        Contacto temp1=Liscon.get(pos);
                        do{
                           System.out.println("Ingresa el correo del usuario que recibe el saldo: ");
                        ema2 = emailt.nextLine(); 
                        }while (!Lisconemail.contains(ema2));
                        int pos2 = Lisconemail.indexOf(ema2);
                        Contacto temp2=Liscon.get(pos2);
                        temp2.setSaldo(temp1.getSaldo());
                        temp1.setSaldo(-temp1.getSaldo());
                        
                        
                    } else {
                        System.out.println("Correo no registrado en el sistema");
                    }
                    System.out.println("Transferencia exitosa");
                    
                    break;

                default:
                    System.out.println("Seleccion invalida.");
            }

        } while (select != 0);

    }

}
