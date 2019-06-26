package dtm_aeb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VenMenuPrincipal extends JFrame implements ActionListener {

	private JMenuBar mbp;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
	private JMenuItem mi1, mi2, mi3, mi4, mi99;
	private JLabel label_logo;

	public VenMenuPrincipal() {

		setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("imagen/LOGO ALCALDIA AEB.png")).getImage());

		ImageIcon imagen_logo = new ImageIcon("imagen/LOGO-DTM01.png");
		label_logo = new JLabel(imagen_logo);

		label_logo.setSize(800,600);
		
		add(label_logo);

		mbp = new JMenuBar();
		setJMenuBar(mbp);
		
		menu1 = new JMenu("Registros");
		mbp.add(menu1);
		
		mi1= new JMenuItem("Actividad Económica");
		mi1.addActionListener(this);
		menu1.add(mi1);

		mi2 = new JMenuItem("Inmuebles Urbanos");
		mi2.addActionListener(this);
		menu1.add(mi2);

		mi3 = new JMenuItem("Patente Vehiculos");
		mi3.addActionListener(this);
		menu1.add(mi3);
		
		mi4 = new JMenuItem("Propaganda Comercial"); 
		mi4.addActionListener(this);
		menu1.add(mi4);

		menu2 = new JMenu("Movimientos");
		mbp.add(menu2);

		menu3 = new JMenu("Consultas");
		mbp.add(menu3);

		menu4 = new JMenu("Reportes");
		mbp.add(menu4);

		menu5 = new JMenu("Tabuladores");
		mbp.add(menu5);

		menu6 = new JMenu("Salir");
		mbp.add(menu6);

		mi99 = new JMenuItem("Salir"); 
		mi99.addActionListener(this);
		menu6.add(mi99);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==mi1) {

			VenRegActEco vrae = new VenRegActEco();
			vrae.setTitle("Registro de Contribuyente Actividad Económica");
			vrae.setBounds(0,0,640,450);
			vrae.setVisible(true);
			vrae.setLocationRelativeTo(null);

		}

		if (e.getSource()==mi99) {

			System.exit(0);
		}


	}
	

	public static void main (String asg[]) {

		VenMenuPrincipal vmp = new VenMenuPrincipal();
		vmp.setTitle("Sistema de Recaudación");
		vmp.setSize(800,600);
		vmp.setLocationRelativeTo(null);
		vmp.setExtendedState(MAXIMIZED_BOTH);
		vmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vmp.setVisible(true);

	}
}