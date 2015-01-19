package com.game.src.main;


import java.applet.AudioClip;
import java.applet.Applet;

public class Sound {
	
	public static final Sound song = new Sound("/song.wav");
	public static final Sound gun = new Sound("/gun.wav");
	public static final Sound hit = new Sound("/hit.wav");
	public static final Sound gameOver = new Sound("/GameOver.wav");
	public static final Sound leave = new Sound("/leave.wav");
	public static final Sound haha = new Sound("/haha.wav");
	//public static final Sound gameOver = new Sound("/GameOver.wav");
	
	
	
	
	private AudioClip clip;	
	
	public Sound(String filename){
		try{
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play(){
		try {
			new Thread(){
				public void run(){
					clip.play();
				}
			}.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void stop(){
		try {
			this.stop();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
