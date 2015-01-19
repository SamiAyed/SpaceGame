package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.Rectangle;

//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioPermission;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.DataLine;
//import javax.sound.sampled.TargetDataLine;
//import sun.*;



import com.game.src.main.Game.DIFFICULITY;

public class Menu{

	public Rectangle playButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH/2+120,250,100,50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2+120,350,100,50);
	public Rectangle easyButton =   new Rectangle(Game.WIDTH+120,150,100,50);
	public Rectangle mediumButton = new Rectangle(Game.WIDTH+120,250,100,50);
	public Rectangle hardButton =   new Rectangle(Game.WIDTH+120,350,100,50);
	
	public Sound sound;
	
	public void render(Graphics g){
		
		Graphics2D g2d =(Graphics2D) g;
		
		Font fnt0 =new Font("Pixel-Noir",Font.BOLD,30);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SPACE GAME", Game.WIDTH/2,100);
	
		Font fnt1 = new Font("Pixel-Noir",Font.BOLD,20);
		Font fnt2 = new Font("Pixel-Noir",Font.BOLD,17);
		g.setFont(fnt1);
		
		g.drawString("Play", playButton.x+19, playButton.y+35);
		g2d.draw(playButton);
		
		g.setColor(Color.black);
		g.drawString("Help", helpButton.x+19, helpButton.y+35);
		g2d.draw(helpButton);
		
		g.setColor(Color.white);
		g.drawString("Quit", quitButton.x+19, quitButton.y+35);
		g2d.draw(quitButton);
		
		if(Game.Diffuculity==DIFFICULITY.EASY)
		{
			g.setColor(Color.black);
			g.fillRect(easyButton.x,easyButton.y, 100, 50);
			
		}else if(Game.Diffuculity==DIFFICULITY.MEDIUM){
			g.setColor(Color.black);
			g.fillRect(mediumButton.x,mediumButton.y, 100, 50);
			
		}else if(Game.Diffuculity==DIFFICULITY.HARD){
			g.setColor(Color.black);
			g.fillRect(hardButton.x,hardButton.y, 100, 50);
			
		}
		
		//EASY
		g.setColor(Color.white);
		g.drawString("Easy", easyButton.x+19, easyButton.y+35);
		g2d.draw(easyButton);
		
		//MEDIUM
		g.setFont(fnt2);	
		g.drawString("Meduim", mediumButton.x+10, mediumButton.y+35);
		g2d.draw(mediumButton);
		
		//HARD
		g.setFont(fnt1);
		g.drawString("Hard", hardButton.x+19, hardButton.y+35);
		g2d.draw(hardButton);
			
	}
	
}
