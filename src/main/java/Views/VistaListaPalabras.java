package Views;
import Controllers.ControladorListaPalabras;
import java.util.Scanner;

public class VistaListaPalabras {
    
    private ControladorListaPalabras controlador;
    private Scanner scanner;

    public VistaListaPalabras(ControladorListaPalabras controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n*** Gestor de Lista de Palabras ***");
            System.out.println("1. Agregar una nueva palabra");
            System.out.println("2. Buscar una palabra");
            System.out.println("3. Eliminar una palabra");
            System.out.println("4. Editar una palabra");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarPalabra();
                case 2 -> buscarPalabra();
                case 3 -> eliminarPalabra();
                case 4 -> editarPalabra();
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del programa...");
                }
                default -> System.out.println("Opción inválida, intenta de nuevo.");
            }
        }
    }

    private void agregarPalabra() {
        String palabra;
        do {
            System.out.print("Ingresa la palabra que deseas agregar: ");
            palabra = scanner.nextLine();
            if (palabra == null || palabra.isEmpty()) {
                System.out.println("No se puede dejar en blanco.");
            } else if (!palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
                System.out.println("La palabra contiene caracteres no válidos.");
                palabra = ""; // Reiniciar palabra para repetir el bucle
            }
        } while (palabra == null || palabra.isEmpty());
        controlador.agregarPalabra(palabra);
    }

    private void buscarPalabra() {
        System.out.print("Ingresa la palabra que deseas buscar: ");
        String palabra = scanner.nextLine();
        controlador.buscarPalabra(palabra);
    }

    private void eliminarPalabra() {
        if (controlador.listaVacia()) {
            System.out.println("La lista de palabras está vacía.");
        } else {
            System.out.print("Ingresa la palabra que deseas eliminar: ");
            String palabra = scanner.nextLine();
            controlador.eliminarPalabra(palabra);
        }
    }

    private void editarPalabra() {
        System.out.print("Ingresa la palabra que deseas editar: ");
        String palabraVieja = scanner.nextLine();
        System.out.print("Ingresa la nueva palabra: ");
        String palabraNueva = scanner.nextLine();

        if (palabraNueva.isEmpty()) {
            System.out.println("No se puede dejar en blanco.");
        } else if (!palabraNueva.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            System.out.println("La nueva palabra contiene caracteres no válidos.");
        } else {
            controlador.editarPalabra(palabraVieja, palabraNueva);
        }
    }
}
