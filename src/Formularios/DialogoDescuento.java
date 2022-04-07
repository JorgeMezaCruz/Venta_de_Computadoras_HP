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

public class DialogoDescuento extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblA;
	private JLabel lblA_1;
	private JLabel lblA_2;
	private JLabel lblMsDe;
	private JTextField txtDescuento1;
	private JTextField txtDescuento2;
	private JTextField txtDescuento3;
	private JTextField txtDescuento4;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnGrabar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoDescuento dialog = new DialogoDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoDescuento() {
		setResizable(false);
		setTitle("Configurar porcentajes de descuento");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoDescuento.class.getResource("/Imagenes/descuento.png")));
		setBounds(100, 100, 501, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblA = new JLabel("1 a 5 unidades");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA.setBounds(22, 36, 128, 14);
		contentPanel.add(lblA);
		
		lblA_1 = new JLabel("6 a 10 unidades");
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA_1.setBounds(22, 76, 128, 14);
		contentPanel.add(lblA_1);
		
		lblA_2 = new JLabel("11 a 15 unidades");
		lblA_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA_2.setBounds(22, 116, 128, 14);
		contentPanel.add(lblA_2);
		
		lblMsDe = new JLabel("m\u00E1s de 15 unidades");
		lblMsDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMsDe.setBounds(22, 153, 128, 14);
		contentPanel.add(lblMsDe);
		
		txtDescuento1 = new JTextField();
		txtDescuento1.addKeyListener(this);
		txtDescuento1.setBounds(167, 34, 86, 20);
		contentPanel.add(txtDescuento1);
		txtDescuento1.setColumns(10);
		
		txtDescuento2 = new JTextField();
		txtDescuento2.addKeyListener(this);
		txtDescuento2.setBounds(167, 74, 86, 20);
		contentPanel.add(txtDescuento2);
		txtDescuento2.setColumns(10);
		
		txtDescuento3 = new JTextField();
		txtDescuento3.addKeyListener(this);
		txtDescuento3.setBounds(167, 114, 86, 20);
		contentPanel.add(txtDescuento3);
		txtDescuento3.setColumns(10);
		
		txtDescuento4 = new JTextField();
		txtDescuento4.addKeyListener(this);
		txtDescuento4.setBounds(167, 151, 86, 20);
		contentPanel.add(txtDescuento4);
		txtDescuento4.setColumns(10);
		
		label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(263, 37, 46, 14);
		contentPanel.add(label);
		
		label_1 = new JLabel("%");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(263, 77, 46, 14);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(263, 117, 46, 14);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("%");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(263, 154, 46, 14);
		contentPanel.add(label_3);
		
		btnGrabar = new JButton("  Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DialogoDescuento.class.getResource("/Imagenes/guardar.png")));
		btnGrabar.setBounds(334, 36, 125, 43);
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoDescuento.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.setBounds(334, 106, 125, 43);
		contentPanel.add(btnCerrar);
		
		MostrarDescuentos();
		
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
	
	void MostrarDescuentos() {
		txtDescuento1.setText(""+FormularioPrincipal.porcentaje1);
		txtDescuento2.setText(""+FormularioPrincipal.porcentaje2);
		txtDescuento3.setText(""+FormularioPrincipal.porcentaje3);
		txtDescuento4.setText(""+FormularioPrincipal.porcentaje4);
	}

	void GrabarDescuentos() {
		FormularioPrincipal.porcentaje1=Double.parseDouble(txtDescuento1.getText());
		FormularioPrincipal.porcentaje2=Double.parseDouble(txtDescuento2.getText());
		FormularioPrincipal.porcentaje3=Double.parseDouble(txtDescuento3.getText());
		FormularioPrincipal.porcentaje4=Double.parseDouble(txtDescuento4.getText());

	}
	

	
	
	protected void actionPerformedbtnGrabar(ActionEvent arg0) {
		try {
			
			
		GrabarDescuentos();}
		catch (Exception e) {
			FormularioPrincipal.NoGuardado();
			return;}
		FormularioPrincipal.Guardado();
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtDescuento4) {
			keyTypedTxtDescuento4(arg0);
		}
		if (arg0.getSource() == txtDescuento3) {
			keyTypedTxtDescuento3(arg0);
		}
		if (arg0.getSource() == txtDescuento2) {
			keyTypedTxtDescuento2(arg0);
		}
		if (arg0.getSource() == txtDescuento1) {
			keyTypedTxtDescuento1(arg0);
		}
	}
	protected void keyTypedTxtDescuento1(KeyEvent arg0) {
		
		char key = arg0.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtDescuento1.requestFocus();
			}
	}
	protected void keyTypedTxtDescuento2(KeyEvent arg0) {
		
		char key = arg0.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtDescuento2.requestFocus();
			}
	}
	protected void keyTypedTxtDescuento3(KeyEvent arg0) {
		
		char key = arg0.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtDescuento3.requestFocus();
			}
	}
	protected void keyTypedTxtDescuento4(KeyEvent arg0) {
		
		char key = arg0.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtDescuento4.requestFocus();
			}
	}
}
