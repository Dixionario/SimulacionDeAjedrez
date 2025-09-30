package entities;

public class Caballo extends Pieza {
    public Caballo(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        int diffFila = Math.abs(nuevaFila - fila);
        int diffCol = Math.abs(nuevaColumna - columna);
        return (diffFila == 2 && diffCol == 1) || (diffFila == 1 && diffCol == 2);
    }

    @Override
    public double getValor() {
        return 3.0;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "C" : "c";
    }
}
