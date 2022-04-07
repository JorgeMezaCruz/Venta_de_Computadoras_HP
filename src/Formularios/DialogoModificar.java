package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class DialogoModificar extends JDialog implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JLabel lblNombre;
	private JLabel lblCasa;
	private JLabel lblAoDeLanzamiento;
	private JLabel lblContenidoml;
	private JLabel lblPrecios;
	@SuppressWarnings("rawtypes")
	private JComboBox cboNombre;
	private JButton btnGuardar;
	private JTextField txtS1;
	private JTextField txtS2;
	private JTextField txtS4;
	private JTextField txtS3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConsultar dialog = new DialogoConsultar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DialogoModificar() {
		setForeground(Color.BLACK);
		setTitle("Modificar Computadora\r\n");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaptionBorder);
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setBounds(267, 78, 140, 43);
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoStock.class.getResource("/Imagenes/cerrar.png")));
		contentPanel.add(btnCerrar);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 31, 46, 14);
		contentPanel.add(lblNombre);
		
		lblCasa = new JLabel("Procesador");
		lblCasa.setBounds(10, 175, 107, 14);
		contentPanel.add(lblCasa);
		
		lblAoDeLanzamiento = new JLabel("A\u00F1o de Lanzamiento");
		lblAoDeLanzamiento.setBounds(10, 141, 118, 14);
		contentPanel.add(lblAoDeLanzamiento);
		
		lblContenidoml = new JLabel("Capacidad (GB)");
		lblContenidoml.setBounds(10, 107, 107, 14);
		contentPanel.add(lblContenidoml);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(10, 73, 70, 14);
		contentPanel.add(lblPrecios);
		
		
		cboNombre = new JComboBox();
		cboNombre.setBackground(SystemColor.textHighlight);
		cboNombre.addItemListener(this);
		cboNombre.addActionListener(this);
		cboNombre.setModel(new DefaultComboBoxModel(new String[] {"Port\u00E1til HP ZBook ", "Port\u00E1til HP ENVY", "Port\u00E1til HP EliteBook ", "Port\u00E1til HP Pavilion ", "Port\u00E1til HP ProBook"}));
		cboNombre.setBounds(97, 30, 140, 17);
		contentPanel.add(cboNombre);
		cboNombre.setSelectedItem("ALCAZAR");

		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(DialogoDescuento.class.getResource("/Imagenes/guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(267, 27, 140, 43);
		contentPanel.add(btnGuardar);
		
		txtS1 = new JTextField();
		txtS1.addActionListener(this);
		txtS1.setBounds(130, 70, 86, 20);
		contentPanel.add(txtS1);
		txtS1.setColumns(10);
		
		txtS2 = new JTextField();
		txtS2.setColumns(10);
		txtS2.setBounds(130, 101, 86, 20);
		contentPanel.add(txtS2);
		
		txtS3 = new JTextField();
		txtS3.setColumns(10);
		txtS3.setBounds(130, 138, 86, 20);
		contentPanel.add(txtS3);
		
		txtS4 = new JTextField();
		txtS4.setColumns(10);
		txtS4.setBounds(130, 172, 86, 20);
		contentPanel.add(txtS4);
	}


	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnUardar(e);
		}
		if (e.getSource() == cboNombre) {
			actionPerformedCboNombre(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();

	}
	protected void actionPerformedCboNombre(ActionEvent e) {
		
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboNombre) {
			itemStateChangedCboNombre(arg0);
		}
	}
	protected void itemStateChangedCboNombre(ItemEvent arg0) {
		


 
	
}
	protected void actionPerformedBtnUardar(ActionEvent e) {
		int nombre;
		//METODOS
		nombre = determinarPerfume();
		modificarDatos(nombre);
				
	}

	//Metodo para modificar perfume
	int determinarPerfume() {
		return 0;
		 
	} 

		
	
	//Metodo Para modificar Precio y Contenido
		void modificarDatos(int nombre) {
		switch (nombre){
		
		case 0:{
			FormularioPrincipal.precio0 = Double.parseDouble(txtS1.getText());
			txtS1.setText(FormularioPrincipal.precio0 + "\n");
			
			FormularioPrincipal.contenido0 = Double.parseDouble(txtS2.getText());
			txtS2.setText(FormularioPrincipal.contenido0 + "\n");
			
			FormularioPrincipal.año0=Integer.parseInt(txtS3.getText());
			txtS3.setText(FormularioPrincipal.año0 + "\n");		
			
			FormularioPrincipal.casa0=(txtS4.getText());
			txtS4.setText(FormularioPrincipal.casa0 + "\n");}		

		break;
		case 1:{
			FormularioPrincipal.precio1=Double.parseDouble(txtS1.getText());
			txtS1.setText(FormularioPrincipal.precio1 + "\n");
			
			FormularioPrincipal.contenido1=Double.parseDouble(txtS2.getText());
			txtS2.setText(FormularioPrincipal.contenido1+ "\n");
			
			FormularioPrincipal.año1=Integer.parseInt(txtS3.getText());
			txtS3.setText(FormularioPrincipal.año1 + "\n");		
			
			FormularioPrincipal.casa1=(txtS4.getText());
			txtS4.setText(FormularioPrincipal.casa1 + "\n");}		

		break;
		
		case 2:{
			FormularioPrincipal.precio2=Double.parseDouble(txtS1.getText());
			txtS1.setText(FormularioPrincipal.precio2+ "\n");
			
			FormularioPrincipal.contenido2=Double.parseDouble(txtS2.getText());
			txtS2.setText(FormularioPrincipal.contenido2+ "\n");
			
			FormularioPrincipal.año2=Integer.parseInt(txtS3.getText());
			txtS3.setText(FormularioPrincipal.año2 + "\n");		
			
			FormularioPrincipal.casa2=(txtS4.getText());
			txtS4.setText(FormularioPrincipal.casa2 + "\n");
			
		}		
		break;
			
		case 3:{			
		
		FormularioPrincipal.precio3=Double.parseDouble(txtS1.getText());
		txtS1.setText(""+FormularioPrincipal.precio3+ "\n");
		
		FormularioPrincipal.contenido3=Double.parseDouble(txtS2.getText());
		txtS2.setText(FormularioPrincipal.contenido3+ "\n");
		
		FormularioPrincipal.año3=Integer.parseInt(txtS3.getText());
		txtS3.setText(FormularioPrincipal.año3 + "\n");		
		
		FormularioPrincipal.casa3=(txtS4.getText());
		txtS4.setText(FormularioPrincipal.casa3 + "\n");
		
		}		
		break;
			
		
		default:
		{
			FormularioPrincipal.precio4=Double.parseDouble(txtS1.getText());
			txtS1.setText(""+FormularioPrincipal.precio4);
			
			FormularioPrincipal.contenido4=Double.parseDouble(txtS2.getText());
			txtS2.setText(""+FormularioPrincipal.contenido4);
			
			FormularioPrincipal.año4=Integer.parseInt(txtS3.getText());
			txtS3.setText(FormularioPrincipal.año4 + "\n");		
			
			FormularioPrincipal.casa4=(txtS4.getText());
			txtS4.setText(FormularioPrincipal.casa4 + "\n");}		
	
		break;
		
		
		}}}