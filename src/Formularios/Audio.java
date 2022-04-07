package Formularios;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Audio {
public static void main(String mp3) {
	try{
		//abrimos un flujo de entrada de archivo para abrir nuestro archivo mp3 -
		FileInputStream archivo = new FileInputStream(mp3);
		//creamos un objeto de tipo player, player es una clase se la libreria Jlayer que miramos en el video de convertir texto a voz -
		Player playMP3 = new Player(archivo);
		//y reproducimos -
		playMP3.play();
		} catch(Exception exc){
		//en caso de no encontrar el archivo o otro tipo de error mostramos el archivo -
		exc.printStackTrace();
		} 
}}

