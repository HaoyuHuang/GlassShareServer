package com.glassshare.vlc;

import com.glassshare.media.MediaRequestPacket;
import com.glassshare.media.MediaType;

/**
 * This class maps a client media request to the actual VLC action
 * @link{VLCAction}.
 * 
 * @author Haoyu
 * 
 */
public class VLCActionMapper {

	public void takeAction(VLCPlayer player, MediaRequestPacket packet) {

		MediaType type = MediaType.fromString(packet.getMediaType());

		if (MediaType.NULL.equals(type) || MediaType.PHOTO.equals(type)) {
			return;
		}
		VLCAction action = VLCAction.fromCmdId(packet.getCmdId());

		switch (action) {
		case LOAD:
			player.load("");
			break;
		case PAUSE:
			player.pause();
			break;
		case PLAY:
			player.play();
			break;
		case STOP:
			player.stop();
			break;
		default:
			break;
		}
	}
}
