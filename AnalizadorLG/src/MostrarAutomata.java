/**
 * @(#)MostrarAutomata.java
 *
 * Analizador Lexico Grafico
 * Proyecto de Teoria de la computacion
 * CUCEI 2013B
 *
 * @author Matt Scherzer
 * @version 1.00 2013/11/27
 */
 
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MostrarAutomata extends JFrame
{
	JLabel lblAutomata;
	Icon icnAutomata;
	String path = "C:/Users/fritz_000/Documents/CUCEI/13B/Teoria de la computacion/Analizador Lexico-Grafico/AnalizadorLG/src/Automata.jpg";

    public MostrarAutomata()
    {
    	Visual();
    }
    
    public void Visual()
    {
    	super.setTitle("Automata");
    	this.setBounds(280,150,1005,480);
		this.setResizable(false);
		
		// ICON
		icnAutomata = new ImageIcon(path);
		// LABEL		
		lblAutomata = new JLabel(icnAutomata);
		lblAutomata.setBounds(0,0,1000,460);
		
		
		setLayout(null);
		
		
		// ADD LABEL
		this.add(lblAutomata);
		
		// VISIBLE
		this.setVisible(true);
    }
}