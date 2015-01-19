package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class End {
	
	public Rectangle rePlayButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
	public Rectangle quitButton =   new Rectangle(Game.WIDTH/2+120,350,100,50);
	public static boolean endSoundPlayed=false;
	
	
	public void render(Graphics g){
		Graphics2D g2d =(Graphics2D) g;
		
		Font fnt0 =new Font("Pixel-Noir",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Game Over", (Game.WIDTH/2)-35,100);
		
		Font fnt1 = new Font("Pixel-Noir",Font.BOLD,14);
		Font fnt2 = new Font("Pixel-Noir",Font.BOLD,20);
		g.setFont(fnt1);
		g.drawString("Continue", rePlayButton.x+7, rePlayButton.y+32);
		g2d.draw(rePlayButton);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Quit", quitButton.x+19, quitButton.y+35);
		g2d.draw(quitButton);
		
		
		
		Font fnt3 = new Font("Pixel-Noir",Font.BOLD,11);
		g.setFont(fnt3);
		g.setColor(Color.white);
		g.drawString("Use your score points ", Game.WIDTH-60,Game.HEIGHT);
		g.setColor(Color.black);
		g.drawString("to buy a new life ", Game.WIDTH-40,Game.HEIGHT+30);
		g.drawString("and continue were ", Game.WIDTH-45,Game.HEIGHT+60);
		g.setColor(Color.white);
		g.drawString("you died last time.", Game.WIDTH-40,Game.HEIGHT+90);
		
		if(endSoundPlayed==false){
			endSoundPlayed=true;
			Sound.gameOver.play();
		}
		
	
	}
	
	
	
}
