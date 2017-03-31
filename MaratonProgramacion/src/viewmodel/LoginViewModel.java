package viewmodel;

/**
 * @author Wilsen Hernandez
 *
 */
public class LoginViewModel {
	/**
	 * @param username Nombre de Usuario
	 * @param password Contraseña
	 */
	public static void Login(String usr, char[] pswd) {
		if (model.Conexion.login(usr, pswd)) {
			System.out.println(usr.toUpperCase() + " CONECTADO");
		} else {
			System.err.println("PSQL - Error de conexión");
		}
	}
}
