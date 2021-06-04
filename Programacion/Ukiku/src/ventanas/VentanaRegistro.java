package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/**
 * 
 * @author Ren�, Vicent, Joaqu�n
 *Creacion clase VentanaRegistro.
 */
public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldnombre;
	private JTextField textFieldContrase�a;
	private JLabel lblUkiku;
	private JButton btnRegistrarse;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblIntroduceUnNombre;

	/**
	 * Creaci�n de la ventana VentanaRegistro, donde se abre un formulario de registro.
	 */
	public VentanaRegistro() {
		setTitle("Registro - Ukiku");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logorene.png")));
		setBackground(Color.CYAN);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 403, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUkiku = new JLabel("");
		lblUkiku.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/img/xlarge_ukiku.png")));
		lblUkiku.setHorizontalAlignment(SwingConstants.CENTER);
		lblUkiku.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		lblUkiku.setBounds(0, 0, 388, 75);
		contentPane.add(lblUkiku);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setColumns(10);
		textFieldnombre.setBounds(138, 125, 144, 20);
		contentPane.add(textFieldnombre);
		
		textFieldContrase�a = new JPasswordField();
		textFieldContrase�a.setColumns(10);
		textFieldContrase�a.setBounds(138, 156, 144, 20);
		contentPane.add(textFieldContrase�a);
		/**
		 * Creaci�n del bot�n registrarse, una vez llenos los campos de Usuario y contrase�a, clic y estar�as registrado.
		 */
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(128, 128, 128));
		btnRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Usuario u = new Usuario();
					String nombre = textFieldnombre.getText();
					String contrase�a = textFieldContrase�a.getText();
					
					if(!u.existeUsuario(nombre)) {
						
						u.registrarse(nombre, contrase�a);
						JOptionPane.showMessageDialog(contentPane, "A�adido correctamente");
						VentanaLogin v = new VentanaLogin();
						v.setVisible(true);
						setVisible(false);

					} else {
						
						JOptionPane.showMessageDialog(contentPane, "El usuario ya existe");
					}
										
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(rootPane, "Error al registrar el usuario");
					e.printStackTrace();
					
				}
				
			}
		});
		btnRegistrarse.setBounds(233, 227, 144, 23);
		contentPane.add(btnRegistrarse);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBackground(Color.GRAY);
		lblUsuario.setBounds(41, 121, 73, 23);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasea.setBackground(Color.GRAY);
		lblContrasea.setBounds(10, 156, 104, 23);
		contentPane.add(lblContrasea);
		
		lblIntroduceUnNombre = new JLabel("Introduce un nombre de usuario y contrase\u00F1a");
		lblIntroduceUnNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceUnNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIntroduceUnNombre.setBounds(37, 87, 327, 23);
		contentPane.add(lblIntroduceUnNombre);
		/**
		 * Creaci�n del bot�n VolverAlLogin, para poder volver al login sin tener que cerrar la app.
		 */
		JButton btnVolverAlLogin = new JButton("Volver al login");
		btnVolverAlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				dispose();
				
			}
		});
		btnVolverAlLogin.setForeground(new Color(255, 255, 255));
		btnVolverAlLogin.setBackground(new Color(128, 128, 128));
		btnVolverAlLogin.setBounds(10, 227, 144, 23);
		contentPane.add(btnVolverAlLogin);
		
	}
}
