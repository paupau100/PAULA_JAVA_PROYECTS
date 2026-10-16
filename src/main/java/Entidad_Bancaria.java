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
      //Llamamos al método principal que muestra el menú del banco 
        menu();
        //Cerramos el Scanner para liberar recursos
        sc.close();
        
    }
    //Acá viene el menú
    static void menu(){
        //declaramos la variable en la que se guardará lo que escoja el usuario
        int opcion;
        //mantendremos el ciclo activo hasta que el usuario quiera salir
        do{
            System.out.printf("%n============= PAU'S BANK ==============%n");
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
                    
                case 4:
                    consultar();
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
            
                //Recorreremos toda la lista para verificar si está o no repetida la cédula
                for (int i = 0; i < usuarios.size(); i++)   {
                    String existe_cedula = (String) usuarios.get(i)[CEDULA];
                    if (cedula.equals(existe_cedula))   {
                        repetida = true;
                    }
                }
                //si el usuario le da enter sin haber insertado ningún valor saldrá un mensaje
                if (cedula.isEmpty())   {
                    System.out.println("Este campo no puede estar vacío");
                    
                    //si llega a estar repetida mostrará un mensaje y obligara al usuario a escribir otro valor 
                }else if (repetida) {
                    
                    System.out.println("Actualmente existe un registro con esa cédula");
                }
            } while (cedula.isEmpty() || repetida);
            
            int opcServicio;
            String tipoServicio = null;
            
            do {
            //Creamos un menú para que el usuario escoja el tipo de servicio 
            System.out.println("------- Menú -------");
            System.out.println("Por favor elija un servicicio: ");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.println("3. Crédito");
            System.out.println("4. Préstamo");
            
            opcServicio = Integer.parseInt(sc.nextLine().trim());
            //Usamos un switch para guardar la respuesta del usuario en la variable "tipoServicio"
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
                    
                    //En el caso de que el usuario escoja 0 se devolvera al menú de inicio 
                case 0:
                    System.out.println("Retornandooo...");
                    menu();
                    break;
                    
                    //Por default si accidentalmente oprime alguna letra,num.etc equivocadamente saldrá una alerta 
                default:
                    System.out.println("Opción no válida upss");
            }
            //El ciclo se repetirá mientras la respuesta sea mayor a 4 y menor a 0,
            //nos ayuda a validar que la respuesta esté entre los parámetros del switch
            } while (opcServicio > 4 || opcServicio < 0);
            
            double monto = 0;
            boolean montoValido = false;//creamos una variable boolean para controlar la validez del monto 
            do{//Obligaremos al usuario a digitar un valor correcto
                //Le diremos al programa que intente ejecutar la captura del monto y si el usuario escribe texto o valores erróneos,no se romperá el sistema y solo
                //lanzará un mensaje
                try{
            //Pasamos a preguntar por el monto y convertimos ese texto en decimal para poder hacer operaciones 
            System.out.println("Por favor escribir el monto ");
            monto = Double.parseDouble(sc.nextLine().trim());
            //Si la conversión en exitosa,cambiará a true 
            montoValido = true;
                 }catch(NumberFormatException e) {//Si hay un error de formato se mostrará una alerta 
                    System.out.println("Errorrrr Ingresa un monto válido ");
                    montoValido = false;
                 }
            }while(!montoValido);
            //Agregamos los datos a un arreglo Object[] y se lo añadimos al arrayList
            Object[] nuevoUser = new Object[4];
            nuevoUser[NOMBRE] = nombre;
            nuevoUser[CEDULA] = cedula;
            nuevoUser[TIPO_SERV] = tipoServicio;
            nuevoUser[MONTO] = monto;
            usuarios.add(nuevoUser);//Añadiremos el registro nuevo a la lista de usuarios
            System.out.println("¿Quiere agregar otro registro? " + "S/N");
            continuar = sc.nextLine().trim();
               
                
        
        }while(continuar.equalsIgnoreCase("S"));
    }
    
    
    
    
    //Imprimimos el total de usuarios mediante la función .size
    static void tot_usuarios()  {
        System.out.printf("%n--------- TOTAL USUARIOS ---------%n");
        System.out.printf("%nHay " +(usuarios.size()) + " usuarios%n");
        
    }
    //Usamos acumuladores para cada servicio y los inicializamos en 0
    static void sum_servicio()  {
        double totAhorros = 0.0;
        double totCorriente = 0.0;
        double totCredito = 0.0;
        double totPrestamo = 0.0;
        
        //Recorremos la lista 
        for (int i = 0; i < usuarios.size(); i++)   {
            //Obtenemos el tipo de servicio actual y lo convertimos a String  
                    String serv = (String) usuarios.get(i)[TIPO_SERV];
                    //Obtenemos el monto actual y lo convertimos en double 
                    double monto = (double) usuarios.get(i)[MONTO];
                    
                    //Acá evaluamos el tipo de servicio y sumamos el monto al acumulador de cada servicio
                    if (serv.equals("Cuenta de Ahorros"))   {
                        totAhorros += monto;
                    }else if (serv.equals("Cuenta Corriente")){
                        totCorriente += monto;
                    }else if (serv.equals("Crédito")){
                        totCredito += monto;
                    }else if (serv.equals("Préstamo")){
                        totPrestamo += monto;
                    }
                    
        }
                    //Imprimimos el reporte con las sumatorias 
                  System.out.printf("%n-------- SUMATORIA POR SERVICIO --------%n");
                  System.out.printf("%-25s : $%,.2f%n", "Total Cuenta de Ahorros", totAhorros);
                  System.out.printf("%-25s : $%,.2f%n", "Total Cuenta Corriente", totCorriente);
                  System.out.printf("%-25s : $%,.2f%n", "Total Crédito", totCredito);
                  System.out.printf("%-25s : $%,.2f%n", "Total Préstamo", totPrestamo);
    }
    
    
    
    static void consultar()    {
        int opcConsulta;//declaramos una variable que contendrá el sub-menú de las consultas
        
        do{//do-while para mantener activo el menú hasta que el usuario desee salir 
            System.out.printf("%n----------- CONSULTAR -----------%n");
            System.out.println("1. Individual");
            System.out.println("2. Todos");
            System.out.println("3. Regresar al menú");
            
            opcConsulta = Integer.parseInt(sc.nextLine().trim());//Se captura la elección del usuario 
            
            if (opcConsulta == 1)   {//Si elijió la opción 1 que es la individual 
                //Acá es la búsqueda individual
                if (usuarios.isEmpty()) {//Verifica si hay registros y muestra un mensaje en el caso que no hayan
                    System.out.println("No hay registros...");
                }else{//Si encuentra registros pregunta por la posición a consultar 
                    System.out.println("Ingresa la posición que vas a consultar ( de 0 a " +
                            (usuarios.size() - 1) + "):");
                }
                //Se valida que la posición sea válida y se extrae el array  de los datos 
                int posicion = Integer.parseInt(sc.nextLine().trim());//Se captura la respuesta 
                if (posicion < 0 || posicion >= usuarios.size())    {
                    System.out.println("La posición está fuera del rango");
                }else{
                 Object[] p = usuarios.get(posicion);//Se imprimirá de manera ordenada la información correspondiente a la posición
                    System.out.printf("%n----REGISTRO EN LA POSICIÓN " + posicion + " ----%n");
                    System.out.printf(co,"Nombre: " + p[NOMBRE]);
                    System.out.printf(co," Cédula: " + p[CEDULA]);
                    System.out.printf(co," Tipo de Servicio: " +  p[TIPO_SERV]);
                    System.out.printf(co," Monto: $%,.2f%n",(double) p[MONTO]);
                }
            }else if (opcConsulta == 2){//evalua en el caso de que la opción elegida sea 2 
                if(usuarios.isEmpty())  {//confirma si está vació el registro 
                System.out.println("No hay Usuarios registrados");
                }else{
                    System.out.printf("%-10s | %-20s | %-15s | %s%n",//imprime los títulos 
                            "Posición","Nombre","Cédula","Tipo de Servicio");
                    System.out.println("--------------------------------------------------------------------------------------------");
                    for(int i = 0;i < usuarios.size(); i++){//recorre desde la posición 0 hasta el tamaño del array 
                        Object[] p = (Object[]) usuarios.get(i);//casteamos el objeto genérico a un arreglo object[]
                        System.out.printf("%-10d | %-20s | %-15s | %-20s |$%,.2f%n",//Imprimimos las filas 
                                i,
                                p[NOMBRE],
                                p[CEDULA],
                                p[TIPO_SERV],
                                (double) p [MONTO]);
                            }
                        }
            }
        }while(opcConsulta != 3);//El sub menú se repetirá mientras la oción sea diferente de 3 (regresa)
    }
}