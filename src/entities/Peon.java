package entities;

public class Peon extends Pieza {
    public Peon(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        if (color == Color.NEGRO) return false;

        int diffFila = nuevaFila - fila;
        int diffCol = Math.abs(nuevaColumna - columna);

        if (diffCol == 0) {
            if (diffFila == 1) return true;
            if (diffFila == 2 && fila == 1) return true;
        }
        return false;
    }

    @Override
    public double getValor() {
        return 1.0;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "P" : "p";
    }
}

