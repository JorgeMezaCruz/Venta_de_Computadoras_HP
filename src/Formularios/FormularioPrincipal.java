package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;


public class FormularioPrincipal extends JFrame implements ActionListener, MouseListener, MouseMotionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
    private JMenu mnArchivo;
    private JMenu mnMantenimiento;
    private JMenu mnVentas;
    private JMenu mnConfiguracin;
    private JMenu mnAyuda;
    private JMenuItem mntmSalir;
    private JMenuItem mntmConsultaMaleta;
    private JMenuItem mntmModificarMaleta;
    private JMenuItem mntmListarMaletas;
    private JMenuItem mntmVender;
    private JMenuItem mntmGenerarReportes;
    private JMenuItem mntmConfigurarDescuentos;
    private JMenuItem mntmConfigurarObsequio;
    private JMenuItem mntmCantidadOptimaDe;
    private JMenuItem mntmConfigurarPremioSorpresa;
    private JMenuItem mntmAcercaDeLa;
	Timer tm;
	int i = 0;
    

    	// Datos del primer modelo
 		public static String codigo0 = "MG1PL4";
 		public static String nombre0 = "Portátil HP ZBook ";	
 		public static double precio0 = 1035.0;
 		public static double contenido0 = 150;
 		public static int año0 = 2015;
 	 	public static String casa0 = "Intel Core i7"; 
 	 	public static int stock0 = 18;

 		// Datos del segundo modelo
 		public static String codigo1 = "F531M2";
 		public static String nombre1 = "Portátil HP ENVY";
 		public static double precio1 = 1390.0;
 		public static double contenido1 = 250.0;
 		public static int año1 = 2017; 
 	 	public static String casa1 = "Snapdragon";
 	 	public static int stock1 = 22;

 		// Datos del tercer modelo
 		public static String codigo2 = "CV31M1";
 		public static String nombre2 = "Portátil HP EliteBook";
 		public static double precio2 = 1562.0;
 		public static double contenido2 = 320.0;
 		public static int año2 = 2018;
 	 	public static String casa2 = "Intel Core i5"; 
 	 	public static int stock2 = 25;

 		// Datos del cuarto modelo
 		public static String codigo3 = "PU3F1L";
 		public static String nombre3 = "Portátil HP Pavilion";
 		public static double precio3 = 2510.0; 
 		public static double contenido3 = 750.5; 
 		public static int año3 = 2016; 
 	 	public static String casa3 = " AMD A6-3400M"; 
 	 	public static int stock3 = 24;

 		// Datos del quinto modelo
 		public static String codigo4 = "B1PX56";
 		public static String nombre4 = "Portátil HP ProBook";
 		public static double precio4 = 2210.0;
 		public static double contenido4 = 500.0; 
 		public static int año4 = 2018; //
 		public static String casa4 = " AMD FX";
 		public static int stock4 = 26;

 		// Porcentajes de descuento
 		public static double porcentaje1 = 4.0;
 		public static double porcentaje2 = 5.5;
 		public static double porcentaje3 = 7.0;
 		public static double porcentaje4 = 8.5;

 		// Cantidad óptima de perfumes vendidos
 		public static int cantidadOptima = 40;

 		// Cantidad mínima de perfumes adquiridos para obtener el obsequio
 		public static int cantidadMinima = 20;

 		// Obsequio por importe mínimo
 		public static String obsequio = "Unos Audifonos";

 		// Número de cliente que recibe el premio sorpresa
 		public static int numeroClientePremiado = 5;

 		// Premio sorpresa
 		public static String premioSorpresa = "Memoria USB";
 		private JLabel lblBienvenido;
 		private JLabel lblAdministrador;
 		private JLabel lblUser1;
 		private JLabel lblUser2;
 		private JMenuItem mntmConfigurarStock;
 		public static JLabel lblHora;
 		public static JLabel lblFecha;
 		private JLabel text;
 		
 		
 		
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal frame = new FormularioPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public FormularioPrincipal() {
		
		setTitle("COMPUTADORAS HP");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioPrincipal.class.getResource("/Imagenes/maletaicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 644);
		contentPane = new Fondo("");
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenido = new JLabel("Bienvenido : ");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBienvenido.setBounds(24, 11, 89, 14);
		contentPane.add(lblBienvenido);
		
		lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdministrador.setBounds(123, 11, 107, 14);
		lblAdministrador.setVisible(false);
		contentPane.add(lblAdministrador);
		
		lblUser1 = new JLabel("Usuario 1");
		lblUser1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser1.setBounds(123, 11, 107, 14);
		lblUser1.setVisible(false);
		contentPane.add(lblUser1);
		
		lblUser2 = new JLabel("Usuario 2");
		lblUser2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser2.setBounds(123, 11, 107, 14);
		lblUser2.setVisible(false);
		contentPane.add(lblUser2);
		
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora.setBounds(24, 54, 178, 14);
		contentPane.add(lblHora);
		
		lblFecha = new JLabel("");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(24, 79, 178, 14);
		contentPane.add(lblFecha);
		
		text = new JLabel("");
		text.setBounds(49, 206, 0, 0);
		contentPane.add(text);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnArchivo.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/archivo.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/salir.png")));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMantenimiento.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/mantenimiento2.png")));
		menuBar.add(mnMantenimiento);
		
		mntmConsultaMaleta = new JMenuItem("Consulta Computadora");
		mntmConsultaMaleta.addActionListener(this);
		mntmConsultaMaleta.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/consulta.png")));
		mnMantenimiento.add(mntmConsultaMaleta);
		
		mntmModificarMaleta = new JMenuItem("Modificar Computadora");
		mntmModificarMaleta.addActionListener(this);
		mntmModificarMaleta.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/modificar.png")));
		mnMantenimiento.add(mntmModificarMaleta);
		
		mntmListarMaletas = new JMenuItem("Listar Computadora");
		mntmListarMaletas.addActionListener(this);
		mntmListarMaletas.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/lista.png")));
		mnMantenimiento.add(mntmListarMaletas);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnVentas.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ventas.png")));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mntmVender.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/vender.png")));
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mntmGenerarReportes.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/reporte.png")));
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		mnConfiguracin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnConfiguracin.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/config.png")));
		menuBar.add(mnConfiguracin);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mntmConfigurarDescuentos.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/descuento.png")));
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequio = new JMenuItem("Configurar Obsequio");
		mntmConfigurarObsequio.addActionListener(this);
		mntmConfigurarObsequio.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/obsequio.png")));
		mnConfiguracin.add(mntmConfigurarObsequio);
		
		mntmCantidadOptimaDe = new JMenuItem("Cantidad Optima de Computadoras Vendidas");
		mntmCantidadOptimaDe.addActionListener(this);
		mntmCantidadOptimaDe.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/venta optima.png")));
		mnConfiguracin.add(mntmCantidadOptimaDe);
		
		mntmConfigurarPremioSorpresa = new JMenuItem("Configurar Premio Sorpresa");
		mntmConfigurarPremioSorpresa.addActionListener(this);
		mntmConfigurarPremioSorpresa.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/premio.png")));
		mnConfiguracin.add(mntmConfigurarPremioSorpresa);
		
		mntmConfigurarStock = new JMenuItem("Configurar Stock");
		mntmConfigurarStock.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/stock.png")));
		mntmConfigurarStock.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarStock);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnAyuda.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ayuda.png")));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeLa = new JMenuItem("Acerca de la Tienda");
		mntmAcercaDeLa.addActionListener(this);
		mntmAcercaDeLa.setIcon(new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/tienda.png")));
		mnAyuda.add(mntmAcercaDeLa);
		this.setLocationRelativeTo(null); 
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		tm = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				text.setText(Integer.toString(i));
				i++;
				if (i == 3) {
					
					Audio();
					
					
				}
			}
		});


		if(FormularioLogin.user.equals("Administrador")) {
			mnConfiguracin.setVisible(true);
			mntmModificarMaleta.setVisible(true);
			lblAdministrador.setVisible(true);}
		else if(FormularioLogin.user.equals("Usuario1")) {  mnConfiguracin.setVisible(false);
				mntmModificarMaleta.setVisible(false);lblUser1.setVisible(true);}
		else {  mnConfiguracin.setVisible(false);
		mntmModificarMaleta.setVisible(false);lblUser2.setVisible(true);}
		

		
		
	}
		
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmConfigurarStock) {
			actionPerformedMntmConfigurarStock(arg0);
		}
		if (arg0.getSource() == mntmConfigurarPremioSorpresa) {
			actionPerformedMntmConfigurarPremioSorpresa(arg0);
		}
		if (arg0.getSource() == mntmCantidadOptimaDe) {
			actionPerformedMntmCantidadOptimaDe(arg0);
		}
		if (arg0.getSource() == mntmConfigurarObsequio) {
			actionPerformedMntmConfigurarObsequio(arg0);
		}
		if (arg0.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(arg0);
		}
		if (arg0.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(arg0);
		}
		if (arg0.getSource() == mntmModificarMaleta) {
			actionPerformedMntmModificarMaleta(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmListarMaletas) {
			actionPerformedMntmListarMaletas(arg0);
		}
		if (arg0.getSource() == mntmConsultaMaleta) {
			actionPerformedMntmConsultaMaleta(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeLa) {
			actionPerformedMntmAcercaDeLa(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	public static void Mensaje() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ventas.png")); 
		JOptionPane.showMessageDialog(null,"Venta realizada Correctamente","Información de Venta",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Reset () {
		DialogoVender.cont=0;
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/resetCli.png")); 
		JOptionPane.showMessageDialog(null,"Número de cliente restablecido correctamente","Número de cliente restablecido",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Efectivo() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/ventaerror.png")); 
		JOptionPane.showMessageDialog(null,"El efectivo del cliente es menor al Importe a Pagar","Venta no procesada",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Stock() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/stock.png")); 
		JOptionPane.showMessageDialog(null,"La cantidad solicitada sobrepasa el Stock del producto","Cantidad no disponible",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void StockAgotado() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/stock.png")); 
		JOptionPane.showMessageDialog(null,"El Stock del producto seleccionado se ha agotado","Producto no disponible",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Letras() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/letra.png")); 
		JOptionPane.showMessageDialog(null,"Ingrese solo Letras","No ingresó un valor correcto",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Numeros() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/numero.png")); 
		JOptionPane.showMessageDialog(null,"Ingrese solo Números","No ingresó un valor correcto",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Limite() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/limite.png")); 
		JOptionPane.showMessageDialog(null,"Ingrese solo 8 caracteres","Sobrepasó el limite de caracteres",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void ValorMayorCero() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/alerta.png")); 
		JOptionPane.showMessageDialog(null,"Ingrese un numero mayor a cero","No ingresó un valor correcto",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void Guardado() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/guardar.png")); 
		JOptionPane.showMessageDialog(null,"Datos guardados correctamente","Información sobre guardado",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void NoGuardado() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/errorguardar.png")); 
		JOptionPane.showMessageDialog(null,"Error al guardar datos, Ingrese valores correctos","Información sobre guardado",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static void BoletaGuardada() {
		Icon ico = new ImageIcon(FormularioPrincipal.class.getResource("/Imagenes/guardar.png")); 
		JOptionPane.showMessageDialog(null,"Boleta guardada : C:\\boleta.pdf","Boleta Guardada",JOptionPane.INFORMATION_MESSAGE,ico);
	}
	public static String df(double num) {
		DecimalFormat de=new DecimalFormat("0.##");
		return de.format(num);
	}
	static void Audio() {
		
			//creamos un objeto de nuestra clase ReproducirMp3 -
			@SuppressWarnings("unused")
			Audio play=new Audio();
			//y solamente pasamos por parametro el nombre de nuestro archivo mp3 el cual esta dentro de nuestro proyecto -
			Formularios.Audio.main("bienvenido.mp3");
			
	}
	void Hora() {
		
		do {
		int hora,minuto,segundo;
		
		Calendar calendar = GregorianCalendar.getInstance();
		java.util.Date date = Calendar.getInstance().getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy");
		
		hora = calendar.get(Calendar.HOUR_OF_DAY);
		minuto = calendar.get(Calendar.MINUTE);
		segundo = calendar.get(Calendar.SECOND);
		
		lblHora.setText(hora + " : " + minuto + " : " + segundo);
		lblFecha.setText(sdf.format(date));
		} while (true);
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	
	public void mouseMoved(MouseEvent arg0) {
	}
	
	protected void mousePressedContentPane(MouseEvent arg0) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		DialogoSalir DS = new DialogoSalir();
		DS.setLocationRelativeTo(this);
		DS.setVisible(true);
	}
	protected void actionPerformedMntmAcercaDeLa(ActionEvent arg0) {
		
		DialogoAcercaTienda DAT = new DialogoAcercaTienda();
		DAT.setLocationRelativeTo(this);
		DAT.setVisible(true);
		
	}
	protected void actionPerformedMntmConsultaMaleta(ActionEvent arg0) {
		
		DialogoConsultar DC = new DialogoConsultar();
		DC.setLocationRelativeTo(this);
		DC.setVisible(true);
	}
	protected void actionPerformedMntmListarMaletas(ActionEvent arg0) {
		
		DialogoListar DL = new DialogoListar();
		DL.setLocationRelativeTo(this);
		DL.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		
		DialogoVender DV = new DialogoVender();
		DV.setLocationRelativeTo(this);
		DV.setVisible(true);
	}
	protected void actionPerformedMntmModificarMaleta(ActionEvent arg0) {
		
		DialogoModificar DM = new DialogoModificar();
		DM.setLocationRelativeTo(this);
		DM.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent arg0) {
		
		DialogoReporte DR = new DialogoReporte();
		DR.setLocationRelativeTo(this);
		DR.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent arg0) {
		
		DialogoDescuento DD = new DialogoDescuento();
		DD.setLocationRelativeTo(this);
		DD.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent arg0) {
		
		DialogoObsequio DO = new DialogoObsequio();
		DO.setLocationRelativeTo(this);
		DO.setVisible(true);
	}
	protected void actionPerformedMntmCantidadOptimaDe(ActionEvent arg0) {
		
		DialogoCantOptima DCO = new DialogoCantOptima();
		DCO.setLocationRelativeTo(this);
		DCO.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarPremioSorpresa(ActionEvent arg0) {
		
		DialogoPremio DP = new DialogoPremio();
		DP.setLocationRelativeTo(this);
		DP.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarStock(ActionEvent arg0) {
		
		DialogoStock DSK = new DialogoStock();
		DSK.setLocationRelativeTo(this);
		DSK.setVisible(true);
	}
}
