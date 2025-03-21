
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Almacén de Alimentos ---");
            System.out.println("1. Ingresar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Vender Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Referencia: ");
                    String referencia = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    metodos.ingresarProducto(referencia, precio, cantidad);
                    break;
                case 2:
                    metodos.mostrarInventario();
                    break;
                case 3:
                    System.out.print("Ingrese la referencia del Producto a vender: ");
                    referencia = scanner.nextLine();
                    metodos.venderProducto(referencia);
                    break;
                case 4:
                    System.out.print("Ingrese la referencia del Producto a eliminar: ");
                    referencia = scanner.nextLine();
                    metodos.eliminarProducto(referencia);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
 

