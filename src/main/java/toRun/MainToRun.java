package toRun;


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
        ArrayList<Contacto> Liscon = new ArrayList<>();
        do {
            System.out.println("Ingresa la opcion que deseas realizar: ");
            System.out.println("1.Agregar contacto");
            System.out.println("2.Listar contactos");
            System.out.println("0.Finalizar proceso");
            Scanner op1 = new Scanner(System.in);
            select = op1.nextInt();

            switch (select) { //Switch para poder ejecutar las opciones del usuario

                case 1:
                    Scanner leer = new Scanner(System.in);
                    System.out.println("Ingrese el nombre para guardar en la agenda:");
                    String nomtem = leer.nextLine();
                    System.out.println("Ingrese el numero de celular:");
                    String teltem = leer.nextLine();
                    System.out.println("Ingrese el correo electronico:");
                    String emailtem = leer.nextLine();
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
                        while(saltem<0){
                            System.out.println("Ingresa un saldo que no sea negativo");
                            saltem = leer.nextDouble();
                        }
                    }

                    Contacto cont1 = new Contacto(nomtem, teltem, emailtem, saltem);

                    Liscon.add(cont1); //Se guardan los contactos en un array para despues ser listados ya que no tenemos base de datos
                    break;

                case 2:
                    System.out.println("*******Lista de contactos*******"); //Se listan los contactos guardados en el array y se usa un bucle for para poder recorrer las posiciones
                    for (Contacto con : Liscon) {
                        System.out.println("Nombre: " + con.getNombreCom());
                    }
                    System.out.println("==================================");
                    break;
                default:
                    System.out.println("Seleccion invalida.");
            }

        } while (select != 0);

    }

}
