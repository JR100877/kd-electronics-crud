package dao;

import conexion.Conexion;
import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    public void registrar(Producto p) throws Exception {

        String sql = "INSERT INTO productos (codigo_producto, nombreProducto, descripcion, preciobase, precioventa, categoria, cantidaddisponible) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getCodigoProducto());
            ps.setString(2, p.getNombreProducto());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecioBase());
            ps.setDouble(5, p.getPrecioVenta());
            ps.setString(6, p.getCategoria());
            ps.setInt(7, p.getCantidadDisponible());

            ps.executeUpdate();
            System.out.println("Producto registrado correctamente");
        }
    }

    public void listarProductos() {

        String sql = "SELECT * FROM productos";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("---------------");
                System.out.println("Codigo: " + rs.getString("codigo_producto"));
                System.out.println("Nombre: " + rs.getString("nombreProducto"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Precio base: " + rs.getDouble("preciobase"));
                System.out.println("Precio venta: " + rs.getDouble("precioventa"));
                System.out.println("Categoria: " + rs.getString("categoria"));
                System.out.println("Cantidad: " + rs.getInt("cantidaddisponible"));
            }

        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    public void buscarPorCodigo(String codigo) {

        String sql = "SELECT * FROM productos WHERE codigo_producto = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("---------------");
                System.out.println("Codigo: " + rs.getString("codigo_producto"));
                System.out.println("Nombre: " + rs.getString("nombreProducto"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Precio base: " + rs.getDouble("preciobase"));
                System.out.println("Precio venta: " + rs.getDouble("precioventa"));
                System.out.println("Categoria: " + rs.getString("categoria"));
                System.out.println("Cantidad: " + rs.getInt("cantidaddisponible"));
            } else {
                System.out.println("Producto no encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }

    public void actualizar(Producto p) {

        String sql = "UPDATE productos SET nombreProducto=?, descripcion=?, preciobase=?, precioventa=?, categoria=?, cantidaddisponible=? WHERE codigo_producto=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecioBase());
            ps.setDouble(4, p.getPrecioVenta());
            ps.setString(5, p.getCategoria());
            ps.setInt(6, p.getCantidadDisponible());
            ps.setString(7, p.getCodigoProducto());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Producto actualizado correctamente");
            } else {
                System.out.println("Producto no encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(String codigo) {

        String sql = "UPDATE productos SET activo = 0 WHERE codigo_producto = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Producto eliminado correctamente");
            } else {
                System.out.println("Producto no encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}