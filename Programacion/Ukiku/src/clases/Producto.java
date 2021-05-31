package clases;

import java.sql.Connection;
import java.sql.SQLException;

import conectarBd.Conexion;

public class Producto extends Ukiku {

	/**
	 * Atributos
	 */
	public String nombre;
	
	public String categor�a;
	public double precio;
	public int stock;
	public String cif_Proveedor;
	public String dni_cliente;

	/**
	 * constructores
	 */
	public Producto() {
	}

	public Producto(String nombre, String categor�a, double precio, int stock) {

		super();
		this.nombre = nombre;
		this.categor�a = categor�a;
		this.precio = precio;
		this.stock = stock;

	}
	
	/**
	 * Getters y Setters
	 */

	
	/**
	 * @return
	 */
	@Override
	public String getNombre() {
		
		return nombre;
		
	}

	/**
	 *@param nombre
	 */
	@Override
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}


	
	/**
	 * @return
	 */
	public String getCategoria() {
		
		return categor�a;
		
	}

	/**
	 * @param categor�a
	 */
	public void setCategoria(String categor�a) {
		
		this.categor�a = categor�a;
		
	}

	/**
	 * @return
	 */
	public double getPrecio() {
		
		return precio;
		
	}

	/**
	 * @param precio
	 */
	public void setPrecio(double precio) {
		
		this.precio = precio;
		
	}

	/**
	 * @return
	 */
	public int getStock() {
		
		return stock;
		
	}

	/**
	 * @param stock
	 */
	public void setStock(int stock) {
		
		this.stock = stock;
		
	}
	
	/**
	 * @param nombre
	 * @param codigo
	 * @param categor�a
	 * @param precio
	 * @param stock
	 * @param cifProveedor
	 * @param dniCliente
	 */
	public void modificar(String nombre,  String categor�a, double precio, int stock, String cif_Proveedor,
			String dni_cliente) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * @param nombre
	 * @param codigo
	 * @param categor�a
	 * @param precio
	 * @param stock
	 * @param cifProveedor
	 * @param dniCliente
	 */
	public void borrar(String nombre, String categor�a, double precio, int stock, String cif_Proveedor,
			String dni_cliente) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * @param nombre
	 * @param codigo
	 * @param categoria
	 * @param precio
	 * @param stock
	 * @param cifProveedor
	 * @param dniCliente
	 */
	public static void insertar(String nombre, String categor�a, double precio, int stock) {
		Conexion cn = new Conexion();
		Connection miConexion = cn.getConexion();

		try {
			cn.s = miConexion.createStatement();
			cn.rs = cn.s.executeUpdate("INSERT INTO producto (Nombre, categor�a, precio, stock, cif_Proveedor) VALUES ('"
					+ nombre + "', '" + categor�a + "', '" + precio + "', '" + stock + "',)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
