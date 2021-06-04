package clases;

import java.sql.SQLException;

import conectarBd.Conexion;

/**
 * 
 * @author Ren�, Vicent, Joaqu�n
 * 
 *         
 *
 */

public class Usuario {

	/**
	 * @param nombre     Nombre de usuario.
	 * @param contrase�a Contrase�a de el usuario.
	 */
	private String nombre;
	private String contrase�a;

	public Usuario() {

	}

	/**
	 * @param nombre     Nombre introducido por parametro.
	 * @param contrase�a Contrase�a introducido por parametro.
	 */
	public Usuario(String nombre, String contrase�a) {

		this.contrase�a = contrase�a;
		this.nombre = nombre;

	}

	/**
	 * @return Devuelve el nombre actual.
	 */
	public String getNombre() {

		return nombre;

	}

	/**
	 * @param nombre Modifica el nombre actual.
	 */
	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	/**
	 * @return Devuelve la contrase�a actual.
	 */
	public String getContrase�a() {

		return contrase�a;

	}

	/**
	 * @param contrase�a Modiffica el nombre actual.
	 */
	public void setContrase�a(String contrase�a) {

		this.contrase�a = contrase�a;

	}

	/**
	 * @param nombre Es el nombre del usuario
	 * @param contrase�a Es la contrase�a del usuario
	 * @return acceso Devuelve si el usuario puede acceder o no
	 *                   Comprueba que el nombre y contrase�a introducidos por
	 *                   parametros coincidan con los de la base de datos.
	 */
	public boolean acceder(String nombre, String contrase�a) {

		Conexion c = new Conexion();
		boolean acceso = false;
		String sql = "select nombre, contrase�a from usuario where nombre= '" + nombre + "' AND contrase�a= '"
				+ contrase�a + "'";
		try {

			c.rs1 = c.s.executeQuery(sql);

			if (c.rs1.next()) {

				acceso = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		c.desconectar();

		return acceso;

	}

	/**
	 * @param nombre Es el nombre del usuario
	 * @param contrase�a Es la contrase�a del usuario
	 * 
	 *                   A�ade el nombre y contrase�a introducidos por parametro a
	 *                   la base de datos.
	 */
	public void registrarse(String nombre, String contrase�a) {

		Conexion c = new Conexion();
		String sql = "insert into usuario(Nombre, Contrase�a)" + " values ('" + nombre + "', '" + contrase�a + "')";
		try {

			c.rs = c.s.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();

		}

		c.desconectar();

	}
	/**
	 * @param nombre Es el nombre del usuario
	 * @return Devuelve si existe el Usuario
	 *                   Comprueba el nombre introducido por parametro a
	 *                   la base de datos, si existe, no te deja crearlo.
	*/
	public boolean existeUsuario(String nombre) {
		Conexion c = new Conexion();
		boolean existeUsuario = false;
		String sql = "select nombre from usuario where nombre= '" + nombre + "'";

		try {

			c.rs1 = c.s.executeQuery(sql);

			if (c.rs1.next()) {

				existeUsuario = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return existeUsuario;
	}

}
