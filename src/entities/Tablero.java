package entities;

public class Tablero {
    private Pieza[][] casillas = new Pieza[8][8];

    public void colocarPieza(Pieza pieza) {
        if (pieza.fila >= 0 && pieza.fila < 8 && pieza.columna >= 0 && pieza.columna < 8) {
            casillas[pieza.fila][pieza.columna] = pieza;
        }
    }

    public void mostrar() {
        System.out.println("\n  a b c d e f g h");
        for (int fila = 7; fila >= 0; fila--) {
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < 8; col++) {
                System.out.print(casillas[fila][col] == null ? ". " : casillas[fila][col] + " ");
            }
            System.out.println(fila + 1);
        }
        System.out.println("  a b c d e f g h");
    }

    public void moverPieza(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        if (!coordenadaValida(filaOrigen, colOrigen) || !coordenadaValida(filaDestino, colDestino)) {
            System.out.println("Error: Posición fuera del tablero");
            return;
        }

        Pieza pieza = casillas[filaOrigen][colOrigen];
        if (pieza == null) {
            System.out.println("Error: No hay pieza en la posición origen");
            return;
        }

        if (casillas[filaDestino][colDestino] != null) {
            System.out.println("Error: Ya hay una pieza en la posición destino");
            return;
        }

        if (pieza.esMovimientoValido(filaDestino, colDestino)) {
            casillas[filaOrigen][colOrigen] = null;
            casillas[filaDestino][colDestino] = pieza;
            pieza.mover(filaDestino, colDestino);
            System.out.println("Pieza movida correctamente");
        } else {
            System.out.println("Movimiento inválido para esta pieza");
        }
    }

    private boolean coordenadaValida(int fila, int col) {
        return fila >= 0 && fila < 8 && col >= 0 && col < 8;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if (casillas[fila][col] != null) {
                    total += casillas[fila][col].getValor();
                }
            }
        }
        return total;
    }
}
