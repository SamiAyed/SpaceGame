package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class MouseInput implements MouseListener {
	
	public boolean incremented=false;
	
	GenerXml xmlFile = new GenerXml();

	private List<Map> myList = new ArrayList<Map>();
	
	Map<String, String> dictionary = new HashMap<String, String>();
		
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e)
	{	
		int mx=e.getX();
		int my=e.getY();
		
		
		
		/**
		 *  public Rectangle playButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
			public Rectangle helpButton = new Rectangle(Game.WIDTH/2+120,250,100,50);
			public Rectangle quitButton = new Rectangle(Game.WIDTH/2+120,350,100,50);
		*/
		
		
		if(Game.State==Game.STATE.MENU)
		{
			//Play Button
				if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH/2+220)
				{
					if(my >= 150 && my <= 200)
					{
						Game.State=Game.STATE.GAME;
					}
				}
				
				
			//Help Button
			if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH/2+220)
			{
				if(my >= 250 && my <= 300)
				{
					Game.State=Game.STATE.HELP;
				}
			}
			
			//Quit Button
				if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH/2+220)
				{
					if(my >= 350 && my <= 400)
					{			
						//Quit pressed
						System.exit(1);
					}
				}
				
			//Easy Button
				if(mx >= Game.WIDTH+120 && mx <= Game.WIDTH+220)
				{
					if(my >= 150 && my <= 200)
					{			
						Game.Diffuculity=Game.DIFFICULITY.EASY;
						Game.restartCost=50;
					}
				}
			//Medium Button
				if(mx >= Game.WIDTH+ 120 && mx <= Game.WIDTH+220)
				{
					if(my >= 250 && my <= 300)
					{	
						Sound.leave.play();
						Game.Diffuculity=Game.DIFFICULITY.MEDIUM;
						Game.restartCost=100;
					}
				}
			//Hard Button
				if(mx >= Game.WIDTH+ 120 && mx <= Game.WIDTH+220)
				{
					if(my >= 350 && my <= 400)
					{	
						Sound.haha.play();
						Game.Diffuculity=Game.DIFFICULITY.HARD;
						Game.restartCost=200;
					}
				}
		}
		
		if(Game.State==Game.STATE.HELP)
		{
			
			
			//Quit Button
				if(mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH/2+220)
				{
					if(my >= 350 && my <= 400)
					{			
						Game.State=Game.STATE.MENU;
					}
				}
		}
		
		if(Game.State==Game.STATE.END)
		{
			if(incremented==false)
			//Incrémentation du nombre de morts
			{
				Game.numbDeaths++;
				incremented=true;
			}
			
			//Continue Button
			if(mx >= Game.WIDTH/2 + 120 && mx <= Game.WIDTH/2 + 220)
			{
				if(my >= 150 && my <= 200)
				{
					if(Game.score>=(Game.restartCost*Game.numbDeaths))
					{
						incremented=false;
						Game.HEALTH=200;
						Game.score-=Game.restartCost*Game.numbDeaths;
						Game.State=Game.STATE.GAME;
					}
					else
					{
						long diff=(Game.restartCost*Game.numbDeaths)-Game.score;
						javax.swing.JOptionPane.showMessageDialog(null,"Malheureusement vous n'avez pas assez de points de score ! il te manque "+diff+" points.");
					}
				}
			}
			
			//Quit Button
			if(mx >= Game.WIDTH/2 + 120 && mx <= Game.WIDTH/2+220)
			{
				if(my >= 350 && my <= 400)
				{	
					if(incremented==false) Game.numbDeaths++;
					
					JOptionPane.showMessageDialog(null,"Bravo ton score est de "+Game.score+" et tu es mort "+Game.numbDeaths+" fois.");
					////////////////////Test write Xml
					
					File f = new File("saves.xml");
					if(!(f.exists()) /*&& !f.isDirectory()*/) { xmlFile.saveToXML("saves.xml"); }
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Score ?","Score Saving",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
					String pseudo= JOptionPane.showInputDialog("Please input your pseudo: ");
					xmlFile.pseudo=pseudo;
					xmlFile.writeXML("saves.xml");}
					
					myList =  xmlFile.readXML("saves.xml");
					
					for(int i=0 ; i < myList.size() ; i++)
					{
					dictionary = myList.get(i);
						System.out.println(" :D : "+ dictionary.get("pseudo").toString());
					}
					
					
					////////////////////////
					//Quit pressed
					System.exit(1);
					
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
