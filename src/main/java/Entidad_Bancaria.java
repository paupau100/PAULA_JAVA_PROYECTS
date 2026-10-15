import java.util.ArrayList; //Importamos listas dinámicas 

import java.util.Locale; //Formatos texto o número según región

import java.util.Scanner; //Importamos para que pueda leer lo que el ususario escribe 

public class Entidad_Bancaria{
    
    //Declaramos las constantes 
    static final int CEDULA = 0;
    
    static final int NOMBRE = 1;
    
    static final int TIPO_SERV = 2;
    
    static final int MONTO = 3;
    
    // Declaramos variables locales
    static ArrayList<Object[]> usuarios = new ArrayList<>(); 
    
    static Scanner sc = new Scanner(System.in);
    
    static Locale co = Locale.forLanguageTag("es-Co");
    

    
    //Acá almacenaremos los títulos ordenados para adelante al imprimirlos se vean de manera estructurada
    static final String[] nombre_campo = {
        
        "Cédula","Nombre","Tipo de Servicio","Monto"
    };
    
    
  public static void main (String[] args) {
        menu();
        sc.close();
        
    }
    
    static void menu(){
        
        int opcion;
        
        do{
            System.out.printf("%n============= PAU'S BANK =============="); 
            System.out.println("Regristros actuales: "+ usuarios.size()); //Muestra el número de registros actuales 
            System.out.println("1. Regristrar ususario y servicio"); 
            System.out.println("2. Ver número de usuarios inscritos"); 
            System.out.println("3. Ver sumatoria total por servicio"); 
            System.out.println("4. Consultar por usuario");
            System.out.println("0. Salir ");
            System.out.println("Seleccione una opción: ");
            
            // Leeremos la respuesta del usuario
            opcion = Integer.parseInt(sc.nextLine().trim());
            
            //Usamos el switch case para evaluar lo que el usuario escogió 
            switch(opcion){
                case 1:
                    registrar(); //lleva al usuario a el proceso de registrar 
                    break;
                    
                case 2:
                    tot_usuarios(); // lleva al usuario al total de usuarios
                    break;
                    
                case 3: 
                    sum_servicio(); // lleva a la suma del servicio
                    break;
                    
                case 0: //Si la persona quiere cerrar el programa
                    System.out.printf("%nCierre del programa.Byeeeeee");
                    break;
                    
                default: //por default si escoge alguna opción no especificada en el menú 
                    System.out.println("Opción no válida.Intenta de nuevo.");
            }
                    
            }while (opcion != 0); //Ejecutará el switch mientras la respuesta del usuario no sea = 0
            
    
}
    static void registrar(){
        String continuar;//VARIABLE QUE NOS SERVIRÁ PARA GUARDAR MÁS ADELANTE PARA GUARDAR LA RESPUESTA DEL USUARIO 
        do{
            System.out.printf("%n====INGRESA USUARIO====%n");
        
            String nombre;
        do{//queremos obligar al Usuario a escribir algo así que usamos un do anidado
            System.out.println("Nombre Completo");
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()){//revisará si nombre quedó vacío 
                System.out.println("El nombre no puede estar vacío");
                
            }
            
        }while (nombre.isEmpty()); // repetirá la pregunta del do hasta que escriba algo válido 
                
            String cedula;//declaramos la variable que más adelante guardará el # de identificación 
            boolean repetida;//usaremos repetida como boolean para controlar que el usuario solo pueda ingresar una cedula con el mismo nombre 
            do { //si repetida sigue en false el programa sigue y lo termina pero si cambia a true el ciclo se repite y obliga al usuario a dar un valor válido
                System.out.println("Cédula: ");
                cedula = sc.nextLine().trim();
                repetida = false;
            
                for (int i = 0; i < usuarios.size(); i++)   {
                    String existe_cedula = (String) usuarios.get(i)[CEDULA];
                    if (cedula.equals(existe_cedula))   {
                        repetida = true;
                    }
                }
                if (cedula.isEmpty())   {
                    System.out.println("Este campo no puede estar vacío");
                    
                }else if (repetida) {
                    
                    System.out.println("Actualmente existe un registro con esa cédula");
                }
            } while (cedula.isEmpty() || repetida);
            
            int opcServicio;
            String tipoServicio;
            
            do {
            
            System.out.println("------- Menú -------");
            System.out.println("Por favor elija un servicicio: ");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.println("3. Crédito");
            System.out.println("4. Préstamo");
            
            opcServicio = Integer.parseInt(sc.nextLine().trim());
            
            switch (opcServicio)    {
                case 1:
                    
                    tipoServicio = "Cuenta de Ahorros";
                    break;
                    
                case 2:
                    tipoServicio = "Cuenta Corriente";
                    break;
                    
                case 3:
                    tipoServicio = "Crédito";
                    break;
                    
                    
                case 4:
                    tipoServicio = "Préstamo";
                    break;
                    
                case 0:
                    System.out.println("Cierre del programa...");
                    break;
                    
                    
                default:
                    System.out.println("Opción no válida upss");
            }
            
            } while (opcServicio > 4 || opcServicio < 0);
            
            System.out.println("Por favor escribir el monto ");
            double monto = Double.parseDouble(sc.nextLine().trim());
            
            
        
        
 
        
        }while();
                
    
    
    
    
    
    static void tot_usuarios()  {
        
    }
    
    static void sum_servicio()  {
        
    }
    
    
    
    
    
    
    
    
    
}