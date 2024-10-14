class MetodosBusqueda {
    public int busquedaSecuencial(int[] arreglo, int valorBuscado) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valorBuscado) {
                return i;
            }
        }
        return -1;
    }

    public int busquedaBinaria(int[] arreglo, int valorBuscado) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == valorBuscado) {
                return medio;
            }
            if (arreglo[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public int busquedaSecuencialConContador(int[] arreglo, int valorBuscado) {
        int comparaciones = 0;
        for (int valor : arreglo) {
            comparaciones++;
            if (valor == valorBuscado) {
                return comparaciones;
            }
        }
        return comparaciones;
    }

    public int busquedaBinariaConContador(int[] arreglo, int valorBuscado) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        int comparaciones = 0;

        while (inicio <= fin) {
            comparaciones++;
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == valorBuscado) {
                return comparaciones;
            }
            if (arreglo[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return comparaciones;
    }
}