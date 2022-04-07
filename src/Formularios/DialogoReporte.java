package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DialogoReporte extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoDeReporte;
	private JComboBox<?> cboTipo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JButton btnGenerar;
	
	
	public static int tipo;
	public static int CantMayor,CantMenor;
	private JTextArea txtS;
	
	
		// Promedios, Maximos y Minimos
	 	public static double promPrecio,PrecioMin,PrecioMax,PrecAcu;
	 	public static double promAlto,AltoMin,AltoMax,AlAcu;
	 	public static double promAncho,AnchoMin,AnchoMax,AnAcu;
	 	public static double promFondo,FondoMin,FondoMax,FonAcu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoReporte dialog = new DialogoReporte();
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
	public DialogoReporte() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoReporte.class.getResource("/Imagenes/reporte.png")));
		setTitle("Generar Reporte");
		setBounds(100, 100, 646, 661);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de reporte :");
		lblTipoDeReporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeReporte.setBounds(33, 27, 118, 14);
		contentPanel.add(lblTipoDeReporte);
		
		cboTipo = new JComboBox();
		cboTipo.addActionListener(this);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Ventas Por Computadora", "Computadoras con venta \u00F3ptima", "Computadoras con precios menores al precio promedio", "Computadoras con precios mayores al precio promedio", "Precios promedio, mayor y menor"}));
		cboTipo.setBounds(163, 25, 306, 20);
		contentPanel.add(cboTipo);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DialogoReporte.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.setBounds(371, 545, 125, 43);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 80, 571, 434);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setViewportView(txtS);
		
		btnGenerar = new JButton("  Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setIcon(new ImageIcon(DialogoReporte.class.getResource("/Imagenes/reporte.png")));
		btnGenerar.setBounds(140, 545, 125, 43);
		contentPanel.add(btnGenerar);
		
		PromPrecios();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
		if (arg0.getSource() == cboTipo) {
			actionPerformedComboBox(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(arg0);
		}
		
	}
	
	void PromPrecios() {
		promPrecio = (FormularioPrincipal.precio0+FormularioPrincipal.precio1+FormularioPrincipal.precio2+FormularioPrincipal.precio3+FormularioPrincipal.precio4)/5;
		
		if(FormularioPrincipal.precio0>FormularioPrincipal.precio1){
			PrecioMax=FormularioPrincipal.precio0;
			PrecioMin=FormularioPrincipal.precio1;}
		else {PrecioMax=FormularioPrincipal.precio1;
			  PrecioMin=FormularioPrincipal.precio0;}
		if(FormularioPrincipal.precio2>PrecioMax) {
			PrecAcu=PrecioMax;
			PrecioMax=FormularioPrincipal.precio2;}
		if(PrecioMin>FormularioPrincipal.precio2) {
			PrecioMin=FormularioPrincipal.precio2;}
		if(FormularioPrincipal.precio3>PrecioMax) {
			PrecAcu=PrecioMax;
			PrecioMax=FormularioPrincipal.precio3;}
		if(PrecioMin>FormularioPrincipal.precio3) {
			PrecioMin=FormularioPrincipal.precio3;}
		if(FormularioPrincipal.precio4>PrecioMax) {
			PrecAcu=PrecioMax;
			PrecioMax=FormularioPrincipal.precio4;}
		if(PrecioMin>FormularioPrincipal.precio4) {
			PrecioMin=FormularioPrincipal.precio4;}
	}
	
	protected void actionPerformedbtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedComboBox(ActionEvent arg0) {
		btnGenerar.setEnabled(true);
		CantMayor=0;
		CantMenor=0;
	}
	int Codigo() {
		return cboTipo.getSelectedIndex();
	}

	void Mostrar(int cod) {
		switch(cod) {
			case 0: txtS.setText("\n   Ventas por Computadoras" + 
								"\n\n   Código			:  " + FormularioPrincipal.codigo0 + 
								"\n   Modelo			:  " + FormularioPrincipal.nombre0 +
								"\n   Cantidad total de ventas		:  " + DialogoVender.contV0 + 
								"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV0 + 
								"\n   Importe total acumulado		:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SPrecio0) + 
								
								
								"\n\n   Código			:  " + FormularioPrincipal.codigo1 + 
								"\n   Modelo			:  " + FormularioPrincipal.nombre1 +
								"\n   Cantidad total de ventas		:  " + DialogoVender.contV1 + 
								"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV1 + 
								"\n   Importe total acumulado		:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SPrecio1) +
								
								
								"\n\n   Código			:  " + FormularioPrincipal.codigo2 + 
								"\n   Modelo			:  " + FormularioPrincipal.nombre2 +
								"\n   Cantidad total de ventas		:  " + DialogoVender.contV2 + 
								"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV2 + 
								"\n   Importe total acumulado		:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SPrecio2) + 
								
								
								"\n\n   Código			:  " + FormularioPrincipal.codigo3 + 
								"\n   Modelo			:  " + FormularioPrincipal.nombre3 +
								"\n   Cantidad total de ventas		:  " + DialogoVender.contV3 + 
								"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV3 + 
								"\n   Importe total acumulado		:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SPrecio3) + 
								
								
								"\n\n   Código			:  " + FormularioPrincipal.codigo4 + 
								"\n   Modelo			:  " + FormularioPrincipal.nombre4 +
								"\n   Cantidad total de ventas		:  " + DialogoVender.contV4 + 
								"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV4 + 
								"\n   Importe total acumulado		:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SPrecio4) + 
								
								
								"\n\n   Importe total acumulado General	:  " +"S/. "+ FormularioPrincipal.df(DialogoVender.SumaImportes));txtS.setCaretPosition(0);;break;
								
								
			case 1:	txtS.setText("\n   Computadoras con Venta optima");txtS.setCaretPosition(0);
				if(DialogoVender.cantV0>=FormularioPrincipal.cantidadOptima) {
					txtS.append(
							"\n\n   Código			:  " + FormularioPrincipal.codigo0 + 
							"\n   Modelo			:  " + FormularioPrincipal.nombre0 +
							"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV0);}
				else {txtS.append(
						"\n\n   Código			:  " + FormularioPrincipal.codigo0 + 
						"\n   Modelo			:  " + FormularioPrincipal.nombre0 +
						"\n   Cantidad total de Computadoras Vendidas	:  " + "Ninguna Venta con cantidad optima");}
							
				
				if(DialogoVender.cantV1>=FormularioPrincipal.cantidadOptima) {	
					txtS.append(
							"\n\n   Código			:  " + FormularioPrincipal.codigo1 + 
							"\n   Modelo			:  " + FormularioPrincipal.nombre1 +
							"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV1);}
				else {txtS.append(
						"\n\n   Código			:  " + FormularioPrincipal.codigo1 + 
						"\n   Modelo			:  " + FormularioPrincipal.nombre1 +
						"\n   Cantidad total de Computadoras Vendidas	:  " + "Ninguna Venta con cantidad optima");}
							
				
				if(DialogoVender.cantV2>=FormularioPrincipal.cantidadOptima) {	
					txtS.append(
							"\n\n   Código			:  " + FormularioPrincipal.codigo2 + 
							"\n   Modelo			:  " + FormularioPrincipal.nombre2 +
							"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV2); }
				else {txtS.append(
						"\n\n   Código			:  " + FormularioPrincipal.codigo2 + 
						"\n   Modelo			:  " + FormularioPrincipal.nombre2 +
						"\n   Cantidad total de Computadoras Vendidas	:  " + "Ninguna Venta con cantidad optima");}

				
				if(DialogoVender.cantV3>=FormularioPrincipal.cantidadOptima) {	
					txtS.append(
							"\n\n   Código			:  " + FormularioPrincipal.codigo3 + 
							"\n   Modelo			:  " + FormularioPrincipal.nombre3 +
							"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV3);}
				else {txtS.append(
						"\n\n   Código			:  " + FormularioPrincipal.codigo3 + 
						"\n   Modelo			:  " + FormularioPrincipal.nombre3 +
						"\n   Cantidad total de Computadoras Vendidas	:  " + "Ninguna Venta con cantidad optima");}
							
				
				if(DialogoVender.cantV4>=FormularioPrincipal.cantidadOptima) {	
					txtS.append(
							"\n\n   Código			:  " + FormularioPrincipal.codigo4 + 
							"\n   Modelo			:  " + FormularioPrincipal.nombre4 +
							"\n   Cantidad total de Computadoras Vendidas	:  " + DialogoVender.cantV4);}
				else {txtS.append(
						"\n\n   Código			:  " + FormularioPrincipal.codigo4 + 
						"\n   Modelo			:  " + FormularioPrincipal.nombre4 +
						"\n   Cantidad total de Computadoras Vendidas	:  " + "Ninguna Venta con cantidad optima");};break;
							
							
			case 2: txtS.setText("\n   Computadoras con precios menores al precio promedio");
				if(FormularioPrincipal.precio0<=promPrecio) {
					CantMenor++;
				txtS.append(
						"\n\n   Modelo	:  " + FormularioPrincipal.nombre0 +
						"\n   Precio	:  " + FormularioPrincipal.precio0);}
				
				
				if(FormularioPrincipal.precio1<=promPrecio) {
					CantMenor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre1 +
							"\n   Precio	:  " + FormularioPrincipal.precio1);}
				
				
				if(FormularioPrincipal.precio2<=promPrecio) {
					CantMenor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre2 +
							"\n   Precio	:  " + FormularioPrincipal.precio2);}
				
				
				if(FormularioPrincipal.precio3<=promPrecio) {
					CantMenor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre3 +
							"\n   Precio	:  " + FormularioPrincipal.precio3);}
				
				
				if(FormularioPrincipal.precio4<=promPrecio) {
					CantMenor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre4 +
							"\n   Precio	:  " + FormularioPrincipal.precio4);}
				
				
					txtS.append("\n\n   Precio Promedio	:  " + promPrecio);
					txtS.append("\n   Cantidad de Computadoras	:  " + CantMenor);txtS.setCaretPosition(0);break;
							
			
			case 3: txtS.setText("\n   Computadoras con precios mayores al precio promedio");
				if(FormularioPrincipal.precio0>=promPrecio) {
					CantMayor++;
					txtS.append(
						"\n\n   Modelo	:  " + FormularioPrincipal.nombre0 +
						"\n   Precio	:  " + FormularioPrincipal.precio0);}
				
				
				if(FormularioPrincipal.precio1>=promPrecio) {
					CantMayor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre1 +
							"\n   Precio	:  " + FormularioPrincipal.precio1);}
				
				
				if(FormularioPrincipal.precio2>=promPrecio) {
					CantMayor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre2 +
							"\n   Precio	:  " + FormularioPrincipal.precio2);}
				
				
				if(FormularioPrincipal.precio3>=promPrecio) {
					CantMayor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre3 +
							"\n   Precio	:  " + FormularioPrincipal.precio3);}
				
				
				if(FormularioPrincipal.precio4>=promPrecio) {
					CantMayor++;
					txtS.append(
							"\n\n   Modelo	:  " + FormularioPrincipal.nombre4 +
							"\n   Precio	:  " + FormularioPrincipal.precio4);}
				

				txtS.append("\n\n   Precio promedio	:  " + promPrecio);
				txtS.append("\n   Cantidad de Computadoras	:  " + CantMayor);txtS.setCaretPosition(0);break;
				
				
			case 4: txtS.setText("\n   Promedios máximos y mínimos" + 
								"\n\n   Precio promedio	:  " + "S/. " + FormularioPrincipal.df(promPrecio) + 
								"\n   Precio máximo	:  " + "S/. " + FormularioPrincipal.df(PrecioMax) +
								"\n   Precio mínimo	:  " + "S/. " + FormularioPrincipal.df(PrecioMin));} 
																												
				txtS.setCaretPosition(0);;
					}
	
	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		
		int cod;
		
		cod = Codigo();
		Mostrar(cod);
		btnGenerar.setEnabled(false);

		
		
	}
}
