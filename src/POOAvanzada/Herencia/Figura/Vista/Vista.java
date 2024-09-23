package POOAvanzada.Herencia.Figura.Vista;

import POOAvanzada.Herencia.Figura.SuperClase.SubClases.Circulo;
import POOAvanzada.Herencia.Figura.SuperClase.SubClases.Cuadrado;
import POOAvanzada.Herencia.Figura.SuperClase.SubClases.Rectangulo;
import POOAvanzada.Herencia.Figura.SuperClase.SubClases.TrianguloEquilatero;

public class Vista {

    private Circulo circulo;
    private Cuadrado cuadrado;
    private Rectangulo rectangulo;
    private TrianguloEquilatero trianguloEquilatero;

    public void comenzar() {
        int opcionElegida;
        do {
            Consola.mostrarMenu();
            opcionElegida = Consola.leerOpcion();
            ejecutar(opcionElegida);
        } while (opcionElegida != 0);
    }

    private void ejecutar(int opcion) {
        switch (opcion) {
            case 0 -> salir();
            case 11 -> crearCirculo();
            case 12 -> obtenerPerimetroCirculo();
            case 13 -> obtenerAreaCirculo();
            case 14 -> desplazarCirculoDireccion();
            case 15 -> desplazarCirculoIncrementadoXeY();
            case 21 -> crearRectangulo();
            case 22 -> obtenerPerimetroRectangulo();
            case 23 -> obtenerAreaRectangulo();
            case 24 -> desplazarRectanguloDireccion();
            case 25 -> desplazarRectanguloIncrementadoXeY();
            case 31 -> crearTrianguloEquilatero();
            case 32 -> obtenerPerimetroTrianguloEquilatero();
            case 33 -> obtenerAreaTrianguloEquilatero();
            case 34 -> desplazarTrianguloEquilateroDireccion();
            case 35 -> desplazarTrianguloEquilateroIncrementadoXeY();
            case 41 -> crearCuadrado();
            case 42 -> obtenerPerimetroCuadrado();
            case 43 -> obtenerAreaCuadrado();
            case 44 -> desplazarCuadradoDireccion();
            case 45 -> desplazarCuadradoIncrementadoXeY();
        }
    }

    private void crearCirculo() {
        Consola.cabezera("CREACIÓN CIRCULO ACTIVADA");
        if (circulo != null) {
            System.out.println("Ya ha creado un círculo anteriormente, este no puede ser reemplazado. Para ingresar otro, reinicie la aplicación.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    circulo = new Circulo(Consola.leerPunto("Por favor, ingrese las coordenadas del centro del círculo."), Consola.leerColor("Seleccione un color para el círculo."), Consola.leerEntero("Escriba la longitud del radio del círculo en unidades de medida: "));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
        }
        System.out.println(circulo);
    }

    private void obtenerPerimetroCirculo() {
        Consola.cabezera("CALCULANDO PERIMETRO CIRCULO ACTIVADA");
        if (circulo == null) {
            System.out.println("Debes crear un círculo antes de calcular el perímetro. Por favor, crea un círculo y vuelve a intentarlo.");
        } else {
            System.out.printf("El perímetro del círculo que has creado es de %2.2f unidades.%n", circulo.getPerimetro());
        }
    }

    private void obtenerAreaCirculo() {
        Consola.cabezera("CALCULANDO AREA CIRCULO ACTIVADA");
        if (circulo == null) {
            System.out.println("Debes crear un círculo antes de calcular el área. Por favor, crea un círculo y vuelve a intentarlo.");
        } else {
            System.out.printf("El área del círculo que has creado es de %2.2f unidades².%n", circulo.getArea());
        }
    }

    private void desplazarCirculoDireccion() {
        Consola.cabezera("DESPLAZAR CIRCULO EN DIRECCIÓN ACTIVADA");
        if (circulo == null) {
            System.out.println("Debes crear un círculo antes de intentar desplazarlo. Por favor, crea un círculo y vuelve a intentarlo.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    circulo.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades que deseas desplazar el círculo: "), Consola.leerDireccion("Selecciona una dirección para desplazar el círculo."));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
            System.out.println(circulo);
        }
    }

