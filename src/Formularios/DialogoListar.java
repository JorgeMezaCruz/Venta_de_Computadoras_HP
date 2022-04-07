package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class DialogoListar extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnListar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoListar dialog = new DialogoListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoListar() {
		setResizable(false);
		setModal(true);
		setTitle("Listar Maletas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoListar.class.getResource("/Imagenes/lista.png")));
		setBounds(100, 100, 450, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 26, 377, 265);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Arial", Font.BOLD, 14));
		txtS.setBackground(Color.WHITE);
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("  Listar");
		btnListar.setIcon(new ImageIcon(DialogoListar.class.getResource("/Imagenes/lista.png")));
		btnListar.addActionListener(this);
		btnListar.setBounds(75, 312, 125, 43);
		contentPanel.add(btnListar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setIcon(new ImageIcon(DialogoListar.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(237, 312, 125, 43);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}
	
	void Listar() {
		txtS.setText("  LISTADO DE COMPUTADORAS :" + 
				"\n\n   Código	:  " + FormularioPrincipal.codigo0 + 
				"\n   Modelo	:  " + FormularioPrincipal.nombre0 + 
				"\n   Precio	:  " + FormularioPrincipal.precio0 +
				"\n   Contenido	:  " + FormularioPrincipal.contenido0 +
				"\n   Año de Fabricacion	:  " + FormularioPrincipal.año0 +
				"\n   Casa	:  " + FormularioPrincipal.casa0 +
				"\n\n   Código	:  " + FormularioPrincipal.codigo1 + 
				"\n   Modelo	:  " + FormularioPrincipal.nombre1 + 
				"\n   Precio	:  " + FormularioPrincipal.precio1 +
				"\n   Contenido	:  " + FormularioPrincipal.contenido1 +
				"\n   Año de Fabricacion	:  " + FormularioPrincipal.año1 +
				"\n   Casa	:  " + FormularioPrincipal.casa1 +
				"\n\n   Código	:  " + FormularioPrincipal.codigo2 + 
				"\n   Modelo	:  " + FormularioPrincipal.nombre2 + 
				"\n   Precio	:  " + FormularioPrincipal.precio2 +
				"\n   Contenido	:  " + FormularioPrincipal.contenido2 +
				"\n   Año de Fabricacion	:  " + FormularioPrincipal.año2 +
				"\n   Casa	:  " + FormularioPrincipal.casa2 +
				"\n\n   Código	:  " + FormularioPrincipal.codigo3 + 
				"\n   Modelo	:  " + FormularioPrincipal.nombre3 + 
				"\n   Precio	:  " + FormularioPrincipal.precio3 +
				"\n   Contenido	:  " + FormularioPrincipal.contenido3 +
				"\n   Año de Fabricacion	:  " + FormularioPrincipal.año3 +
				"\n   Casa	:  " + FormularioPrincipal.casa3 +
				"\n\n   Código	:  " + FormularioPrincipal.codigo4 + 
				"\n   Modelo	:  " + FormularioPrincipal.nombre4 + 
				"\n   Precio	:  " + FormularioPrincipal.precio4 +
				"\n   Contenido	:  " + FormularioPrincipal.contenido4 +
				"\n   Año de Fabricacion	:  " + FormularioPrincipal.año4 +
				"\n   Casa	:  " + FormularioPrincipal.casa4);
			
		txtS.setCaretPosition(0);

	}
	
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		
		Listar();
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
		dispose();
	}
}
