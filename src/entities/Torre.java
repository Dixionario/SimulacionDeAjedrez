package entities;

public class Torre extends Pieza {
    public Torre(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        return (fila == nuevaFila) || (columna == nuevaColumna);
    }

    @Override
    public double getValor() {
        return 5.0;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "T" : "t";
    }
}
