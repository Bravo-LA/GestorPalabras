package Main;
import Controllers.ControladorListaPalabras;
import Models.ModeloListaPalabras;
import Views.VistaListaPalabras;

public class GestorDePalabrasApp {
    
    public static void main(String[] args) {
        ModeloListaPalabras modelo = new ModeloListaPalabras();
        ControladorListaPalabras controlador = new ControladorListaPalabras(modelo);
        VistaListaPalabras vista = new VistaListaPalabras(controlador);

        vista.mostrarMenu();
    }
    
}
