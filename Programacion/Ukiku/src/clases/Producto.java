package clases;

import java.sql.Connection;
import java.sql.SQLException;

import conectarBd.Conexion;
/**
 * 
 * @author Rene, Ximo, Vicent
 *
 */
public class Producto {

	/**
	 * Atributos
	 */
	public String nombre;
	public int codigo;
	public String categor�a;
	public double precio;
	public int stock;
	public String cif_Proveedor;

	/**
	 * Constructores
	 */
	public Producto() {
	}

	public Producto(String nombre, String categor�a, double precio, int stock, String cif_Proveedor) {

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
	 * @return Devuelve el nombre
	 */
	public String getNombre() {

		return nombre;

	}

	/**
	 * @param nombre Es el nombre del producto.
	 */
	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	/**
	 * @return Devuelve la categoria
	 */
	public String getCategoria() {

		return categor�a;

	}

	/**
	 * @param categor�a Es la categoria del producto
	 */
	public void setCategoria(String categor�a) {

		this.categor�a = categor�a;

	}

	/**
	 * @return Devuelve el precio
	 */
	public double getPrecio() {

		return precio;

	}

	/**
	 * @param precio Es el precio del producto
	 */
	public void setPrecio(double precio) {

		this.precio = precio;

	}

	/**
	 * @return Devuelve el stock
	 */
	public int getStock() {

		return stock;

	}

	/**
	 * @param stock Es el stock del producto
	 */
	public void setStock(int stock) {

		this.stock = stock;

	}

	/**
	 * @return Devuelve el Cif_proveedor
	 */
	public String getCif_Proveedor() {
		return cif_Proveedor;
	}

	/**
	 * @param cif_Proveedor Es el Cif_proveedor
	 */
	public void setCif_Proveedor(String cif_Proveedor) {
		this.cif_Proveedor = cif_Proveedor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param nombre Es el nombre del producto
	 * @param codigo Es el codigo del producto
	 * @param categor�a Es la categoria del producto
	 * @param precio Es el precio del producto
	 * @param stock Es el stock del prodcuto
	 * @param cifProveedor Es el CifProveedor del producto
	 * Creaci�n del metodo modificacion, permite modificar un producto.
	 */
	public static void modificacion(String nombre, int codigo, String categor�a, double precio, int stock,
			String cifProveedor) {
		Conexion cn = new Conexion();
		Connection miConexion = cn.getConexion();

		String consulta = "update producto set Nombre = '" + nombre + "', Categor�a = '" + categor�a + "', Precio = '"
				+ precio + "', Stock = '" + stock + "', Cif_proveedor='" + cifProveedor + "'  where codigo ='" + codigo
				+ "'";

		try {

			cn.s = miConexion.createStatement();
			cn.rs = cn.s.executeUpdate(consulta);

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	/**
	 * @param codigo
	 * Creaci�n del metodo borrar, permite borrar un producto.
	 */
	public static void borrar(int codigo) {

		Conexion cn = new Conexion();
		String sql = "delete from producto where Codigo='" + codigo + "'";

		try {

			cn.rs = cn.s.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
/**
 * 
 * @param codigo Es el codigo del producto
 * @return Devuelve true si codigo existe. Devuelve false si codigo no existe.
 * Creaci�n del metodo existeCodigo que comprueba si existe el codigo del producto.
 */
	public static boolean existeCodigo(int codigo) {

		boolean si = false;
		Conexion cn = new Conexion();
		String sql = "select Codigo from producto where Codigo='" + codigo + "'";

		try {

			cn.rs1 = cn.s.executeQuery(sql);
			if (cn.rs1.next()) {

				si = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return si;

	}
	/**
	 * 
	 * @param codigo Es el codigo del producto
	 * @return Devuelve true si codigo NO existe. Devuelve false si codigo existe.
	 * Creaci�n del metodo estaBorradoCodigo que comprueba si esta borrado el codigo del producto.
	 */
	public static boolean estaBorradoCodigo(int codigo) {

		boolean si = true;
		Conexion cn = new Conexion();
		String sql = "select Codigo from producto where Codigo='" + codigo + "'";

		try {

			cn.rs1 = cn.s.executeQuery(sql);
			if (cn.rs1.next()) {

				si = false;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return si;

	}

	/** 
	 * @param nombre Es el nombre del producto
	 * @param categor�a Es la categoria del producto
	 * @param precio Es el precio del producto
	 * @param stock Es el stock del producto
	 * @param cifProveedor Es el cifproveedor del producto
	 * 
	 * Creaci�n del metodo insertar, permite insertar productos a la base de datos.
	 */
	public static void insertar(String nombre, String categor�a, double precio, int stock, String cifProveedor) {
		Conexion cn = new Conexion();
		Connection miConexion = cn.getConexion();

		try {
			cn.s = miConexion.createStatement();
			cn.rs = cn.s.executeUpdate(
					"INSERT INTO producto (Nombre, categor�a, precio, stock, Cif_Proveedor) VALUES ('" + nombre + "', '"
							+ categor�a + "', '" + precio + "', '" + stock + "', '" + cifProveedor + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
