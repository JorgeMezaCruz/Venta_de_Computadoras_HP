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

public class DialogoStock extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblA;
	private JLabel lblA_1;
	private JTextField txtStockMT0;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JLabel lblStockMaletaMt;
	private JLabel lblStockMaletaMt_1;
	private JLabel lblStockMaletaMt_2;
	private JTextField txtStockMT1;
	private JTextField txtStockMT2;
	private JTextField txtStockMT3;
	private JTextField txtStockMT4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoStock dialog = new DialogoStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoStock() {
		setResizable(false);
		setTitle("Configurar Stock");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoStock.class.getResource("/Imagenes/stock.png")));
		setBounds(100, 100, 458, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblA = new JLabel("Portatil HP ZBook \r\n");
		lblA.setBounds(20, 37, 140, 14);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA);
		
		lblA_1 = new JLabel("Portatil HP ENVY\r\n\r\n");
		lblA_1.setBounds(20, 88, 128, 14);
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblA_1);
		
		txtStockMT0 = new JTextField();
		txtStockMT0.addKeyListener(this);
		txtStockMT0.setBounds(170, 35, 86, 20);
		contentPanel.add(txtStockMT0);
		txtStockMT0.setColumns(10);
		
		btnGrabar = new JButton("  Grabar");
		btnGrabar.setBounds(298, 27, 125, 43);
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DialogoStock.class.getResource("/Imagenes/guardar.png")));
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setBounds(298, 80, 125, 43);
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoStock.class.getResource("/Imagenes/cerrar.png")));
		contentPanel.add(btnCerrar);
		
		lblStockMaletaMt = new JLabel("Portatil HP EliteBook \r\n");
		lblStockMaletaMt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStockMaletaMt.setBounds(20, 139, 140, 14);
		contentPanel.add(lblStockMaletaMt);
		
		lblStockMaletaMt_1 = new JLabel("Portatil HP Pavilion \r\n");
		lblStockMaletaMt_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStockMaletaMt_1.setBounds(20, 190, 140, 14);
		contentPanel.add(lblStockMaletaMt_1);
		
		lblStockMaletaMt_2 = new JLabel("Portatil HP ProBook");
		lblStockMaletaMt_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStockMaletaMt_2.setBounds(20, 241, 140, 14);
		contentPanel.add(lblStockMaletaMt_2);
		
		txtStockMT1 = new JTextField();
		txtStockMT1.addKeyListener(this);
		txtStockMT1.setBounds(170, 86, 86, 20);
		contentPanel.add(txtStockMT1);
		txtStockMT1.setColumns(10);
		
		txtStockMT2 = new JTextField();
		txtStockMT2.addKeyListener(this);
		txtStockMT2.setBounds(170, 137, 86, 20);
		contentPanel.add(txtStockMT2);
		txtStockMT2.setColumns(10);
		
		txtStockMT3 = new JTextField();
		txtStockMT3.addKeyListener(this);
		txtStockMT3.setBounds(170, 188, 86, 20);
		contentPanel.add(txtStockMT3);
		txtStockMT3.setColumns(10);
		
		txtStockMT4 = new JTextField();
		txtStockMT4.addKeyListener(this);
		txtStockMT4.setBounds(170, 239, 86, 20);
		contentPanel.add(txtStockMT4);
		txtStockMT4.setColumns(10);
		
		MostrarStock();
		
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
	
	void MostrarStock() {
		txtStockMT0.setText(""+FormularioPrincipal.stock0);
		txtStockMT1.setText(""+FormularioPrincipal.stock1);
		txtStockMT2.setText(""+FormularioPrincipal.stock2);
		txtStockMT3.setText(""+FormularioPrincipal.stock3);
		txtStockMT4.setText(""+FormularioPrincipal.stock4);
	}
	int StockMT0() {
		return Integer.parseInt(txtStockMT0.getText());
		}
	int StockMT1() {
		return Integer.parseInt(txtStockMT1.getText());
		}
	int StockMT2() {
		return Integer.parseInt(txtStockMT2.getText());
		}
	int StockMT3() {
		return Integer.parseInt(txtStockMT3.getText());
		}
	int StockMT4() {
		return Integer.parseInt(txtStockMT4.getText());
		}
	void GrabarStock() {
		FormularioPrincipal.stock0=Integer.parseInt(txtStockMT0.getText());
		FormularioPrincipal.stock1=Integer.parseInt(txtStockMT1.getText());
		FormularioPrincipal.stock2=Integer.parseInt(txtStockMT2.getText());
		FormularioPrincipal.stock3=Integer.parseInt(txtStockMT3.getText());
		FormularioPrincipal.stock4=Integer.parseInt(txtStockMT4.getText());
		}
	protected void actionPerformedbtnGrabar(ActionEvent arg0) {
		
		int StockMT0,StockMT1,StockMT2,StockMT3,StockMT4;
		
		try {
			StockMT0=StockMT0();
			StockMT1=StockMT1();
			StockMT2=StockMT2();
			StockMT3=StockMT3();
			StockMT4=StockMT4();
			}
		catch (Exception e) {
			FormularioPrincipal.NoGuardado();
			return;}
		if(StockMT0>0 && StockMT1>0 && StockMT2>0 && StockMT3>0 && StockMT4>0) {
			GrabarStock();
			FormularioPrincipal.Guardado();}
		else {FormularioPrincipal.NoGuardado();}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtStockMT4) {
			keyTypedTxtStockMT4(e);
		}
		if (e.getSource() == txtStockMT3) {
			keyTypedTxtStockMT3(e);
		}
		if (e.getSource() == txtStockMT2) {
			keyTypedTxtStockMT2(e);
		}
		if (e.getSource() == txtStockMT1) {
			keyTypedTxtStockMT1(e);
		}
		if (e.getSource() == txtStockMT0) {
			keyTypedTxtNumero(e);
		}
	}
	protected void keyTypedTxtNumero(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtStockMT0.setText(null);
			txtStockMT0.requestFocus();
			}
	}
	protected void keyTypedTxtStockMT1(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtStockMT1.setText(null);
			txtStockMT1.requestFocus();
			}
	}
	protected void keyTypedTxtStockMT2(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtStockMT2.setText(null);
			txtStockMT2.requestFocus();
			}
	}
	protected void keyTypedTxtStockMT3(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtStockMT3.setText(null);
			txtStockMT3.requestFocus();
			}
	}
	protected void keyTypedTxtStockMT4(KeyEvent e) {
		
		char key = e.getKeyChar();
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			e.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			txtStockMT4.setText(null);
			txtStockMT4.requestFocus();
			}
	}
}
