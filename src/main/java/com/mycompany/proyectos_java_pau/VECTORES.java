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
            System.out.println("Digita el Nombre: ");
            name[i]=sc.next();
            System.out.println("Digita el Apellido: ");
            surname[i]=sc.next();
            System.out.println("Digita el Salario: ");
            salary[i]=sc.nextDouble();
            System.out.println("Digite los Días Trabajados: ");
            dwork[i]=sc.nextInt();
            System.out.println("Digite los Días Pagados: ");
            dpay[i]=sc.nextDouble();
        }
            menu(); 
    }

    
      public static void consultar(){
          do{System.out.println("Ingrese la posicion deseada: ");
          pos = sc.nextInt();
              System.out.println("Nombre: "+ name[pos]);
              System.out.println("Apellido: "+ surname[pos]);
              System.out.println("Salario: "+ salary[pos]);
              System.out.println("Días Trabajados: "+ dwork[pos]);
              System.out.println("Días Pagados: "+ dpay[pos]);
              System.out.println("¿Necesitas otra consulta?     1 = Sí    0 = No");
              des = sc.nextInt();
          }while(des != 0);
          menu();
          }
    
        public static void modificar(){
            do{System.out.println("¿Que posicion quieres editar?: ");
            pos = sc.nextInt();
            System.out.println("Nombre: ");
            name[pos]=sc.next();
              System.out.println("Apellido: ");
              surname[pos]= sc.next();
              System.out.println("Salario: ");
              salary[pos]= sc.nextDouble();
              System.out.println("Días Trabajados: ");
              dwork[pos]= sc.nextInt();
              System.out.println("Días Pagados: ");
              dpay[pos]= sc.nextDouble();
              System.out.println("¿Necesitas otra consulta?     1 = Sí    0 = No");
              des = sc.nextInt();
            }while(des != 0);
            menu();
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
                  dpay[i] = dpay[i + 1];
              }
              cantidad --; 
              name[cantidad] = null;
              surname[cantidad] = null;
              salary[cantidad] = 0;
              dwork[cantidad] = 0;
              dpay[cantidad] = 0;
               System.out.println("¿Deseas borrar otro registro?     1 = Si   0 = No");
                  des = sc.nextInt();
                  
              }while(des != 0);
              menu();
    }
}
