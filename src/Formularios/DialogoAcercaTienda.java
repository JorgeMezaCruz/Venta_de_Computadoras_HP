package Formularios;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;

public class DialogoAcercaTienda extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblIntegrantes;
	private JButton btnCerrar;
	private JLabel lblImagen;
	private JList<?> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAcercaTienda dialog = new DialogoAcercaTienda();
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
	public DialogoAcercaTienda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoAcercaTienda.class.getResource("/Imagenes/tienda.png")));
		setTitle("Acerca de la Tienda");
		setModal(true);
		setBounds(100, 100, 450, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIntegrantes = new JLabel("Integrantes: ");
		lblIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntegrantes.setBounds(170, 115, 143, 31);
		contentPanel.add(lblIntegrantes);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnCerrar.setIcon(new ImageIcon(DialogoAcercaTienda.class.getResource("/Imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(170, 275, 120, 43);
		contentPanel.add(btnCerrar);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(DialogoAcercaTienda.class.getResource("/Imagenes/tiendaimg.png")));
		lblImagen.setBounds(159, 11, 148, 93);
		contentPanel.add(lblImagen);
		
		list = new JList();
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Arial", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"* Jorge Meza", "* Manuel Alvarez", "* Bryan Diaz", "* Andre Salinas", "* Micky Ancalla"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(170, 157, 156, 105);
		contentPanel.add(list);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
