package principal;

import java.util.Scanner;
import dao.ProductoDAO;
import modelo.Producto;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENU CRUD PRODUCTOS ===");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por codigo");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.println("===========================");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero valido");
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    try {
                        ProductoDAO dao = new ProductoDAO();
                        Producto p = new Producto();

                        System.out.print("Codigo: ");
                        p.setCodigoProducto(sc.nextLine());

                        System.out.print("Nombre: ");
                        p.setNombreProducto(sc.nextLine());

                        System.out.print("Descripcion: ");
                        p.setDescripcion(sc.nextLine());

                        System.out.print("Precio base: ");
                        p.setPrecioBase(Double.parseDouble(sc.nextLine()));

                        System.out.print("Precio venta: ");
                        p.setPrecioVenta(Double.parseDouble(sc.nextLine()));

                        System.out.print("Categoria: ");
                        p.setCategoria(sc.nextLine());

                        System.out.print("Cantidad disponible: ");
                        p.setCantidadDisponible(Integer.parseInt(sc.nextLine()));

                        dao.registrar(p);

                    } catch (Exception e) {
                        System.out.println("Error al registrar producto: " + e.getMessage());
                    }
                    break;

                case 2:
                    ProductoDAO dao2 = new ProductoDAO();
                    dao2.listarProductos();
                    break;

                case 3:
                    ProductoDAO dao3 = new ProductoDAO();
                    System.out.print("Ingrese el codigo del producto: ");
                    String codigoBuscar = sc.nextLine();
                    dao3.buscarPorCodigo(codigoBuscar);
                    break;

                case 4:
                    try {
                        ProductoDAO dao4 = new ProductoDAO();
                        Producto p = new Producto();

                        System.out.print("Codigo del producto a actualizar: ");
                        p.setCodigoProducto(sc.nextLine());

                        System.out.print("Nuevo nombre: ");
                        p.setNombreProducto(sc.nextLine());

                        System.out.print("Nueva descripcion: ");
                        p.setDescripcion(sc.nextLine());

                        System.out.print("Nuevo precio base: ");
                        p.setPrecioBase(Double.parseDouble(sc.nextLine()));

                        System.out.print("Nuevo precio venta: ");
                        p.setPrecioVenta(Double.parseDouble(sc.nextLine()));

                        System.out.print("Nueva categoria: ");
                        p.setCategoria(sc.nextLine());

                        System.out.print("Nueva cantidad: ");
                        p.setCantidadDisponible(Integer.parseInt(sc.nextLine()));

                        dao4.actualizar(p);

                    } catch (Exception e) {
                        System.out.println("Error al actualizar: " + e.getMessage());
                    }
                    break;

                case 5:
                    ProductoDAO dao5 = new ProductoDAO();
                    System.out.print("Ingrese el codigo a eliminar: ");
                    String codigoEliminar = sc.nextLine();
                    dao5.eliminar(codigoEliminar);
                    break;

                case 6:
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6);

        sc.close();
    }
}