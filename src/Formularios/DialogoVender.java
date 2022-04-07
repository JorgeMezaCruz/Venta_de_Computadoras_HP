package Formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


public class DialogoVender extends JDialog implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblPrecioS;
	private JLabel lblCantidadDeMaletas;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox<?> cboCodigo;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JLabel lblCantMaletas;
	private JTextField txtEfectivo;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JButton btnResetearNumeroCliente;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;
	private JTextArea txtS2;
	private JLabel lblCodigoBoleta;
	private JLabel lblStock;
	private JTextField txtStockProd;
	private JButton btnGuardarBoleta;
	
	
	
	//Variables Globales
	public static double precio,SPrecio0,SPrecio1,SPrecio2,SPrecio3,SPrecio4,SumaImportes;
	public static String modelo;
	public static int cont,contV0,contV1,contV2,contV3,contV4,cantV0,cantV1,cantV2,cantV3,cantV4,stock;


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
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
	public DialogoVender() {
		setResizable(false);
		setTitle("Vender");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoVender.class.getResource("/Imagenes/vender.png")));
		setModal(true);
		setBounds(100, 100, 1174, 670);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigoBoleta = new JLabel("");
		lblCodigoBoleta.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/codboleta.png")));
		lblCodigoBoleta.setBounds(722, 0, 446, 559);
		lblCodigoBoleta.setVisible(false);
		contentPanel.add(lblCodigoBoleta);
		
		lblCodigo = new JLabel("Modelo :");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(20, 11, 154, 20);
		contentPanel.add(lblCodigo);
		
		lblPrecioS = new JLabel("Precio (S/). :");
		lblPrecioS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecioS.setBounds(20, 74, 154, 20);
		contentPanel.add(lblPrecioS);
		
		lblCantidadDeMaletas = new JLabel("Cantidad de Computadoras :");
		lblCantidadDeMaletas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidadDeMaletas.setBounds(20, 108, 154, 20);
		contentPanel.add(lblCantidadDeMaletas);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(197, 75, 131, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setBounds(197, 109, 131, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboCodigo = new JComboBox();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"Portatil HP ZBook ", "Portatil HP ENVY", "Portatil HP EliteBook ", "Portatil HP Pavilion ", "Portatil HP ProBook"}));
		cboCodigo.setBounds(164, 12, 164, 20);
		contentPanel.add(cboCodigo);
		
		btnVender = new JButton("  Vender");
		btnVender.addMouseListener(this);
		btnVender.setEnabled(false);
		btnVender.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/vender.png")));
		btnVender.addActionListener(this);
		btnVender.setBounds(561, 11, 141, 43);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("  Cerrar");
		btnCerrar.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(561, 60, 141, 43);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 188, 682, 386);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.BOLD, 17));
		scrollPane.setViewportView(txtS);
	
		

		
		lblCantMaletas = new JLabel("Efectivo del Cliente :");
		lblCantMaletas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantMaletas.setBounds(20, 137, 154, 20);
		contentPanel.add(lblCantMaletas);
		
		txtEfectivo = new JTextField();
		txtEfectivo.addKeyListener(this);
		txtEfectivo.setEnabled(false);
		txtEfectivo.setColumns(10);
		txtEfectivo.setBounds(197, 138, 131, 20);
		contentPanel.add(txtEfectivo);
		
		btnProcesar = new JButton("  Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.addMouseListener(this);
		btnProcesar.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/consulta.png")));
		btnProcesar.setBounds(394, 11, 141, 43);
		contentPanel.add(btnProcesar);
		
		btnBorrar = new JButton("  Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/modificar.png")));
		btnBorrar.setBounds(394, 60, 141, 43);
		contentPanel.add(btnBorrar);
		
		btnResetearNumeroCliente = new JButton("  Resetear numero de cliente");
		btnResetearNumeroCliente.addActionListener(this);
		btnResetearNumeroCliente.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/resetCli.png")));
		btnResetearNumeroCliente.setBounds(418, 114, 264, 43);
		contentPanel.add(btnResetearNumeroCliente);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(730, 11, 406, 563);
		contentPanel.add(scrollPane_1);
		
		txtS2 = new JTextArea();
		txtS2.setEditable(false);
		txtS2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane_1.setViewportView(txtS2);
		
		lblStock = new JLabel("Stock del Producto :");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStock.setBounds(20, 47, 154, 20);
		contentPanel.add(lblStock);
		
		txtStockProd = new JTextField();
		txtStockProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtStockProd.setEditable(false);
		txtStockProd.setColumns(10);
		txtStockProd.setBounds(197, 44, 131, 20);
		contentPanel.add(txtStockProd);
		
		
		
		txtPrecio.setText("" + FormularioPrincipal.precio0);
		txtStockProd.setText(""+FormularioPrincipal.stock0);
		
		btnGuardarBoleta = new JButton("  Guardar Boleta");
		btnGuardarBoleta.addActionListener(this);
		btnGuardarBoleta.setIcon(new ImageIcon(DialogoVender.class.getResource("/Imagenes/guardar.png")));
		btnGuardarBoleta.setBounds(853, 587, 172, 43);
		btnGuardarBoleta.setEnabled(false);
		contentPanel.add(btnGuardarBoleta);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarBoleta) {
			actionPerformedBtnGuardarBoleta(arg0);
		}
		if (arg0.getSource() == btnResetearNumeroCliente) {
			actionPerformedBtnResetearNumeroCliente(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == cboCodigo) {
			actionPerformedCboCodigo(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}

	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		
		dispose();
	}
	int Codigo() {
		return cboCodigo.getSelectedIndex();
	}
	String MostrarCodigo() {
		return String.valueOf(cboCodigo.getSelectedItem());
	}
	int Cantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	void CodigoPrecio(int codigo, String mostrarcod) {
		switch (mostrarcod) {
			case "Portatil HP ZBook" : mostrarcod = FormularioPrincipal.codigo0 ;break;
			case "Portatil HP ENVY" : mostrarcod = FormularioPrincipal.codigo1 ;break;
			case "Portatil HP EliteBook" : mostrarcod = FormularioPrincipal.codigo2 ;break;
			case "Portatil HP Pavilion" : mostrarcod = FormularioPrincipal.codigo3 ;break;
			case "Portatil HP ProBook" : mostrarcod = FormularioPrincipal.codigo4 ;break;
	}
		switch (codigo) {
			case 0 : txtPrecio.setText("" + FormularioPrincipal.precio0);txtStockProd.setText(""+ FormularioPrincipal.stock0);;break;
			case 1 : txtPrecio.setText("" + FormularioPrincipal.precio1);txtStockProd.setText(""+ FormularioPrincipal.stock1);break;
			case 2 : txtPrecio.setText("" + FormularioPrincipal.precio2);txtStockProd.setText(""+ FormularioPrincipal.stock2);break;
			case 3 : txtPrecio.setText("" + FormularioPrincipal.precio3);txtStockProd.setText(""+ FormularioPrincipal.stock3);break;
			case 4 : txtPrecio.setText("" + FormularioPrincipal.precio4);txtStockProd.setText(""+ FormularioPrincipal.stock4);break;
	}
		}
		
	
	void Precio(int codigo) {
		
		switch (codigo) {
			case 0 : precio = FormularioPrincipal.precio0; modelo = FormularioPrincipal.nombre0;stock = FormularioPrincipal.stock0 ;break;
			case 1 : precio = FormularioPrincipal.precio1; modelo = FormularioPrincipal.nombre1;stock = FormularioPrincipal.stock1 ;break;
			case 2 : precio = FormularioPrincipal.precio2; modelo = FormularioPrincipal.nombre2;stock = FormularioPrincipal.stock2 ;break;
			case 3 : precio = FormularioPrincipal.precio3; modelo = FormularioPrincipal.nombre3;stock = FormularioPrincipal.stock3 ;break;
			case 4 : precio = FormularioPrincipal.precio4; modelo = FormularioPrincipal.nombre4;stock = FormularioPrincipal.stock4 ;break;
	}
	}
	void Stock(int codigo,int cantidad) {
		switch (codigo) {
			case 0 : stock-=cantidad;FormularioPrincipal.stock0=stock ;break;
			case 1 : stock-=cantidad;FormularioPrincipal.stock1=stock ;break;
			case 2 : stock-=cantidad;FormularioPrincipal.stock2=stock ;break;
			case 3 : stock-=cantidad;FormularioPrincipal.stock3=stock ;break;
			case 4 : stock-=cantidad;FormularioPrincipal.stock4=stock ;break;}
	}
	double ImpCompra(int cantidad) {
		return precio*cantidad;
	}
	
	double Descuento(int cantidad, double IC) {
		
		if (cantidad >= 1 && cantidad <= 3)
			return (IC*FormularioPrincipal.porcentaje1)/100;
			
		else if (cantidad >= 4 && cantidad <= 5)
			return (IC*FormularioPrincipal.porcentaje2)/100;
		
		else if (cantidad >= 6 && cantidad <= 8)
			return (IC*FormularioPrincipal.porcentaje3)/100;
		
		else
			return (IC*FormularioPrincipal.porcentaje4)/100;
	}
	
	String Obsequio(int cantidad){
		if (cantidad >= FormularioPrincipal.cantidadMinima)
			return FormularioPrincipal.obsequio;
		else
			return "Ninguno";
	}
	
	double ImpPago(double IC, double dsc) {
		return IC-dsc;
	}
	
	String PremioSorpresa(){
		cont++;
		int num = FormularioPrincipal.numeroClientePremiado;
		if(cont == num) 
			return FormularioPrincipal.premioSorpresa;
		else return "Ninguno";
	}
	
	void PreBoleta(double IC, double dsc, double IP) {
		txtS.setText("\n    Visualizando " + 
				"\n\n    Stock del producto		:  " + stock + " unidades" +
				"\n    Importe de compra		:  " + "S/. " + FormularioPrincipal.df(IC) +
				"\n    Importe de descuento	:  " + "S/. " + FormularioPrincipal.df(dsc) +
				"\n    Importe a pagar		:  " + "S/. " + FormularioPrincipal.df(IP));
	}
	
	double Efectivo(){
		return Double.parseDouble(txtEfectivo.getText());
	}
	double Vuelto(double IP, double efectivo) {
		return efectivo-IP;
	}
	void Enabled() {
		btnVender.setEnabled(true);
		txtEfectivo.setEnabled(true);
	}
	
	void DatosCompra(int cantidad, String mostrarcod, String obs, double IC, double dsc, double IP, double vuelto, String premio){
		txtS.setText("\n    Datos de la Compra" + 
				"\n\n    Numero de Cliente		:  " + cont +   
				"\n    Modelo de Computadora		:  " + modelo +
				"\n    Precio de Computadora		:  " + "S/. " + FormularioPrincipal.df(precio) + 
				"\n    Cantidades adquiridas	:  " + cantidad +
				"\n    Importe de compra		:  " + "S/. " + FormularioPrincipal.df(IC) +
				"\n    Importe de descuento	:  " + "S/. " + FormularioPrincipal.df(dsc) +
				"\n    Importe a pagar		:  " + "S/. " + FormularioPrincipal.df(IP) + 
				"\n    Obsequio			:  " + obs + 
				"\n    Premio Sorpresa		:  " + premio +
				"\n    Vuelto			:  " + "S/. " + FormularioPrincipal.df(vuelto));
	}
	
	void Boleta(int cantidad, String mostrarcod, String obs, double IC, double dsc, double IP, double vuelto, String premio, double efectivo){
		txtS2.setText("\n    BOLETA ELECTRONICA" + 
				"\n\n   		 COMPUTADORAS HP  " + 
				"\n   		    Arequipa-Perú    " + 
				"\n\n\n    Numero de Cliente		:  " + cont +   
				"\n    Modelo de Computadora		:  " + modelo +
				"\n    Precio de Computadora		:  " + "S/. " + FormularioPrincipal.df(precio) + 
				"\n    Unidades adquiridas	:  " + cantidad +
				"\n    Obsequio			:  " + obs + 
				"\n    Premio Sorpresa		:  " + premio +
				"\n    ------------------------------------------"  +
				"\n    Sub Total			:  " + "S/. " + FormularioPrincipal.df(IC) +
				"\n    Importe de Descuento	:  " + "S/. " + FormularioPrincipal.df(dsc) +
				"\n    Importe Total		:  " + "S/. " + FormularioPrincipal.df(IP) + 
				"\n    ------------------------------------------"  +
				"\n    Efectivo			:  " + "S/. " + efectivo + 
				"\n    Vuelto			:  " + "S/. " + FormularioPrincipal.df(vuelto) +
				"\n    ------------------------------------------");
	}
	
	protected void actionPerformedCboCodigo(ActionEvent arg0) {
		
		int codigo = 0;
		String mostrarcod = null;
		
		codigo = Codigo();
		mostrarcod = MostrarCodigo();
		CodigoPrecio(codigo, mostrarcod);
		
	}
	void Disable() {
		btnVender.setEnabled(false);
		txtCantidad.setText(null);
		txtEfectivo.setText(null);
		txtEfectivo.setEnabled(false);
		cboCodigo.setSelectedIndex(0);
		
	}
	
	void ContVentas(int cantidad, int codigo, double IP) {
		switch(codigo) {
		case 0 : contV0++;cantV0+=cantidad;SPrecio0+=IP;break;
		case 1 : contV1++;cantV1+=cantidad;SPrecio1+=IP;break;
		case 2 : contV2++;cantV2+=cantidad;SPrecio2+=IP;break;
		case 3 : contV3++;cantV3+=cantidad;SPrecio3+=IP;break;
		case 4 : contV4++;cantV4+=cantidad;SPrecio4+=IP;break;
		}
	}
	public static double SumaImportes() {
		return SPrecio0+SPrecio1+SPrecio2+SPrecio3+SPrecio4;
	}
	
	
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		
		int cantidad, codigo;
		String mostrarcod,obs,premio;
		double IC,dsc ,IP,vuelto,efectivo;
		
		
		try {cantidad = Cantidad();}
		catch (Exception e) {
			FormularioPrincipal.ValorMayorCero();
			txtCantidad.setText(null);
			txtCantidad.requestFocus();
			return;
		}
		codigo = Codigo();
		mostrarcod = MostrarCodigo();
		if (stock>0) {
		IC = ImpCompra(cantidad);
		dsc = Descuento(cantidad, IC);
		IP=ImpPago(IC, dsc);
		obs = Obsequio(cantidad);
		try {efectivo = Efectivo();}
		catch (Exception e) {
			FormularioPrincipal.ValorMayorCero();
			txtEfectivo.setText(null);
			txtEfectivo.requestFocus();
			return;
		}
		if(efectivo>IP && txtCantidad.getText().length()!=0) {
		ContVentas(cantidad, codigo, IP);
		SumaImportes=SumaImportes();
		premio=PremioSorpresa();
		vuelto = Vuelto(IP, efectivo);
		DatosCompra(cantidad, mostrarcod, obs, IC, dsc, IP, vuelto, premio);
		Boleta(cantidad, mostrarcod, obs, IC, dsc, IP, vuelto, premio, efectivo);
		lblCodigoBoleta.setVisible(true);
		Stock(codigo, cantidad);
		FormularioPrincipal.Mensaje();
		btnGuardarBoleta.setEnabled(true);
		Disable();
		}else {FormularioPrincipal.Efectivo();
		txtEfectivo.setText(null);}}
		else {FormularioPrincipal.StockAgotado();}
	
	}
	

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		
		int cantidad, codigo;
		double dsc,IC,IP;
		
		
		
		txtS2.setText(null);
		lblCodigoBoleta.setVisible(false);
		codigo = Codigo();
		try {
		cantidad = Cantidad();}
		catch (Exception e) {
			FormularioPrincipal.ValorMayorCero();
			txtCantidad.setText(null);
			txtCantidad.requestFocus();
			return;
		}
		
		if(cantidad>0) {
		Precio(codigo);
		IC=ImpCompra(cantidad);
		if(stock==0) {
			FormularioPrincipal.StockAgotado();txtCantidad.setText(null);return;}else{Enabled();}
		dsc = Descuento(cantidad, IC);
		IP=ImpPago(IC, dsc);
		if(cantidad<=stock) {
		PreBoleta(IC, dsc, IP);}else {FormularioPrincipal.Stock();Disable();
		txtCantidad.setText(null);
		txtCantidad.requestFocus();return;}
		}else {FormularioPrincipal.ValorMayorCero();
		txtCantidad.setText(null);
		txtCantidad.requestFocus();}
	}


	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtEfectivo.setText(null);
		txtS.setText(null);
		txtPrecio.setText("124.9");
		cboCodigo.setSelectedIndex(0);
		btnVender.setEnabled(false);
		txtEfectivo.setEnabled(false);
		txtS2.setText(null);
		lblCodigoBoleta.setVisible(false);
		btnGuardarBoleta.setEnabled(false);
	}
	protected void actionPerformedBtnResetearNumeroCliente(ActionEvent arg0) {
		FormularioPrincipal.Reset();
	}
	protected void actionPerformedBtnGuardarBoleta(ActionEvent arg0) {
		
		Document document = new Document();
		try {
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\boleta.pdf"));
		    document.open();
		    PdfContentByte contentByte = writer.getDirectContent();
		    PdfTemplate template = contentByte.createTemplate(500, 500);
		    @SuppressWarnings("deprecation")
			Graphics2D g2 = template.createGraphics(500, 500);
		    txtS2.print(g2);
		    lblCodigoBoleta.print(g2);
		    g2.dispose();
		    contentByte.addTemplate(template, 30, 300);
		    FormularioPrincipal.BoletaGuardada();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		finally{
		    if(document.isOpen()){
		        document.close();
		    }
	}
	}

	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtEfectivo) {
			keyTypedTxtEfectivo(arg0);
		}
		if (arg0.getSource() == txtCantidad) {
			keyTypedTxtCantidad(arg0);
		}
	}
	protected void keyTypedTxtCantidad(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		if(txtCantidad.getText().length()==8) {
			arg0.consume();
			FormularioPrincipal.Limite();}
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
		}
		
	}
	protected void keyTypedTxtEfectivo(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		if(txtCantidad.getText().length()==8) {
			arg0.consume();
			FormularioPrincipal.Limite();}
		if(Character.isLetter(key) || Character.isSpaceChar(key)) {
			arg0.consume();
			getToolkit().beep();
			FormularioPrincipal.Numeros();
			
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
