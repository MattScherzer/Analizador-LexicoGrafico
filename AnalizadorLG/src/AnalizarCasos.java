/**
 * @(#)AnalizarCasos.java
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

import javax.swing.*;

public class AnalizarCasos
{
	public int Validar(char caracter, int caso, String cadena)
	{		
		switch(caso) // validar lo que puede pasar en los distintos casos
		{
			case 0:
				if(Character.isLetter(caracter) == true)
				{
					if(PalabraReservada(cadena) == true)
					{
						return 15;
					}
					else if(Character.isLetter(caracter) == true || caracter == '_')
					{
					return 1;
					}
					else
					{
						return 20;
					}
				}
				else if(Character.isDigit(caracter) == true)
				{
					return 2;
				}
				else if(caracter == '+' || caracter == '-')
				{
					return 11;
				}
				else
				{
					return 20;
				}
			case 1:
				// El caso uno puede mandar a un caso distinto y puede mandar a caso de error
				if(Character.isLetter(caracter) == true || Character.isDigit(caracter) == true || caracter == '_')
				{
					return 1; // se hace recursivo hasta el fin de cadena
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 2:
				// El caso dos puede mandar a 5 casos diferentes + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 3;
				}
				else if(caracter == 'A' || caracter == 'B' || caracter == 'C' || caracter == 'D' || caracter == 'E' || caracter == 'F')
				{
					return 7;
				}
				else if(caracter == '.')
				{
					return 12;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 3:
				// El caso tres puede mandar a 5 casos diferentes + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 4;
				}
				else if(caracter == 'A' || caracter == 'B' || caracter == 'C' || caracter == 'D' || caracter == 'E' || caracter == 'F')
				{
					return 8;
				}
				else if(caracter == '.')
				{
					return 12;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 4:
				// El caso cuatro puede mandar a 5 casos diferentes + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 5;
				}
				else if(caracter == 'A' || caracter == 'B' || caracter == 'C' || caracter == 'D' || caracter == 'E' || caracter == 'F')
				{
					return 9;
				}
				else if(caracter == '.')
				{
					return 12;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 5:
				// El caso cinco puede mandar a 5 casos diferentes + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 6;
				}
				else if(caracter == 'H' || caracter == 'h')
				{
					return 10;
				}
				else if(caracter == '.')
				{
					return 12;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 6:
				// El caso seis es recursivo y puede mandar a 3 casos diferentes + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 6;
				}
				else if(caracter == '.')
				{
					return 12;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // caso de error en caso de leer un caracter no valido
				}
			case 7:
				// El caso siete puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true ||
					caracter == 'A' || caracter == 'B' || caracter == 'C' || caracter == 'D' || caracter == 'E' || caracter == 'F')
				{
					return 8;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}
			case 8:
				// El caso ocho puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true ||
					caracter == 'A' || caracter == 'B' || caracter == 'C' || caracter == 'D' || caracter == 'E' || caracter == 'F')
				{
					return 9;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}				
			case 9:
				// El caso nueve puede mandar a 1 caso diferente + caso de error
				if(caracter == 'H' || caracter == 'h')
				{
					return 10;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}
			case 11:
				// El caso once puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 6;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}
			case 12:
				// El caso doce puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 16;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}
			case 13:
				// El caso once puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 6;
				}
				else if(Character.isLetter(caracter) == true)
				{
					return 1;
				}
				else
				{
					return 20;  // caso de error en caso de leer un caracter no valido
				}
			case 14:
				// El caso catorce puede mandar a 1 caso diferente + caso de error
				if(caracter == '+' || caracter == '-')
				{
					return 17;
				}
				else
				{
					return 20; // si no entra en ninguno de los casos anteriores manda a un estado de error
				}
			case 16:
				// El caso dieciseis es recursivo y puede mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 16;
				}
				else if(caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
				{
					return 13;
				}
				else if(caracter == 'e')
				{
					return 14;
				}
				else
				{
					return 20; // si no entra en ninguno de los casos anteriores manda a un estado de error
				}
			case 17: case 19:
				// El caso diecisiete y diecinueve pueden mandar a 1 caso diferente + caso de error
				if(Character.isDigit(caracter) == true)
				{
					return 18;
				}
				else
				{
					return 20; // si no entra en ninguno de los casos anteriores manda a un estado de error
				}
			case 18:
				// El caso dieciocho puede mandar a 1 caso diferente + caso de error
				if(caracter == '.')
				{
					return 19;
				}
				else
				{
					return 20; // si no entra en ninguno de los casos anteriores manda a un estado de error
				}
			case 10: default:
				return 20;
		}
	}
	
	public boolean PalabraReservada(String palabra)
    {
    	boolean correcto = false;
    	
    	if(palabra.equalsIgnoreCase("int"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("float"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("double"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("byte"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("char"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("boolean"))
		   correcto=true;
		   
		if(palabra.equalsIgnoreCase("true"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("false"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("if"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("else"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("switch"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("case"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("default"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("while"))
			correcto=true;
			
		if(palabra.equalsIgnoreCase("for"))
			correcto=true;
			
		return correcto;
    }
}