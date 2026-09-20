
package com.mycompany.proyectos_java_pau;
import java.util.Scanner;
public class VECTORES {
static Scanner sc = new Scanner ( System.in);
static String [] name = new String[10];
static String [] surname = new String[10];
static double [] salary = new double[10];
static int [] dwork = new int[10];
static double [] dpay = new double[10];
static int opc;
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("====================");
        System.out.println("    MENU PRINCIPAL   ");
        System.out.println("====================");
        System.out.println("1. Capturar");
        System.out.println("2. Consultar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Salir");
        System.out.println("digite su opción:");
        opc = sc.nextInt();
        switch (opc){
            case 1: capturar();
            break;
             case 2: consultar();
            break;
             case 3: modificar();
            break;
             case 4: eliminar();
            break;
             case 5:;
            break;
             default:System.out.println("opcion no valida....");
             menu();
        }
     }
    public static void capturar(){
    }
      public static void consultar(){
    }
        public static void modificar(){
    }
          public static void eliminar(){
    }
}
