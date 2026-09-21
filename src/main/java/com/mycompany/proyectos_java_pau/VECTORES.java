package com.mycompany.proyectos_java_pau;
import java.util.Scanner;
public class VECTORES {
static Scanner sc = new Scanner ( System.in);
static String [] name = new String[10 ];
static String [] surname = new String[10];
static double [] salary = new double[10];
static int [] dwork = new int[10];
static double [] tp = new double[10];
static int opc;
static int cantidad;
static int pos; 
static int des = 0;
static int res;
static int[] vec = new int[10];
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
        System.out.println("¿Cuántos empleados desea registrar?: ");
        cantidad =sc.nextInt();
        for(int i = 0; i < cantidad; i ++){
            System.out.println("Digit the name: ");
            name[i]=sc.next();
            System.out.println("Digit the surname: ");
            surname[i]=sc.next();
            System.out.println("Digit the salary: ");
            salary[i]=sc.nextDouble();
            System.out.println("Digit the days worked: ");
            dwork[i]=sc.nextInt();
            tp[i]= (salary[i]/30)*dwork[i];
                    }
            menu(); 
    }

    
      public static void consultar(){
            System.out.println("************");
    System.out.println("         MENU CONSULTA          ");
    System.out.println("************");
    System.out.println("1. Consulta General");
    System.out.println("2. Consulta Individual");
    System.out.println("3. Regresar al Menu");
    System.out.println("Digite su opcion ");
    opc = sc.nextInt();
    
    switch(opc){
        case 1:
            for(int i = 0 ; i < cantidad;i++){
                System.out.printf("Name   "+"Surname   "+"Salary   "+"Days worked   "+ "Total a pagar   ");
                System.out.printf(name[pos]+   surname[pos]   +salary[pos]   +dwork[pos]   +tp[pos]);
                }
                    break;
    }
    
          do{System.out.println("Ingrese la posicion deseada: ");
          pos = sc.nextInt();
              System.out.printf("Name   "+"Surname   "+"Salary   "+"Days worked   "+ "Total a pagar   ");
                System.out.printf(name[pos]+   surname[pos]   +salary[pos]   +dwork[pos]   +tp[pos]);
              System.out.println("¿Need another consultation?     1 = Sí    0 = No");
              des = sc.nextInt();
          }while(des != 0);
          consultar();
          }
    
        public static void modificar(){
            do{System.out.println("¿Que posicion quieres editar?: ");
            pos = sc.nextInt();
            System.out.printf("Nombre: ");
            name[pos]=sc.next();
              System.out.printf("  Apellido: ");
              surname[pos]= sc.next();
              System.out.printf("  Salario: ");
              salary[pos]= sc.nextDouble();
              System.out.printf("  Días Trabajados: ");
              dwork[pos]= sc.nextInt();
              System.out.println("¿Need another consultation?     1 = Sí    0 = No");
              des = sc.nextInt();
            }while(des != 0);
            modificar();
    }

          public static void eliminar(){
              do{
                  System.out.println("Digite la poscicion que necesita borrar: ");
              pos = sc.nextInt();
              for(int i = pos;i < cantidad - 1;i++){
                  name[i] = name[i + 1];
                  surname[i] = surname[i + 1];
                  salary[i] = salary[i + 1];
                  dwork[i] = dwork[i + 1];
              }
              cantidad --; 
              name[cantidad] = null;
              surname[cantidad] = null;
              salary[cantidad] = 0;
              dwork[cantidad] = 0;
               System.out.println("¿Deseas borrar otro registro?     1 = Si   0 = No");
                  des = sc.nextInt();
                  
              }while(des != 0);
              eliminar();
    }
}
