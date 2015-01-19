package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Help {
	
	//public Rectangle rePlayButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
	public Rectangle returnButton =   new Rectangle(Game.WIDTH/2+120,350,100,50);
	
	public void render(Graphics g){
		Graphics2D g2d =(Graphics2D) g;
		
		Font fnt0 =new Font("Pixel-Noir",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Help", (Game.WIDTH/2)+100,100);
		
		Font fnt1 = new Font("Pixel-Noir",Font.BOLD,11);
		Font fnt2 = new Font("Pixel-Noir",Font.BOLD,18);
		g.setFont(fnt1);
		g.drawString("Space Game est un jeu d'action qui demande du reflexe et de l'agilité. ", 50, 150);
		g.drawString("Votre Objective est simple : détruire les ennemies et pour cela vous  ", 50, 170);
		g.drawString("allé leur tirer dessus avec votre puissant canon a lazer ( la touche  ", 50, 190);
		g.drawString("Espace de votre clavier ) et depelacer vous de droite a gauche ( les  ", 50, 210);
		g.drawString("touches Droite et Gauche de votre clavier ", 50, 230);
//		g2d.draw(rePlayButton);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Return", returnButton.x+5, returnButton.y+35);
		g2d.draw(returnButton);
	
	}
	
}
