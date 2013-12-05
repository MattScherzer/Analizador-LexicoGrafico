/**
 * @(#)AnalizadorLG.java
 *
 * Analizador Lexico Grafico
 * Proyecto de Teoria de la computacion
 * CUCEI 2013B
 *
 * @author Matt Scherzer
 * @version 1.00 2013/11/27
 */
 
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


import javax.swing.*;
import javax.imageio.ImageIO;
 
public class AnalizadorLG extends JFrame implements ActionListener
{
	
	JTextField txtInsertar, txtResultado, txtEstado;
	JButton btnAnalizar, btnBorrar, btnSalir, btnAutomata;
	JLabel lblAnalizar,lblEstado, lblResultado, lblAutomata;
	Icon icnAutomata;
	
	String strEstados = "0"; // cadena que imprime los estados por los que pasa la cadena al ser validada
	String strResultado = ""; // cadena que imprime el resultado de la cadena despues de ser validada
	
	boolean signo = false, punto = false, expresion_artimetica = false, reservada = false;
	
	AnalizarCasos analisis = new AnalizarCasos(); // inicializar clases
	
	public AnalizadorLG()
	{
		Visual();
	}
	
	public void Visual()
	{
		super.setTitle("Analizador Léxico-Gráfico");
		this.setBounds(450,150,350,380);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// LABEL
		lblAnalizar = new JLabel("INTRODUCE UNA CADENA:");
		lblAnalizar.setBounds(95,25,150,25);
		lblEstado = new JLabel("ESTADOS:");
		lblEstado.setBounds(145,95,150,25);
		lblResultado = new JLabel("RESULTADO:");
		lblResultado.setBounds(140,175,150,25);
		// TEXT FIELD
		txtInsertar = new JTextField();
		txtInsertar.setBounds(20,55,310,25);
		txtEstado = new JTextField();
		txtEstado.setBounds(20,120,310,25);
		txtResultado = new JTextField();
		txtResultado.setBounds(20,200,310,25);
		// BUTTONS
		btnAnalizar = new JButton("Analizar");
		btnAnalizar.setBounds(20,260,100,25);
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(125,260,100,25);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(230,260,100,25);	
		btnAutomata = new JButton("Mostrar Autómata");
		btnAutomata.setBounds(20,300,310,25);
		
		
		setLayout(null);
		
		// ADD LABEL
		this.add(lblAnalizar);
		this.add(lblEstado);
		this.add(lblResultado);
		// ADD TEXT FIELD
		this.add(txtInsertar);		
		this.add(txtEstado);
		this.add(txtResultado);
		// ADD BUTTONS
		this.add(btnAnalizar);
		this.add(btnBorrar);
		this.add(btnSalir);
		this.add(btnAutomata);

		// VISIBLE
		this.setVisible(true);

		// EDITABLE
		txtEstado.setEditable(false);
		txtResultado.setEditable(false);
		
		// TOOLTIP
		txtInsertar.setToolTipText("Ingresa la cadena a validar");
		txtEstado.setToolTipText("Estados por los que es validado");
		txtResultado.setToolTipText("Tipo de cadena ingresada");

		// ACTION LISTENER
		btnSalir.addActionListener(this);
		btnBorrar.addActionListener(this);
	    btnAnalizar.addActionListener(this);
	    btnAutomata.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		Object click=evt.getSource();
		
		if(btnAnalizar == click)
		{
			String cadena = txtInsertar.getText();
			Analizar(cadena);
		}
		if(btnBorrar == click)
		{
			txtInsertar.setText("");
			txtEstado.setText("");
			txtResultado.setText("");
			strEstados = "0";
		}
		if(btnSalir == click)
		{
			System.exit(0);
		}
		if(btnAutomata == click)
		{
			MostrarAutomata ma = new MostrarAutomata();
			ma.Visual();
		}
	} 
	
	public void Analizar(String cadena)
	{
		int i=0, estado=0, caso=0; //inicializar el validador de estados y el contador
		int tamanio = cadena.length(); // recibir longitud de cadena
		
		strEstados = "0";
		do
		{
			caso = estado;
			estado = analisis.Validar(cadena.charAt(i), caso, cadena);
			
			switch(estado)
			{
				case 1:
					strEstados = strEstados + ",1";
					if(expresion_artimetica == true)
					{
						strResultado = "EXPRESION ARITMÉTICA";
					}
					else
					{
						strResultado = "IDENTIFICADOR";
					}
				break;
				case 2:
					strEstados = strEstados + ",2";
					strResultado = "ENTERO";
				break;
				case 3:
					strEstados = strEstados + ",3";
					strResultado = "ENTERO";
				break;
				case 4:
					strEstados = strEstados + ",4";
					strResultado = "ENTERO";
				break;
				case 5:
					strEstados = strEstados + ",5";
					strResultado = "ENTERO";
				break;
				case 6:
					strEstados = strEstados + ",6";
					if(expresion_artimetica == true)
					{
						strResultado = "EXPRESIÓN ARITMETICA";
					}
					else if(signo == true)
					{
						strResultado = "ENTERO CON SIGNO";
					}
					else
					{
						strResultado = "ENTERO";
					}
				break;
				case 7:
					strEstados = strEstados + ",7";
					strResultado = "ERROR";
				break;
				case 8:
					strEstados = strEstados + ",8";
					strResultado = "ERROR";
				break;
				case 9:
					strEstados = strEstados + ",9";
					strResultado = "ERROR";
				break;
				case 10:
					strEstados = strEstados + ",10";
					strResultado = "HEXADECIMAL";
				break;
				case 11:
					strEstados = strEstados + ",11";
					signo = true;
					strResultado = "ERROR";
				break;
				case 12:
					strEstados = strEstados + ",12";
					punto = true;
					strResultado = "ERROR";
				break;
				case 13:
					strEstados = strEstados + ",13";
					expresion_artimetica = true;
					strResultado = "ERROR";
				break;
				case 14:
					strEstados = strEstados + ",14";
					strResultado = "EXPONENCIAL";
				break;
				case 15:
					strEstados = strEstados + ",15";
					strResultado = "PALABRA RESERVADA";
					reservada = true;
				break;
				case 16:
					strEstados = strEstados + ",16";
					if(signo==true)
					{
						strResultado = "REAL CON SIGNO";
					}
					else
					{
						strResultado = "REAL";
					}
				break;
				case 17:
					strEstados = strEstados + ",17";
					strResultado = "ERROR";
				break;
				case 18:
					strEstados = strEstados + ",18";
					strResultado = "EXPONENCIAL";
				break;
				case 19:
					strEstados = strEstados + ",19";
				break;
				case 20: default:
					strResultado = "ERROR";
				break;
			}
			if(reservada == true)
			{
				break;
			}
			
			i++;
			
		}while(i < tamanio);
		
		txtEstado.setText(strEstados);
		txtResultado.setText(strResultado);
	}
	
    public static void main(String[] args)
    {
    	AnalizadorLG alg = new AnalizadorLG();
    }
}
