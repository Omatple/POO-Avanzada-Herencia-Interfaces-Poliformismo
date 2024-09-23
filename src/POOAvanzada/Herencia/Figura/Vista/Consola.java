package POOAvanzada.Herencia.Figura.Vista;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Enumerados.Direccion;
import POOAvanzada.Herencia.Figura.Coordenadas.Punto;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){}
    public static void cabezera(String mensaje) {
        StringBuilder cabezera = new StringBuilder();
        String guion = "═";
        cabezera.append(guion.repeat(mensaje.length()));
        cabezera.append(String.format("%n%s%n", mensaje));
        cabezera.append(guion.repeat(mensaje.length()));
        System.out.println(cabezera);
    }

    public static void mostrarMenu() {
        cabezera("Aplicación de Figuras Geométricas: Calculadora de Área y Perímetro con Funcionalidad de Desplazamiento");
        System.out.println("Menú de opciones disponibles: ");
        System.out.println("══════════════════════════════");
        System.out.println("[11] Crear un circulo.");
        System.out.println("[12] Obtener perimetro del circulo.");
        System.out.println("[13] Obtener area del circulo.");
        System.out.println("[14] Desplazar circulo en una dirección.");
        System.out.println("[15] Desplazar circulo incrementando su X e Y.");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("[21] Crear un rectángulo.");
        System.out.println("[22] Obtener perimetro del rectángulo.");
        System.out.println("[23] Obtener area del rectángulo.");
        System.out.println("[24] Desplazar rectángulo en una dirección.");
        System.out.println("[25] Desplazar rectángulo incrementando su X e Y.");
        System.out.println("═════════════════════════════════════════════════");
        System.out.println("[31] Crear un triangulo equilátero.");
        System.out.println("[32] Obtener perimetro del triangulo equilátero.");
        System.out.println("[33] Obtener area del triangulo equilátero.");
        System.out.println("[34] Desplazar triangulo equilátero en una dirección.");
        System.out.println("[35] Desplazar triangulo equilátero incrementando su X e Y.");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("[41] Crear un cuadrado.");
        System.out.println("[42] Obtener perimetro del cuadrado.");
        System.out.println("[43] Obtener area del cuadrado.");
        System.out.println("[44] Desplazar cuadrado en una dirección.");
        System.out.println("[45] Desplazar cuadrado incrementando su X e Y.");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("[0] Salir de la aplicación.");
    }

    public static int leerOpcion() {
        int opcion = leerEntero("\nEscriba el número de la opción que desee elegir: ");
        while (!((opcion > 10 && opcion < 16) || (opcion > 20 && opcion < 26) || (opcion > 30 && opcion < 36) || (opcion > 40 && opcion < 46) || (opcion == 0))) {
            System.out.println("ERROR: Numero de opción invalido, intentelo de nuevo.");
            mostrarMenu();
            opcion = leerEntero("\nEscriba el número de la opción que desee elegir: ");
        }
        return opcion;
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Entrada.entero();
    }

    public static Punto leerPunto(String mensaje) {
        System.out.println(mensaje);
        System.out.print("Escriba la coordenada X: ");
        int x = Entrada.entero();
        System.out.print("Escriba la coordenada Y: ");
        int y = Entrada.entero();
        return new Punto(x, y);
    }

    public static Color leerColor(String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < Color.values().length; i++) {
            System.out.printf("[%s] %s.%n", (i + 1), Color.values()[i].toString());
        }
        System.out.print("Escriba el numero del color que desee: ");
        int numero = Entrada.entero();
        while (numero > Color.values().length || numero <= 0) {
            System.out.println("ERROR: Numero invalido, intentelo de nuevo.");
            for (int i = 0; i < Color.values().length; i++) {
                System.out.printf("[%s] %s.%n", (i + 1), Color.values()[i].toString());
            }
            System.out.print("Escriba el numero del color que desee: ");
            numero = Entrada.entero();
        }
        return Color.values()[numero - 1];
    }

    public static Direccion leerDireccion(String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < Direccion.values().length; i++) {
            System.out.printf("[%s] %s.%n", (i + 1), Direccion.values()[i].toString());
        }
        System.out.print("Escriba el numero de la dirección que desee: ");
        int numero = Entrada.entero();
        while (numero > Direccion.values().length || numero <= 0) {
            System.out.println("ERROR: Numero invalido, intentelo de nuevo.");
            for (int i = 0; i < Direccion.values().length; i++) {
                System.out.printf("[%s] %s.%n", (i + 1), Direccion.values()[i].toString());
            }
            System.out.print("Escriba el numero del dirección que desee: ");
            numero = Entrada.entero();
        }
        return Direccion.values()[numero - 1];
    }
}
