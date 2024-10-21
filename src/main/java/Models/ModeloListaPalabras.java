package Models;
import java.util.ArrayList;

public class ModeloListaPalabras {
    
  private ArrayList<String> listaDePalabras;

    public ModeloListaPalabras() {
        listaDePalabras = new ArrayList<>();
    }
  
    public void agregarPalabra(String palabra) {
        listaDePalabras.add(palabra);
    }

    public boolean buscarPalabra(String palabra) {
        return listaDePalabras.contains(palabra);
    }

    public boolean eliminarPalabra(String palabra) {
        return listaDePalabras.remove(palabra);
    }

    public boolean editarPalabra(String palabraVieja, String palabraNueva) {
        int indice = listaDePalabras.indexOf(palabraVieja);
        if (indice != -1) {
            listaDePalabras.set(indice, palabraNueva);
            return true;
        }
        return false;
    }

    public boolean listaVacia() {
        return listaDePalabras.isEmpty();
    }

    public ArrayList<String> obtenerListaPalabras() {
        return listaDePalabras;
    }
}
