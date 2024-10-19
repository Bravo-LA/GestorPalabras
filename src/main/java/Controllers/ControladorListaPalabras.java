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
        if (modelo.buscarPalabra(palabra)) {
            System.out.println("La palabra \"" + palabra + "\" existe en la lista.");
        } else {
            System.out.println("La palabra \"" + palabra + "\" no se encuentra en la lista.");
        }
    }
    
    public void eliminarPalabra(String palabra) {
        if (modelo.eliminarPalabra(palabra)) {
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
}
