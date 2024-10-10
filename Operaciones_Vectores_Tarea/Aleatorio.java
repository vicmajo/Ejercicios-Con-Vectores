package edu.mx.uttt.Ejercicios.Operaciones_Vectores_Tarea;

import javax.swing.*;
import java.util.*;

public class Aleatorio {

    private final Vector<Integer> numeros;

    // Constructor con el vector de números aleatorios
    public Aleatorio(){
        this.numeros = new Vector<>();
        generarNumeros();
    }

    // Generar números aleatorios entre el 1 y el 30
    public void generarNumeros(){
        Random ram = new Random(); // Objeto random para generar números
        for (int i = 0; i < 30; i++) { // Método que genera 30 números
            numeros.add(ram.nextInt(30) + 1); // Se añaden al vector
        }
    }

    // Ordenar el Vector de números
    public Vector<Integer> OrdenNum(){
        Vector<Integer> numOrdenados = new Vector<>(numeros); // Copia del vector original
        Collections.sort(numOrdenados); // Ordenamos
        return numOrdenados; // Devolvemos
    }

    // Obtener el número más alto
    public int NumAlto(){
        return Collections.max(numeros);
    }

    // Número más bajo
    public int NumBajo(){
        return Collections.min(numeros);
    }

    // Calcular media
    public double Media(){
        double suma = 0;
        for (int numero : numeros){
            suma += numero; // Suma de valores de cada número
        }
        return suma / numeros.size(); // Suma dividida por la cantidad
    }

    // Calcular moda
    public int Moda(){
        Map<Integer, Integer> frecuencias = new HashMap<>(); // HashMap que almacena frecuencias
        for (int numero : numeros){
            frecuencias.put(numero, frecuencias.getOrDefault(numero, 0) + 1);
        }
        int moda = numeros.get(0);
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()){
            if (entry.getValue() > maxFrecuencia){
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }
        return moda;
    }

    // Calcular mediana
    public int Mediana(){
        Vector<Integer> numOrden = OrdenNum();
        int medio = numOrden.size() / 2; // Calcula el valor medio
        if (numOrden.size() % 2 == 0) { // Si es par, calculamos el promedio de dos números del medio
            return (numOrden.get(medio - 1) + numOrden.get(medio)) / 2;
        } else {
            return numOrden.get(medio); // Si es impar, el valor del medio es el valor central
        }
    }

    // Conteo y porcentaje de números entre 1 y 10
    public Map<Integer, Double> ConteoYPorcentaje(){
        Map<Integer, Integer> conteoNum = new HashMap<>(); // Cuenta cuántas veces aparece cada número del 1 al 10
        Map<Integer, Double> porcentajeNum = new HashMap<>(); // Almacena los porcentajes

        for (int i = 1; i <= 10; i++) { // Conteo de números 1 al 10
            conteoNum.put(i, 0);
        }
        for (int numero : numeros) { // Recorremos el vector
            if (numero >= 1 && numero <= 10) {
                conteoNum.put(numero, conteoNum.getOrDefault(numero, 0) + 1); // Actualiza
            }
        }
        for (Map.Entry<Integer, Integer> entry : conteoNum.entrySet()) { // Calcular porcentajes
            porcentajeNum.put(entry.getKey(), (entry.getValue() / (double) numeros.size()) * 100);
        }
        return porcentajeNum;
    }

    // Mostrar resultados en un String (para que sea más fácil de mostrar en la ventana de diálogo)
    public String Resultados(){
        StringBuilder sb = new StringBuilder();

        sb.append("Vector Principal: ").append(numeros).append("\n");
        sb.append("Vector Ordenado: ").append(OrdenNum()).append("\n");
        sb.append("Número más Alto: ").append(NumAlto()).append("\n");
        sb.append("Número más Bajo: ").append(NumBajo()).append("\n");
        sb.append("Media: ").append(Media()).append("\n");
        sb.append("Moda: ").append(Moda()).append("\n");
        sb.append("Mediana: ").append(Mediana()).append("\n");

        // Mostrar conteo y porcentaje de números entre 1 y 10
        Map<Integer, Double> porcentajes = ConteoYPorcentaje();
        for (int i = 1; i <= 10; i++) {
            sb.append("Cantidad de " + i + ": " + porcentajes.get(i) + "%\n");
        }

        return sb.toString();
    }

}
