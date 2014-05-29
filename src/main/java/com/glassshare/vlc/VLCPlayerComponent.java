package com.glassshare.vlc;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

/**
 * Implementation of VLCPlayer class
 * 
 * @author Haoyu
 * 
 */
public class VLCPlayerComponent implements VLCPlayer {

	public VLCPlayerComponent() {

	}

	public void init() {
		JFrame frame = new JFrame("Glass Share");

		EmbeddedMediaPlayerComponent mediaFrame = new EmbeddedMediaPlayerComponent();
		frame.setContentPane(mediaFrame);

		frame.setLocation(100, 100);
		frame.setSize(1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		MediaPlayer mediaPlayer = mediaFrame.getMediaPlayer();

		// Set standard options as needed to be applied to all subsequently
		// played media items
		String[] standardMediaOptions = { "video-filter=logo",
				"logo-file=vlcj-logo.png", "logo-opacity=25" };
		mediaPlayer.setStandardMediaOptions(standardMediaOptions);

		mediaPlayer.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

		});

		// Play a particular item, with options if necessary
		String mediaPath = "/Users/apple/Movies/The.Big.Bang.Theory.S07E24.HDTV.x264-LOL.mp4";
		mediaPlayer.playMedia(mediaPath);

		// Cleanly dispose of the media player instance and any associated
		// native resources
		// mediaPlayer.release();

		// Cleanly dispose of the media player factory and any associated native
		// resources
		// mediaPlayerFactory.release();
	}

	public static void main(String[] args) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
				"/Applications/VLC.app/Contents/MacOS/lib");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VLCPlayerComponent().init();
			}
		});
	}

	@Override
	public void load(String mediaFilePath) {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}
}
