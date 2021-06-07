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
	 * @param nombre     Es el nombre del usuario
	 * @param contrase�a Es la contrase�a del usuario
	 * @return acceso Devuelve si el usuario puede acceder o no Comprueba que el
	 *         nombre y contrase�a introducidos por parametros coincidan con los de
	 *         la base de datos.
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

		return acceso;

	}

	/**
	 * @param nombre     Es el nombre del usuario
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
	 * @return Devuelve si existe el Usuario Comprueba el nombre introducido por
	 *         parametro a la base de datos, si existe, no te deja crearlo.
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

	/**
	 * @param contrase�a Contrase�a a validar.
	 * @return Devuelve verdadero si la contrase�a tiene, al menos, 8 caracteres,
	 *         una mayuscula, una minuscula y un numero. En caso contrario devuelve
	 *         falso.
	 */
	public boolean contrase�aValida(String contrase�a) {

		boolean esValida = false;

		if (contrase�a.length() > 7) {

			int contarNumeros = 0, contarMayusculas = 0, contarMinusculas = 0;
			char contra;

			for (int i = 0; i < contrase�a.length(); i++) {

				contra = contrase�a.charAt(i);

				String contraValor = String.valueOf(contra);

				if (contraValor.matches("[A-Z]")) {

					contarMayusculas++;

				} else if (contraValor.matches("[a-z]")) {

					contarMinusculas++;

				} else if (contraValor.matches("[0-9]")) {

					contarNumeros++;

				}

			}

			if (contarMayusculas > 0 && contarMinusculas > 0 && contarNumeros > 0) {

				esValida = true;
			}

		}

		return esValida;

	}
	
	/**
	 * @param nombre Nombre de usuario.
	 * @return Devuelve verdadero si el nombre tiene, al menos, 8 caracteres,
	 *         una mayuscula, una minuscula y un numero. En caso contrario devuelve
	 *         falso.
	 */
	public boolean usuarioValido(String nombre) {

		boolean esValido = false;

		if (nombre.length() > 7) {

			int contarNumeros = 0, contarMayusculas = 0, contarMinusculas = 0;
			char nom;

			for (int i = 0; i < nombre.length(); i++) {

				nom = nombre.charAt(i);

				String nomValor = String.valueOf(nom);

				if (nomValor.matches("[A-Z]")) {

					contarMayusculas++;

				} else if (nomValor.matches("[a-z]")) {

					contarMinusculas++;

				} else if (nomValor.matches("[0-9]")) {

					contarNumeros++;

				}

			}

			if (contarMayusculas > 0 && contarMinusculas > 0 && contarNumeros > 0) {

				esValido = true;
			}

		}

		return esValido;

	}

}
