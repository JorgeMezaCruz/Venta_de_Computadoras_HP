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

public class DialogoCantOptima extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblA;
	private JTextField txtCantidad;
	private JButton btnGrabar;
	private JButton btnCerrar;
	public static int cantop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoCantOptima dialog = new DialogoCantOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoCantOptima() {
		setResizable(false);
		setTitle("Configurar Cantidad Optima de Computadoras Vendidas");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoCantOptima.class.getResource("/Imagenes/obsequio.png")));
		setBounds(100, 100, 634, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblA = new JLabel("Cantidad Optima de Computadoras Vendidas");
		lblA.setBounds(20, 40, 270, 14);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(300, 38, 86, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnGrabar = new JButton("  Grabar");
		btnGrabar.setBounds(472, 23, 125, 43);
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DialogoCantOptima.class.getResource("/Imagenes/guardar.png")));
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setBounds(472, 76, 125, 43);
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoCantOptima.class.getResource("/Imagenes/cerrar.png")));
		contentPanel.add(btnCerrar);
		
		MostrarCantOptima();
		
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
	
	void MostrarCantOptima() {
		txtCantidad.setText(""+FormularioPrincipal.cantidadOptima);
	}

	void GrabarCantOptima() {
		FormularioPrincipal.cantidadOptima=Integer.parseInt(txtCantidad.getText());
		
	}
	void cantop() {
		cantop=Integer.parseInt(txtCantidad.getText());
	}
	
	
	
	protected void actionPerformedbtnGrabar(ActionEvent arg0) {
		try {
		cantop();}
		catch (Exception e) {
			FormularioPrincipal.NoGuardado();
			txtCantidad.setText(null);
			txtCantidad.requestFocus();
			return;}
		if(cantop>0) {
		GrabarCantOptima();
		FormularioPrincipal.Guardado();
;}
		else {
			FormularioPrincipal.ValorMayorCero();
			txtCantidad.setText(null);
			txtCantidad.requestFocus();
		}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
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
}
