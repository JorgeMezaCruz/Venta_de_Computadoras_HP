package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class DialogoConsultar extends JDialog implements ActionListener, ItemListener {

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
	private JTextArea txtS1;
	private JTextArea txtS2;
	private JTextArea txtS3;
	private JTextArea txtS4;
	@SuppressWarnings("rawtypes")
	private JComboBox cboNombre;

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
	public DialogoConsultar() {
		setForeground(new Color(255, 0, 0));
		setTitle("Consultar Computadora\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoCantOptima.class.getResource("/Imagenes/consulta.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoDescuento.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.setBounds(282, 154, 142, 49);
		contentPanel.add(btnCerrar);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 31, 46, 14);
		contentPanel.add(lblNombre);
		
		lblCasa = new JLabel("Procesador ");
		lblCasa.setBounds(32, 188, 136, 14);
		contentPanel.add(lblCasa);
		
		lblAoDeLanzamiento = new JLabel("A\u00F1o de Lanzamiento");
		lblAoDeLanzamiento.setBounds(32, 154, 118, 14);
		contentPanel.add(lblAoDeLanzamiento);
		
		lblContenidoml = new JLabel("Capacidad (GB)");
		lblContenidoml.setBounds(31, 112, 107, 14);
		contentPanel.add(lblContenidoml);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(32, 73, 70, 14);
		contentPanel.add(lblPrecios);
		
		txtS1 = new JTextArea();
		txtS1.setToolTipText("\r\n\r\n");
		txtS1.setBackground(Color.LIGHT_GRAY);
		txtS1.setEditable(false);
		txtS1.setBounds(167, 68, 99, 23);
		contentPanel.add(txtS1);
		
		txtS2 = new JTextArea();
		txtS2.setBackground(Color.LIGHT_GRAY);
		txtS2.setEditable(false);
		txtS2.setBounds(167, 107, 99, 23);
		contentPanel.add(txtS2);
		
		txtS3 = new JTextArea();
		txtS3.setBackground(Color.LIGHT_GRAY);
		txtS3.setEditable(false);
		txtS3.setBounds(167, 149, 99, 23);
		contentPanel.add(txtS3);
		
		txtS4 = new JTextArea();
		txtS4.setBackground(Color.LIGHT_GRAY);
		txtS4.setEditable(false);
		txtS4.setBounds(167, 188, 99, 23);
		contentPanel.add(txtS4);
		
		
		cboNombre = new JComboBox();
		cboNombre.setBackground(SystemColor.textHighlight);
		cboNombre.addItemListener(this);
		cboNombre.addActionListener(this);
		cboNombre.setModel(new DefaultComboBoxModel(new String[] {"Portatil HP ZBook ", "Portatil HP ENVY", "Portatil HP EliteBook ", "Portatil HP Pavilion ", "Portatil HP ProBook"}));
		cboNombre.setSelectedIndex(1);
		cboNombre.setBounds(167, 25, 150, 27);
		contentPanel.add(cboNombre);
		cboNombre.setSelectedItem("Portatil HP ENVY");
		
			
		
		
	}
	public void actionPerformed(ActionEvent e) {
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
		int nombre,año;
		double precio,contenido;
		String casa;
		
		//METODOS
		nombre = determinarPerfume();
		año= determinarAño(nombre);
		casa= determinarCasa(nombre);
		precio= determinarPrecio(nombre);
		contenido= determinarContenido(nombre);
		mostrarResultados (año,casa,precio,contenido);
					
}	
	 void mostrarResultados(int año, String casa, double precio, double contenido) {
		 txtS1.setText(precio +"");
		 txtS2.setText(contenido+"");
		 txtS3.setText(""+año);
		 txtS4.setText(""+casa);
		 
	}

	//Metodo Precio
	double determinarPrecio(int nombre) {
		switch (nombre){
		case 0:
			return FormularioPrincipal.precio0;
		
		case 1:
			return FormularioPrincipal.precio1;
		
		
		case 2:
			return FormularioPrincipal.precio2;
		
			
		case 3:
			return FormularioPrincipal.precio3;
			
		
		default:
			return FormularioPrincipal.precio4;
		}
	}
	//Metodo Determinar Contenido
	double determinarContenido(int nombre) {
		switch (nombre){
		case 0:
			return FormularioPrincipal.contenido0;
		case 1:
			return FormularioPrincipal.contenido1;
		case 2:
			return FormularioPrincipal.contenido2;
		case 3:
			return FormularioPrincipal.contenido3;
		default:
			return FormularioPrincipal.contenido4;
		}

	}
	//Metodo Determinar Año
	int determinarAño(int nombre) {
		switch (nombre){
		case 0:
			return FormularioPrincipal.año0;
		case 1:
			return FormularioPrincipal.año1;
		case 2:
			return FormularioPrincipal.año2;
		case 3:
			return FormularioPrincipal.año3;
		default:
			return FormularioPrincipal.año4;
		}
	}
	//Metodo Determinar Perfume
	int determinarPerfume() {
		return cboNombre.getSelectedIndex();
	} 
	
	//Metodo Determinar Casa
	String determinarCasa(int nombre) {
		switch (nombre){
		 case 0:
			 return FormularioPrincipal.casa0; 
		 case 1:
			 return FormularioPrincipal.casa1;
		 case 2:
			 return FormularioPrincipal.casa2;
		 case 3:
			 return FormularioPrincipal.casa3;
		default:
			 return FormularioPrincipal.casa4;
		 
		 
				 
	 }
		


	 
	
}
}