package entities;

public class Alfil extends Pieza {
    public Alfil(Color color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna) {
        int deltaFila   = Math.abs(nuevaFila   - this.fila);
        int deltaCol    = Math.abs(nuevaColumna - this.columna);
        if (deltaFila != deltaCol) {
            return false;
        }
        return true;
    }

    @Override
    public double getValor() {
        return 3.0;
    }

    @Override
    public String toString() {
        return (color == Color.BLANCO) ? "A" : "a";
    }
}
