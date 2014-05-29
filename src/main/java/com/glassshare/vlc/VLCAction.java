package com.glassshare.vlc;

/**
 * VLC action class. 
 * 
 * @author Haoyu
 *
 */
public enum VLCAction {
	LOAD, PLAY, STOP, PAUSE;
	
	public static VLCAction fromCmdId(int cmdId) {
		return LOAD;
	}
}
