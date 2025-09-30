package entities;

public abstract class Pieza {
    protected Color color;
    protected int fila;
    protected int columna;

    public Pieza(Color color, int fila, int columna) {
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }

    public abstract boolean esMovimientoValido(int nuevaFila, int nuevaColumna);
    public abstract double getValor();
    public abstract String toString();

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }
}