    private void desplazarCirculoIncrementadoXeY() {
        Consola.cabezera("DESPLAZAR CIRCULO INCREMENTADO X e Y ACTIVADA");
        if (circulo == null) {
            System.out.println("Debes crear un círculo antes de intentar desplazarlo. Por favor, crea un círculo y vuelve a intentarlo.");
        } else {
            circulo.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje X que deseas desplazar el círculo: "), Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje Y que deseas desplazar el círculo: "));
            System.out.println(circulo);
        }
    }

    private void crearRectangulo() {
        Consola.cabezera("CREACIÓN RECTÁNGULO ACTIVADA");
        if (rectangulo != null) {
            System.out.println("Ya ha creado un rectángulo anteriormente, este no puede ser reemplazado. Para ingresar otro, reinicie la aplicación.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    rectangulo = new Rectangulo(Consola.leerColor("Seleccione un color para el rectángulo."), Consola.leerPunto("Por favor, ingrese las coordenadas del vértice inferior izquierdo del rectángulo."), Consola.leerEntero("Escriba la longitud del lado X del rectángulo en unidades de medida: "), Consola.leerEntero("Escriba la longitud del lado Y del rectángulo en unidades de medida: "));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
        }
        System.out.println(rectangulo);
    }

    private void obtenerPerimetroRectangulo() {
        Consola.cabezera("CALCULANDO PERIMETRO RECTÁNGULO ACTIVADA");
        if (rectangulo == null) {
            System.out.println("Debes crear un rectángulo antes de calcular el perímetro. Por favor, crea un rectángulo y vuelve a intentarlo.");
        } else {
            System.out.printf("El perímetro del rectángulo que has creado es de %2.2f unidades.%n", rectangulo.getPerimetro());
        }
    }

    private void obtenerAreaRectangulo() {
        Consola.cabezera("CALCULANDO AREA RECTÁNGULO ACTIVADA");
        if (rectangulo == null) {
            System.out.println("Debes crear un rectángulo antes de calcular el área. Por favor, crea un rectángulo y vuelve a intentarlo.");
        } else {
            System.out.printf("El área del rectángulo que has creado es de %2.2f unidades².%n", rectangulo.getArea());
        }
    }

    private void desplazarRectanguloDireccion() {
        Consola.cabezera("DESPLAZAR RECTÁNGULO EN DIRECCIÓN ACTIVADA");
        if (rectangulo == null) {
            System.out.println("Debes crear un rectángulo antes de intentar desplazarlo. Por favor, crea un rectángulo y vuelve a intentarlo.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    rectangulo.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades que deseas desplazar el rectángulo: "), Consola.leerDireccion("Selecciona una dirección para desplazar el rectángulo."));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
            System.out.println(rectangulo);
        }
    }

    private void desplazarRectanguloIncrementadoXeY() {
        Consola.cabezera("DESPLAZAR RECTÁNGULO INCREMENTADO X e Y ACTIVADA");
        if (rectangulo == null) {
            System.out.println("Debes crear un rectángulo antes de intentar desplazarlo. Por favor, crea un rectángulo y vuelve a intentarlo.");
        } else {
            rectangulo.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje X que deseas desplazar el rectángulo: "), Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje Y que deseas desplazar el rectángulo: "));
            System.out.println(rectangulo);
        }
    }

    private void crearCuadrado() {
        Consola.cabezera("CREACIÓN CUADRADO ACTIVADA");
        if (cuadrado != null) {
            System.out.println("Ya ha creado un cuadrado anteriormente, este no puede ser reemplazado. Para ingresar otro, reinicie la aplicación.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    cuadrado = new Cuadrado(Consola.leerColor("Seleccione un color para el cuadrado."), Consola.leerPunto("Por favor, ingrese las coordenadas del vértice inferior izquierdo del cuadrado."), Consola.leerEntero("Escriba la longitud de un lado del cuadrado en unidades de medida: "));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
        }
        System.out.println(cuadrado);
    }

    private void obtenerPerimetroCuadrado() {
        Consola.cabezera("CALCULANDO PERIMETRO CUADRADO ACTIVADA");
        if (cuadrado == null) {
            System.out.println("Debes crear un cuadrado antes de calcular el perímetro. Por favor, crea un cuadrado y vuelve a intentarlo.");
        } else {
            System.out.printf("El perímetro del cuadrado que has creado es de %2.2f unidades.%n", cuadrado.getPerimetro());
        }
    }

    private void obtenerAreaCuadrado() {
        Consola.cabezera("CALCULANDO AREA CUADRADO ACTIVADA");
        if (cuadrado == null) {
            System.out.println("Debes crear un cuadrado antes de calcular el área. Por favor, crea un cuadrado y vuelve a intentarlo.");
        } else {
            System.out.printf("El área del cuadrado que has creado es de %2.2f unidades².%n", cuadrado.getArea());
        }
    }

    private void desplazarCuadradoDireccion() {
        Consola.cabezera("DESPLAZAR CUADRADO EN DIRECCIÓN ACTIVADA");
        if (cuadrado == null) {
            System.out.println("Debes crear un cuadrado antes de intentar desplazarlo. Por favor, crea un cuadrado y vuelve a intentarlo.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    cuadrado.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades que deseas desplazar el cuadrado: "), Consola.leerDireccion("Selecciona una dirección para desplazar el cuadrado."));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
            System.out.println(cuadrado);
        }
    }

    private void desplazarCuadradoIncrementadoXeY() {
        Consola.cabezera("DESPLAZAR CUADRADO INCREMENTADO X e Y ACTIVADA");
        if (cuadrado == null) {
            System.out.println("Debes crear un cuadrado antes de intentar desplazarlo. Por favor, crea un cuadrado y vuelve a intentarlo.");
        } else {
            cuadrado.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje X que deseas desplazar el cuadrado: "), Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje Y que deseas desplazar el cuadrado: "));
            System.out.println(cuadrado);
        }
    }

    private void crearTrianguloEquilatero() {
        Consola.cabezera("CREACIÓN TRIANGULO EQUILÁTERO ACTIVADA");
        if (trianguloEquilatero != null) {
            System.out.println("Ya ha creado un triangulo equilátero anteriormente, este no puede ser reemplazado. Para ingresar otro, reinicie la aplicación.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    trianguloEquilatero = new TrianguloEquilatero(Consola.leerColor("Seleccione un color para el triangulo equilátero."), Consola.leerPunto("Por favor, ingrese las coordenadas del vértice inferior izquierdo del triangulo equilátero."), Consola.leerEntero("Escriba la longitud de un lado del triangulo equilátero en unidades de medida: "));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
        }
        System.out.println(trianguloEquilatero);
    }

    private void obtenerPerimetroTrianguloEquilatero() {
        Consola.cabezera("CALCULANDO PERIMETRO TRIANGULO EQUILÁTERO ACTIVADA");
        if (trianguloEquilatero == null) {
            System.out.println("Debes crear un triangulo equilátero antes de calcular el perímetro. Por favor, crea un triangulo equilátero y vuelve a intentarlo.");
        } else {
            System.out.printf("El perímetro del triangulo equilátero que has creado es de %2.2f unidades.%n", trianguloEquilatero.getPerimetro());
        }
    }

    private void obtenerAreaTrianguloEquilatero() {
        Consola.cabezera("CALCULANDO AREA TRIANGULO EQUILÁTERO ACTIVADA");
        if (trianguloEquilatero == null) {
            System.out.println("Debes crear un triangulo equilátero antes de calcular el área. Por favor, crea un triangulo equilátero y vuelve a intentarlo.");
        } else {
            System.out.printf("El área del triangulo equilátero que has creado es de %2.2f unidades².%n", trianguloEquilatero.getArea());
        }
    }

    private void desplazarTrianguloEquilateroDireccion() {
        Consola.cabezera("DESPLAZAR TRIANGULO EQUILÁTERO EN DIRECCIÓN ACTIVADA");
        if (trianguloEquilatero == null) {
            System.out.println("Debes crear un triangulo equilátero antes de intentar desplazarlo. Por favor, crea un triangulo equilátero y vuelve a intentarlo.");
        } else {
            boolean saltaExcepcion = true;
            while (saltaExcepcion) {
                try {
                    trianguloEquilatero.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades que deseas desplazar el triangulo equilátero: "), Consola.leerDireccion("Selecciona una dirección para desplazar el triangulo equilátero."));
                    saltaExcepcion = false;
                } catch (IllegalArgumentException e) {
                    Consola.cabezera(String.format("ERROR: %s Inténtelo de nuevo.", e.getMessage()));
                }
            }
            System.out.println(trianguloEquilatero);
        }
    }

    private void desplazarTrianguloEquilateroIncrementadoXeY() {
        Consola.cabezera("DESPLAZAR TRIANGULO EQUILÁTERO INCREMENTADO X e Y ACTIVADA");
        if (trianguloEquilatero == null) {
            System.out.println("Debes crear un triangulo equilátero antes de intentar desplazarlo. Por favor, crea un triangulo equilátero y vuelve a intentarlo.");
        } else {
            trianguloEquilatero.desplazar(Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje X que deseas desplazar el triangulo equilátero: "), Consola.leerEntero("Por favor, ingresa la cantidad de unidades en el eje Y que deseas desplazar el triangulo equilátero: "));
            System.out.println(trianguloEquilatero);
        }
    }

    private void salir() {
        Consola.cabezera("Gracias por usar nuestra aplicación de figuras geométricas. Esperamos que hayas disfrutado calculando áreas, perímetros y desplazamientos. ¡Hasta la próxima!");
    }
}
