import entities.*;
import java.util.Scanner;

public class Ajedrez {
    private static Tablero tablero = new Tablero();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> mostrarTablero();
                case 2 -> limpiarTablero();
                case 3 -> agregarPieza();
                case 4 -> moverPieza();
                case 5 -> mostrarValorTotal();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ AJEDREZ ---");
        System.out.println("1. Mostrar tablero");
        System.out.println("2. Limpiar tablero");
        System.out.println("3. Agregar pieza");
        System.out.println("4. Mover pieza");
        System.out.println("5. Mostrar valor total");
        System.out.println("6. Salir");
        System.out.print("Seleccione opción: ");
    }

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
    }

    private static void mostrarTablero() {
        tablero.mostrar();
    }

    private static void limpiarTablero() {
        tablero = new Tablero();
        System.out.println("Tablero limpiado correctamente");
    }

    private static void agregarPieza() {
        System.out.print("Tipo de pieza (PEON, CABALLO, ALFIL, TORRE, DAMA, REY): ");
        String tipo = scanner.nextLine().toUpperCase();

        System.out.print("Color (BLANCO/NEGRO): ");
        String colorStr = scanner.nextLine().toUpperCase();
        Color color = Color.valueOf(colorStr);

        System.out.print("Posición (ej. a4): ");
        String posicion = scanner.nextLine().toLowerCase();

        if (posicion.length() != 2 || !Character.isLetter(posicion.charAt(0)) || !Character.isDigit(posicion.charAt(1))) {
            System.out.println("Posición inválida");
            return;
        }

        int columna = posicion.charAt(0) - 'a';
        int fila = posicion.charAt(1) - '1';

        Pieza pieza = null;
        switch (tipo) {
            case "PEON" -> pieza = new Peon(color, fila, columna);
            case "CABALLO" -> pieza = new Caballo(color, fila, columna);
            case "ALFIL" -> pieza = new Alfil(color, fila, columna);
            case "TORRE" -> pieza = new Torre(color, fila, columna);
            case "DAMA" -> pieza = new Dama(color, fila, columna);
            case "REY" -> pieza = new Rey(color, fila, columna);
        }

        if (pieza != null) {
            tablero.colocarPieza(pieza);
            System.out.println("Pieza agregada correctamente");
        } else {
            System.out.println("Tipo de pieza inválido");
        }
    }

    private static void moverPieza() {
        System.out.print("Posición origen (ej. a2): ");
        String origen = scanner.nextLine().toLowerCase();
        System.out.print("Posición destino (ej. a4): ");
        String destino = scanner.nextLine().toLowerCase();

        if (origen.length() != 2 || destino.length() != 2) {
            System.out.println("Posición inválida");
            return;
        }

        int filaOrigen = origen.charAt(1) - '1';
        int colOrigen = origen.charAt(0) - 'a';
        int filaDestino = destino.charAt(1) - '1';
        int colDestino = destino.charAt(0) - 'a';

        tablero.moverPieza(filaOrigen, colOrigen, filaDestino, colDestino);
    }

    private static void mostrarValorTotal() {
        System.out.println("Valor total de piezas: " + tablero.calcularValorTotal());
    }
}
