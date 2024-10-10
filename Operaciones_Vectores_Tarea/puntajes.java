package edu.mx.uttt.Ejercicios.Operaciones_Vectores_Tarea;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Random;

public class puntajes {
    private int[] puntajes;
    private int numEstudiantes;

    public puntajes() {
        // Mostrar ventana de entrada para ingresar la cantidad de estudiantes
        String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad de estudiantes:", "Cantidad de Estudiantes", JOptionPane.QUESTION_MESSAGE);

        // Validar que la entrada no sea null y convertirla a un número entero
        try {
            numEstudiantes = Integer.parseInt(input);
            if (numEstudiantes <= 0) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir si el número no es válido
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Inicializar el arreglo de puntajes
        puntajes = new int[numEstudiantes];
        Random random = new Random();

        // Generar puntajes aleatorios entre 0 y 20
        for (int i = 0; i < numEstudiantes; i++) {
            puntajes[i] = random.nextInt(21);  // Puntajes entre 0 y 20
        }
    }

    public String mostrarClasificacion() {
        int deficientes = 0, regulares = 0, buenos = 0, excelentes = 0;

        for (int puntaje : puntajes) {
            if (puntaje >= 0 && puntaje <= 5) {
                deficientes++;
            } else if (puntaje >= 6 && puntaje <= 10) {
                regulares++;
            } else if (puntaje >= 11 && puntaje <= 15) {
                buenos++;
            } else if (puntaje >= 16 && puntaje <= 20) {
                excelentes++;
            }
        }

        // Construir el resultado como un String para mostrarlo en la ventana de diálogo
        StringBuilder sb = new StringBuilder();
        sb.append("Puntajes generados: ").append(Arrays.toString(puntajes)).append("\n");
        sb.append("0-5 Deficientes: ").append(deficientes).append("\n");
        sb.append("6-10 Regulares: ").append(regulares).append("\n");
        sb.append("11-15 Buenos: ").append(buenos).append("\n");
        sb.append("16-20 Excelentes: ").append(excelentes).append("\n");

        return sb.toString();  // Retornamos el resultado como un String
    }
}
