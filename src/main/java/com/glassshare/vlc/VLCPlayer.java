package com.glassshare.vlc;

/**
 * VLCPlayer interface. 
 * 
 * @author Haoyu
 *
 */
public interface VLCPlayer {
	
	public void load(String mediaFilePath);
	
	public void play();
	
	public void stop();
	
	public void pause();
	
}
