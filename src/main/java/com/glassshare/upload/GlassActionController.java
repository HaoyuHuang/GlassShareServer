package com.glassshare.upload;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glassshare.media.MediaRequestPacket;
import com.glassshare.vlc.VLCActionMapper;
import com.glassshare.vlc.VLCPlayer;

/**
 * This class is used to handle media action request
 * 
 * @author Haoyu
 *
 */
@Controller
public class GlassActionController {

	@Autowired
	private VLCPlayer player;

	@RequestMapping(value = "/action", method = RequestMethod.POST)
	public @ResponseBody
	String handleAction(@RequestParam("action") String action) {
		try {
			MediaRequestPacket packet = new MediaRequestPacket();
			packet.fromJSON(action);
			VLCActionMapper actionMapper = new VLCActionMapper();
			actionMapper.takeAction(player, packet);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
}
