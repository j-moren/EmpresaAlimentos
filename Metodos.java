import java.util.Scanner;
import java.util.Stack;

public class Metodos {
    Scanner sc = new Scanner(System.in);
     private Stack<Producto> inventario = new Stack<>();

    // Método para agregar un Producto
    public void ingresarProducto(String referencia, double precio, int cantidad) {
        // Validar si la referencia ya existe
        for (Producto rep : inventario) {
            if (rep.referencia.equals(referencia)) {
                System.out.println("La referencia ya existe, aumentando stock.");
                rep.cantidad += cantidad;
                return;
            }
        }
        // Si no existe, agregarlo a la pila
        Producto nuevo = new Producto(referencia, precio, cantidad);
        inventario.push(nuevo);
        System.out.println("Producto ingresado correctamente.");
    }

    // Método para mostrar el inventario
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto rep : inventario) {
                System.out.println(rep);
            }
        }
    }

    // Método para vender un Producto
    public void venderProducto(String referencia) {
        Stack<Producto> tempStack = new Stack<>();
        boolean encontrado = false;

        while (!inventario.isEmpty()) {
            Producto rep = inventario.pop();
            if (rep.referencia.equals(referencia)) {
                System.out.println("Ingrese la cantidad a vender: ");
                int cant = sc.nextInt();
                if (cant <= rep.cantidad) {
                    rep.cantidad = rep.cantidad - cant;
                }
                    System.out.println("Producto vendido.");
                    encontrado = true;
                    if (rep.cantidad > 0) tempStack.push(rep);
                 else {
                    System.out.println("No hay stock disponible.");
                    tempStack.push(rep);
                }
                break;
            }
            tempStack.push(rep);
        }

        // Restaurar la pila original
        while (!tempStack.isEmpty()) {
            inventario.push(tempStack.pop());
        }

        if (!encontrado) System.out.println("El Producto no está en el inventario.");
    }

    // Método para eliminar un Producto
    public void eliminarProducto(String referencia) {
        Stack<Producto> tempStack = new Stack<>();
        boolean eliminado = false;

        while (!inventario.isEmpty()) {
            Producto rep = inventario.pop();
            if (rep.referencia.equals(referencia)) {
                System.out.println("Producto eliminado.");
                eliminado = true;
                break;
            }
            tempStack.push(rep);
        }

        // Restaurar la pila original
        while (!tempStack.isEmpty()) {
            inventario.push(tempStack.pop());
        }

        if (!eliminado) System.out.println("El Producto no está en inventario.");
    }
}


