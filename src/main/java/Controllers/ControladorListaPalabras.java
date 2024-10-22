package Controllers;

import Models.ModeloListaPalabras;

public class ControladorListaPalabras {
    
    private ModeloListaPalabras modelo;

    public ControladorListaPalabras(ModeloListaPalabras modelo) {
        this.modelo = modelo;
    }
    
    public void agregarPalabra(String palabra) {
        modelo.agregarPalabra(palabra);
        System.out.println("Palabra agregada: " + palabra);
    }

    public void buscarPalabra(String palabra) {
        // Requisito CP_BUSCAR_003: Manejar lista vacía
        if (modelo.listaVacia()) {
            System.out.println("La lista está vacía.");
        }
        // Requisito CP_BUSCAR_004: Manejar caracteres especiales
        else if (!palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            System.out.println("La palabra contiene caracteres especiales no válidos."); // CP_BUSCAR_004
        }
        // Requisito CP_BUSCAR_001 y CP_BUSCAR_002: Buscar palabra existente o no
        else if (modelo.buscarPalabra(palabra)) {
            System.out.println("La palabra \"" + palabra + "\" existe en la lista.");  // CP_BUSCAR_001
        } else {
            System.out.println("La palabra \"" + palabra + "\" no se encuentra en la lista.");  // CP_BUSCAR_002
        }
    }
    
    public void eliminarPalabra(String palabra) {
        if (modelo.listaVacia()){
            System.out.println("La lista de palabras está vacía.");
        }
        else if (modelo.eliminarPalabra(palabra)) {
            System.out.println("Palabra eliminada: " + palabra);
        } else {
            System.out.println("La palabra \"" + palabra + "\" no se encontró en la lista.");
        }
    }
    
    public void editarPalabra(String palabraVieja, String palabraNueva) {
        if (modelo.editarPalabra(palabraVieja, palabraNueva)) {
            System.out.println("La palabra \"" + palabraVieja + "\" ha sido actualizada a \"" + palabraNueva + "\".");
        } else {
            System.out.println("La palabra \"" + palabraVieja + "\" no se encontró en la lista.");
        }
    }

    public boolean listaVacia() {
        return modelo.listaVacia();
    }
}
