/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoed;

/**
 *
 * @author Casa
 */

import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ProyectoED extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoED frame = new ProyectoED();
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
	public ProyectoED() {

		//Parametros asociados a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setToolTipText("Inserta la ruta del fichero de audio");
		textField.setBounds(52, 26, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSeleccionar = new JButton("Seleccionar...");
		btnSeleccionar.setBounds(288, 25, 109, 23);
		contentPane.add(btnSeleccionar);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(52, 76, 360, 156);

		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setBounds(52, 76, 360, 156);
		contentPane.add(scroll);

		btnSeleccionar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
                            //Creamos el objeto JFileChooser
                        JFileChooser fc=new JFileChooser();

                        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
                        int seleccion=fc.showOpenDialog(contentPane);

                        //Si el usuario, pincha en aceptar
                        if(seleccion==JFileChooser.APPROVE_OPTION){

                                //Seleccionamos el fichero
                                File fichero=fc.getSelectedFile();

                                //Ecribe la ruta del fichero seleccionado en el campo de texto
                                textField.setText(fichero.getAbsolutePath());

                                try{
                                    //1.Crear Conexion
                                    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaapp", "root", "");
                                    //2.Crear Statement
                                    Statement miStatement=miConexion.createStatement();
                                    //3.Ejecutar SQL
                                    PreparedStatement stm;
                                   stm=miConexion.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?)");
                                    System.out.println("conecto :o");
                                    stm.setInt(1,3);
                                    stm.setString(2, "Noob");
                                    stm.setString(3,"yiyiyi");
                                    stm.setInt(4, 15);
                                    stm.executeUpdate();
                                    }catch(Exception z){
                                      System.out.println("No conecta");
                                      z.printStackTrace();
                                    }
                                }
                        }
		});
                
	}
}
   
        
   
    

