package edu.mx.uttt.Ejercicios.Operaciones_Vectores_Tarea;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            // Mostrar el menú en una ventana de diálogo
            String menu = "Seleccione una opción:\n"
                    + "1) Generar 30 números aleatorios y realizar operaciones\n"
                    + "2) Clasificación de puntajes de estudiantes\n"
                    + "3) Salir";

            String opcionStr = JOptionPane.showInputDialog(null, menu, "Menú", JOptionPane.QUESTION_MESSAGE);
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    // Generar números aleatorios y mostrar resultados
                    Aleatorio ale = new Aleatorio();
                    String resultados = ale.Resultados(); // Asumimos que `Resultados` retorna un String con los resultados
                    JOptionPane.showMessageDialog(null, resultados, "Resultados", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:
                    // Clasificación de puntajes de estudiantes
                    puntajes pun = new puntajes();
                    String clasificacion = pun.mostrarClasificacion(); // Asumimos que `mostrarClasificacion` retorna un String
                    JOptionPane.showMessageDialog(null, clasificacion, "Clasificación de Puntajes", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
