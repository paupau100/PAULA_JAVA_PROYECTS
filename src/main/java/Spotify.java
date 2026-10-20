import java.util.Scanner;

public class Spotify{

    // --- Nodo para Lista Doblemente Enlazada (Cola) ---
    static class cancion {
        String title;
        cancion siguiente;
        cancion previa;

        cancion(String titulo) {
            title = titulo;
        }
    }

    // --- Nodo para Lista Simplemente Enlazada (Historial) ---
    static class historial {
        String title;
        historial siguiente;

        historial(String titulo, historial sigCancion) {
            title = titulo;
            siguiente = sigCancion;
        }
    }

    // --- Reproductor ---
    static class Player {
        cancion head;
        cancion tail;
        cancion current;
        historial historial;

        void addTrack(String trackTitle) {
            cancion newNode = new cancion(trackTitle);
            if (head == null) {
                head = tail = current = newNode;
            } else {
                tail.siguiente = newNode;
                newNode.siguiente = tail;
                tail = newNode;
            }
            System.out.println("Canción agregada a la cola: " + trackTitle + "!");
        }

        void play() {
            if (current == null) {
                System.out.println("La cola está vacía. Agrega alguna canción");
                return;
            }
            System.out.println("\n==================================");
            System.out.println("▶ REPRODUCIENDO: " + current.title);
            System.out.println("==================================");
            
            // Registrar en historial simple (apilar al inicio)
            historial = new historial(current.title, historial);
        }

        void next() {
            if (current != null && current.siguiente != null) {
                current = current.siguiente;
                play();
            } else if (current == null) {
                System.out.println(" No hay canciones en la cola.");
            } else {
                System.out.println(" Has llegado al final: no hay más canciones hacia adelante.");
            }
        }

        void previous() {
            if (current != null && current.siguiente != null) {
                current = current.siguiente;
                play();
            } else if (current == null) {
                System.out.println("No hay canciones en la cola.");
            } else {
                System.out.println("Estás en el inicio.");
            }
        }

        void printQueue() {
            System.out.printf("%n--- COLA DE REPRODUCCIÓN (Lista Doble) ---");
            if (head == null) {
                System.out.println("(Vacía)");
                return;
            }
            cancion temp = head;
            while (temp != null) {
                if (temp == current) {
                    System.out.println("-- [" + temp.title + "] (Actual)");
                } else {
                    System.out.println("   [" + temp.title + "]");
                }
                temp = temp.siguiente;
            }
            System.out.println("-----------------------------------------\n");
        }

        void printHistory() {
            System.out.printf("%n--- HISTORIAL DE RECIENTES (Lista Simple) ---");
            if (historial == null) {
                System.out.println("(Sin reproducciones registradas)");
                return;
            }
            historial temp = historial;
            int step = 1;
            while (temp != null) {
                System.out.println(step + ". " + temp.title);
                temp = temp.siguiente;
                step = step + 1;
            }
            System.out.println("---------------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player spotify = new Player();

        // Canciones precargadas 
        spotify.addTrack("Blinding Lights - The Weeknd");
        spotify.addTrack("Starboy - The Weeknd");
        spotify.addTrack("Save Your Tears - The Weeknd");

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n====== SPOTIFY CONSOLA ======");
            System.out.println("1. Reproducir canción actual");
            System.out.println("2. Siguiente canción (Next )");
            System.out.println("3. Canción anterior (  Prev)");
            System.out.println("4. Agregar nueva canción");
            System.out.println("5. Ver cola de reproducción");
            System.out.println("6. Ver historial reciente");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            if (opcion == 1) {
                spotify.play();
            } else if (opcion == 2) {
                spotify.next();
            } else if (opcion == 3) {
                spotify.previous();
            } else if (opcion == 4) {
                System.out.print("Escribe el nombre de la canción: ");
                String name = scanner.nextLine();
                spotify.addTrack(name);
            } else if (opcion == 5) {
                spotify.printQueue();
            } else if (opcion == 6) {
                spotify.printHistory();
            } else if (opcion == 0) {
                System.out.println("Saliendo de Spotify...");
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}