public class Producto {
    String referencia;
    double precio;
    int cantidad;

    // Constructor
    public Producto( String referencia, double precio, int cantidad) {
        this.referencia = referencia;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Método para mostrar información del Producto
    public String toString() {
        return ", Ref: " + referencia + ", Precio: $" + precio + ", Stock: " + cantidad;
    }
}

