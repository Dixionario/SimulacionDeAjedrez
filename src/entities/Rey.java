package entities;

public class Rey extends Pieza {
    public Rey(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        int diffFila = Math.abs(nuevaFila - fila);
        int diffCol = Math.abs(nuevaColumna - columna);
        return (diffFila <= 1 && diffCol <= 1);
    }

    @Override
    public double getValor() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "R" : "r";
    }
}
