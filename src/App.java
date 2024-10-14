import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodosBusqueda metodosBusqueda = new MetodosBusqueda();

        // Prueba con arreglo pequeño
        int[] arregloPequeno = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("Arreglo pequeño: " + Arrays.toString(arregloPequeno));

        probarBusqueda(metodosBusqueda, arregloPequeno, 50);

        // Prueba con arreglo grande
        System.out.println("\n=== Búsqueda en arreglo de 1 a 100,000 ===");
        int[] arregloGrande = new int[100000];
        for (int i = 0; i < arregloGrande.length; i++) {
            arregloGrande[i] = i + 1;
        }

        int valorBuscado = 50418;
        probarBusquedaConRendimiento(metodosBusqueda, arregloGrande, valorBuscado);

        scanner.close();
    }

    private static void probarBusqueda(MetodosBusqueda metodosBusqueda, int[] arreglo, int valor) {
        int posicionSecuencial = metodosBusqueda.busquedaSecuencial(arreglo, valor);
        imprimirResultado("Secuencial", posicionSecuencial);

        int posicionBinaria = metodosBusqueda.busquedaBinaria(arreglo, valor);
        imprimirResultado("Binaria", posicionBinaria);
    }

    private static void probarBusquedaConRendimiento(MetodosBusqueda metodosBusqueda, int[] arreglo, int valor) {
        long tiempoInicio = System.nanoTime();
        int comparacionesSec = metodosBusqueda.busquedaSecuencialConContador(arreglo, valor);
        long tiempoFin = System.nanoTime();
        imprimirRendimiento("Secuencial", comparacionesSec, tiempoFin - tiempoInicio);

        tiempoInicio = System.nanoTime();
        int comparacionesBin = metodosBusqueda.busquedaBinariaConContador(arreglo, valor);
        tiempoFin = System.nanoTime();
        imprimirRendimiento("Binaria", comparacionesBin, tiempoFin - tiempoInicio);
    }

    private static void imprimirResultado(String tipoBusqueda, int posicion) {
        if (posicion != -1) {
            System.out.printf("Búsqueda %s: Valor encontrado en la posición %d%n", tipoBusqueda, posicion);
        } else {
            System.out.printf("Búsqueda %s: Valor no encontrado (Error 777)%n", tipoBusqueda);
        }
    }

    private static void imprimirRendimiento(String tipoBusqueda, int comparaciones, long tiempo) {
        System.out.printf("Búsqueda %s: Comparaciones = %d, Tiempo = %d ns%n", tipoBusqueda, comparaciones, tiempo);
    }
}
