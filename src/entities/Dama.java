package entities;

public class Dama extends Pieza {
    public Dama(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        boolean movimientoRecto = (fila == nuevaFila) || (columna == nuevaColumna);
        boolean movimientoDiagonal = Math.abs(nuevaFila - fila) == Math.abs(nuevaColumna - columna);
        return movimientoRecto || movimientoDiagonal;
    }

    @Override
    public double getValor() {
        return 9.0;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "D" : "d";
    }
}
