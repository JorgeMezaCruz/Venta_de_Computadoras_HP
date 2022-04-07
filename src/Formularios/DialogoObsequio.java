package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DialogoObsequio extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblA;
	private JLabel lblA_1;
	private JTextField txtCantidad;
	private JTextField txtObsequio;
	private JButton btnGrabar;
	private JButton btnCerrar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoObsequio dialog = new DialogoObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoObsequio() {
		setResizable(false);
		setTitle("Configurar Obsequio");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoObsequio.class.getResource("/Imagenes/obsequio.png")));
		setBounds(100, 100, 663, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblA = new JLabel("Cantidad Minima de Computadoras Adquiridas");
		lblA.setBounds(20, 40, 321, 14);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA);
		
		lblA_1 = new JLabel("Obsequio");
		lblA_1.setBounds(20, 80, 128, 14);
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA_1);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(351, 38, 97, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtObsequio = new JTextField();
		txtObsequio.addKeyListener(this);
		txtObsequio.setBounds(351, 78, 97, 20);
		contentPanel.add(txtObsequio);
		txtObsequio.setColumns(10);
		
		btnGrabar = new JButton("  Grabar");
		btnGrabar.setBounds(502, 27, 125, 43);
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DialogoObsequio.class.getResource("/Imagenes/guardar.png")));
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setBounds(502, 80, 125, 43);
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoObsequio.class.getResource("/Imagenes/cerrar.png")));
		contentPanel.add(btnCerrar);
		
		MostrarObsequios();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedbtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(arg0);
		}
	}
	protected void actionPerformedbtnCerrar(ActionEvent arg0) {
		dispose();
	}
	
	void MostrarObsequios() {
		txtCantidad.setText(""+FormularioPrincipal.cantidadMinima);
		txtObsequio.setText(""+FormularioPrincipal.obsequio);
	}

	void GrabarObsequios() {
		FormularioPrincipal.cantidadMinima=Integer.parseInt(txtCantidad.getText());
		FormularioPrincipal.obsequio=txtObsequio.getText();

	}
	int CantMin() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	
	protected void actionPerformedbtnGrabar(ActionEvent arg0) {
		
		int cantMin;


		try {
		cantMin = CantMin();}
		catch (Exception e) {
			FormularioPrincipal.NoGuardado();
			return;
		}

		if(cantMin>0 && txtObsequio.getText().length()!=0){
			if(String.valueOf(txtObsequio.getText().charAt(0)).equals(" ")) {
				FormularioPrincipal.NoGuardado();return;}
			GrabarObsequios();
		FormularioPrincipal.Guardado();}
		else {FormularioPrincipal.NoGuardado();}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtObsequio) {
			keyTypedTxtObsequio(e);
		}
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
	}
	protected void keyTypedTxtCantidad(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtCantidad.requestFocus();
			}
	}
	protected void keyTypedTxtObsequio(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isDigit(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Letras();
			txtObsequio.requestFocus();
			}
	}
}
