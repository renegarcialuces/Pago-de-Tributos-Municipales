package dtm_aeb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class VenRegActEco extends JFrame implements ActionListener {
	
	private JButton boton1, boton2, boton3, boton4, boton5;
	private JTextField tf1_p1,tf2_p1, tf3_p1, tf4_p1,  tf6_p1, tf7_p1, tf8_p1;
	private JComboBox cb1_p1, cb2_p1;

	public VenRegActEco() {

	setIconImage(new ImageIcon(getClass().getResource("imagen/LOGO ALCALDIA AEB.png")).getImage());	

	JTabbedPane pestañas_reg = new JTabbedPane();
	
	// Pestaña Contribuyente ***
	JPanel panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel et1_p1 = new JLabel("Nº Expediente:");
		et1_p1.setBounds(10,10,100,20);
		panel1.add(et1_p1);		
		tf1_p1 = new JTextField();
		tf1_p1.setBounds(10,30,120,20);	
		panel1.add(tf1_p1);
		tf1_p1.setEnabled(false);
		
		JLabel et2_p1 = new JLabel("Denominación o Razón Social:");
		et2_p1.setBounds(140,10,300,20);
		panel1.add(et2_p1);		
		tf2_p1 = new JTextField();
		tf2_p1.setBounds(140,30,450,20);	
		panel1.add(tf2_p1);
		tf2_p1.setEnabled(false);
		
		JLabel et3_p1 = new JLabel("R.I.F Nº:");
		et3_p1.setBounds(10,50,100,20);
		panel1.add(et3_p1);		
		tf3_p1 = new JTextField();
		tf3_p1.setBounds(10,70,100,20);	
		panel1.add(tf3_p1);
		tf3_p1.setEnabled(false);
		
		JLabel et4_p1 = new JLabel("Dirección:");
		et4_p1.setBounds(120,50,100,20);
		panel1.add(et4_p1);		
		tf4_p1 = new JTextField();
		tf4_p1.setBounds(120,70,300,20);	
		panel1.add(tf4_p1);
		tf4_p1.setEnabled(false);
		
		JLabel et5_p1 = new JLabel("Parroquia:");
		et5_p1.setBounds(430,50,100,20);
		panel1.add(et5_p1);		
		cb1_p1 = new JComboBox();
		cb1_p1.setBounds(430,70,160,20);	
		panel1.add(cb1_p1);
		cb1_p1.setEnabled(false);
		
		cb1_p1.addItem("Mariño");
		cb1_p1.addItem("Rómunlo Gallegos");

		JLabel et6_p1 = new JLabel("Municipio:");
		et6_p1.setBounds(10,90,100,20);
		panel1.add(et6_p1);		
		tf6_p1 = new JTextField();
		tf6_p1.setText("Andrés Eloy Blanco");
		tf6_p1.setBounds(10,110,160,20);	
		panel1.add(tf6_p1);
		tf6_p1.setEnabled(false);
		
		JLabel et7_p1 = new JLabel("Estado:");
		et7_p1.setBounds(180,90,100,20);
		panel1.add(et7_p1);		
		tf7_p1 = new JTextField();
		tf7_p1.setText("Sucre");
		tf7_p1.setBounds(180,110,160,20);	
		panel1.add(tf7_p1);
		tf7_p1.setEnabled(false);
		

		JLabel et8_p1 = new JLabel("Cod. Ramo:");
		et8_p1.setBounds(350,90,100,20);
		panel1.add(et8_p1);		
		cb2_p1 = new JComboBox();
		cb2_p1.setBounds(350,110,120,20);	
		panel1.add(cb2_p1);
		cb2_p1.setEnabled(false);
		
		cb2_p1.addItem("1.1.");
		cb2_p1.addItem("1.2.");
		cb2_p1.addItem("1.3.");
		
		
		pestañas_reg.addTab("Contribuyente", panel1);	
	

	JPanel panel2 = new JPanel();
	JLabel et_p2 = new JLabel("Representante");
	panel2.add(et_p2);
	pestañas_reg.addTab("Representante", panel2);

	JPanel panel3 = new JPanel();
	JLabel et_p3 = new JLabel("Recaudos");
	panel3.add(et_p3);
	pestañas_reg.addTab("Recaudos", panel3);

	pestañas_reg.setBounds(10,10,600,350);
	getContentPane().add(pestañas_reg);
	setLayout(null);
	boton1 = new JButton("Agregar");	
	boton1.setBounds(105,370,80,20);
	boton1.addActionListener(this);
	add(boton1);
	
	boton2 = new JButton("Modificar");	
	boton2.setBounds(190,370,80,20);
	boton2.addActionListener(this);
	add(boton2);
	
	boton3 = new JButton("Eliminar");	
	boton3.setBounds(275,370,80,20);
	boton3.addActionListener(this);
	add(boton3);

	boton4 = new JButton("Buscar");	
	boton4.setBounds(365,370,80,20);
	boton4.addActionListener(this);
	add(boton4);
	
	boton5 = new JButton("Salir");	
	boton5.setBounds(455,370,80,20);
	boton5.addActionListener(this);
	add(boton5);
	
	
	mostrar();
	}




	public void actionPerformed (ActionEvent e) {


		if (e.getSource()==boton1){
			agregar();
		}
		
		if (e.getSource()==boton2){
			siguiente();
		}

	}
	
	
	public void mostrar() {
		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbaeb","root" ,"");
			Statement comando=conexion.createStatement();
			ResultSet registro = comando.executeQuery("select nombre from cliente");
	          if (registro.next()==true) {
				tf1_p1.setText(registro.getString("nombre"));
				tf2_p1.setText(registro.getString("nombre"));
				tf3_p1.setText(registro.getString("nombre"));
				tf4_p1.setText(registro.getString("nombre"));
				tf6_p1.setText(registro.getString("nombre"));
				tf7_p1.setText(registro.getString("nombre"));
				cb1_p1.setSelectedIndex(0);
				cb2_p1.setSelectedIndex(0);
	          
	          } else {
	        	  JOptionPane.showMessageDialog(null, "No existe un artículo con dicho código");
	          }
    	        conexion.close();
		
			} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

			}
	}
	
	public void siguiente() {
		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbaeb","root" ,"");
			Statement comando=conexion.createStatement();
			ResultSet registro = comando.executeQuery("select nombre from cliente");
	         registro.next();
				tf1_p1.setText(registro.getString("nombre"));
				tf2_p1.setText(registro.getString("nombre"));
				tf3_p1.setText(registro.getString("nombre"));
				tf4_p1.setText(registro.getString("nombre"));
				tf6_p1.setText(registro.getString("nombre"));
				tf7_p1.setText(registro.getString("nombre"));
				//cb1_p1.setSelectedIndex(0);
				//cb2_p1.setSelectedIndex(0);
		} catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, "No existe un artículo con dicho código");
		}

	}
	

	
	public void agregar() {
		
		tf1_p1.setEnabled(true);
		tf1_p1.setText("");
		tf1_p1.requestFocus();
		tf2_p1.setEnabled(true);
		tf2_p1.setText("");
		tf3_p1.setEnabled(true);
		tf3_p1.setText("");
		tf4_p1.setEnabled(true);
		tf4_p1.setText("");
		tf6_p1.setEnabled(true);
		tf6_p1.setText("");
		tf7_p1.setEnabled(true);
		tf7_p1.setText("");
		cb1_p1.setEnabled(true);
		cb2_p1.setEnabled(true);
		
		boton1.setEnabled(false);

	}

	public static void main (String asg[]) {

		VenRegActEco vrae = new VenRegActEco();
		vrae.setTitle("Registro de Contribuyente Actividad Económica");
		vrae.setBounds(0,0,640,450);
		vrae.setVisible(true);
		vrae.setLocationRelativeTo(null);

	}
}