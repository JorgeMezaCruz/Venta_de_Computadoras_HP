package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FormularioLogin extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JPasswordField jpassClave;
	private JLabel label;
	private JLabel text;
	private JLabel label_1;
	
	Timer tm;
	int i = 0;
	public static String user,pass;
	private static JComboBox<?> cboUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioLogin frame = new FormularioLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FormularioLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioLogin.class.getResource("/Imagenes/password.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 232);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		lblUsuario = new JLabel("  Usuario :");
		lblUsuario.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/user.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(59, 31, 114, 39);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("  Contrase\u00F1a :");
		lblContrasea.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/password.png")));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(59, 81, 134, 39);
		contentPane.add(lblContrasea);
		
		btnIngresar = new JButton("  Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresar.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/ingresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(41, 140, 134, 39);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("  Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/salir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(194, 140, 134, 39);
		contentPane.add(btnSalir);
		
		jpassClave = new JPasswordField();
		jpassClave.addKeyListener(this);
		jpassClave.setBounds(197, 89, 109, 20);
		contentPane.add(jpassClave);
		
		label = new JLabel("");
		label.setVisible(false);
		label.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/iniciando.gif")));
		label.setBounds(122, 174, 139, 47);
		contentPane.add(label);
		
		text = new JLabel("");
		text.setBounds(46, 222, 0, 5);
		contentPane.add(text);
		
		cboUsuarios = new JComboBox();
		cboUsuarios.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario1", "Usuario2"}));
		cboUsuarios.setBounds(197, 41, 109, 20);
		contentPane.add(cboUsuarios);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FormularioLogin.class.getResource("/Imagenes/ISesion.png")));
		label_1.setBounds(-7, -18, 383, 268);
		contentPane.add(label_1);
		
		tm = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				text.setText(Integer.toString(i));
				i++;
				if (i == 50) {
					dispose();
					FormularioPrincipal p = new FormularioPrincipal(); 
					p.setVisible(true);
					
					
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		System.exit(0);
	}

		
	String Password () {
		return String.valueOf(jpassClave.getPassword());
	}
	public static String User () {
		return String.valueOf(cboUsuarios.getSelectedItem());
	}
	
	void Validacion (String pass, String user) {
		if (user.equals("Administrador") && pass.equals("admin")||(user.equals("Usuario1")&&pass.equals("user1"))||(user.equals("Usuario2")&&pass.equals("user2"))){
			jpassClave.setEnabled(false);
			tm.start();
			label.setVisible(true);
		
	}
		else {
			Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
			JOptionPane.showMessageDialog(null,"Contraseña Incorrecta","Error al iniciar sesión",JOptionPane.INFORMATION_MESSAGE,ico);
			cboUsuarios.setSelectedIndex(0);
			jpassClave.setText(null);
		
	}
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		

		
		pass = Password();
		user = User();
		Validacion(pass, user);

		

		
	}
	public void keyPressed(KeyEvent arg0) {	
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			ActionEvent e = null;
			actionPerformedBtnIngresar(e);
        }
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == jpassClave) {
			keyTypedJpassClave(arg0);
		}
	}
	protected void keyTypedJpassClave(KeyEvent arg0) {
		
		char key = arg0.getKeyChar();

		if(Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/usererror.png")); 
			JOptionPane.showMessageDialog(null,"Valor no admitido","Error al iniciar sesión",JOptionPane.INFORMATION_MESSAGE,ico);
			cboUsuarios.setSelectedIndex(0);
			jpassClave.setText(null);}
	}
}
