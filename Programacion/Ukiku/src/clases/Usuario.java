package clases;

/**
 * 
 * @author Ren�, Vicent, Joaqu�n
 * 
 *         <b>Clase Useario</b>
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
	 * @param nombre
	 * @param contrase�a
	 * 
	 *                   Comprueba que el nombre y contrase�a introducidos por
	 *                   parametros coincidan con los de la base de datos.
	 */
	public void acceder(String nombre, String contrase�a) {

	}

	/**
	 * @param nombre
	 * @param contrase�a
	 * 
	 *                   A�ade el nombre y contrase�a introducidos por parametro a
	 *                   la base de datos.
	 */
	public void registrarse(String nombre, String contrase�a) {

	}

}
