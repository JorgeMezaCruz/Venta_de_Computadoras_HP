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

public class DialogoPremio extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblA;
	private JLabel lblA_1;
	private JTextField txtNumero;
	private JTextField txtPremio;
	private JButton btnGrabar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoPremio dialog = new DialogoPremio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoPremio() {
		setResizable(false);
		setTitle("Configurar premio sorpresa");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoPremio.class.getResource("/Imagenes/obsequio.png")));
		setBounds(100, 100, 458, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblA = new JLabel("Numero de Cliente");
		lblA.setBounds(20, 40, 140, 14);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA);
		
		lblA_1 = new JLabel("Premio Sorpresa");
		lblA_1.setBounds(20, 80, 128, 14);
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA_1);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setBounds(170, 40, 86, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtPremio = new JTextField();
		txtPremio.addKeyListener(this);
		txtPremio.setBounds(170, 80, 86, 20);
		contentPanel.add(txtPremio);
		txtPremio.setColumns(10);
		
		btnGrabar = new JButton("  Grabar");
		btnGrabar.setBounds(298, 27, 125, 43);
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DialogoPremio.class.getResource("/Imagenes/guardar.png")));
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setBounds(298, 80, 125, 43);
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoPremio.class.getResource("/Imagenes/cerrar.png")));
		contentPanel.add(btnCerrar);
		
		MostrarPremio();
		
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
	
	void MostrarPremio() {
		txtNumero.setText(""+FormularioPrincipal.numeroClientePremiado);
		txtPremio.setText("MEMORIA USB");
	}
	int ClienteP() {
		return Integer.parseInt(txtNumero.getText());
		}
	void GrabarPremio() {
		FormularioPrincipal.numeroClientePremiado=Integer.parseInt(txtNumero.getText());
		FormularioPrincipal.premioSorpresa=txtPremio.getText();
	}
	protected void actionPerformedbtnGrabar(ActionEvent arg0) {
		
		int ClientePremiado;
		
		try {
			ClientePremiado=ClienteP();}
		catch (Exception e) {
			FormularioPrincipal.NoGuardado();
			return;}
		if(ClientePremiado>0 && txtPremio.getText().length()!=0) {
			if(String.valueOf(txtPremio.getText().charAt(0)).equals(" ")) {
				FormularioPrincipal.NoGuardado();return;}
			GrabarPremio();
			FormularioPrincipal.Guardado();}else {FormularioPrincipal.NoGuardado();}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPremio) {
			keyTypedTxtPremio(e);
		}
		if (e.getSource() == txtNumero) {
			keyTypedTxtNumero(e);
		}
	}
	protected void keyTypedTxtNumero(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtNumero.setText(null);
			txtNumero.requestFocus();
			}
	}
	protected void keyTypedTxtPremio(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isDigit(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Letras();
			txtPremio.setText(null);
			txtPremio.requestFocus();
			}
	}
}
