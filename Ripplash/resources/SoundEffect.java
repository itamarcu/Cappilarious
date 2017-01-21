
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundEffect
{
	public Clip			sound;
	public FloatControl	volumeControl;
	public double		volume;						// 0 = mute, 1 = full volume. (default is 1)
	public double		length;						// in seconds
	public boolean		active;
	public boolean		justActivated;				// becomes false at the beginning of every frame, if it's false at the end the sound is stopped in certain cases
	public boolean		paused				= false;
	public boolean		loopOrPlay			= false;
	public boolean		endUnlessMaintained	= false;
	public String		name;

	public SoundEffect(String fileName)
	{
		name = fileName;
		sound = ResourceLoader.getClip(fileName);
		volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);// default is 0, can be between -80 and 6.02 for some reason (dB). Logarithmic. ~-50 is unheardable, and there's barely any difference between 0 and 6.
		volume = 1;
		active = false;
		justActivated = false;
		length = (double) sound.getMicrosecondLength() / 1000000; // important that it's a double

		// Only SOME of the .wav files support Balance Control (playing the sound from one speaker louder than the other speaker) or Pan Control.
		// If you want to use that feature, there you go!

		// if (sound.isControlSupported(FloatControl.Type.BALANCE))
		// {
		// FloatControl a = (FloatControl) sound.getControl(FloatControl.Type.BALANCE);
		// a.setValue((float) (Math.random()*2 - 1));
		// }
	}

	public void stopIfEnded()
	{
		if (sound.getFramePosition() == sound.getFrameLength())
		{
			stop();
		}
	}

	public void setVolume(double newVolume)
	{
		// value should be between 0 and 1. Let's make sure.
		newVolume = Math.min(newVolume, 1);
		newVolume = Math.max(newVolume, 0);

		volume = newVolume;
		volumeControl.setValue(volumeControl.getMinimum() + ((float) volume) * (volumeControl.getMaximum() - volumeControl.getMinimum()));
		// volumeControl.setValue((float) (Math.log(newVolume) / Math.log(10.0) * 20.0));
	}

	public void loop()
	{
		active = true;
		justActivated = true;
		sound.loop(Clip.LOOP_CONTINUOUSLY);
		loopOrPlay = true;
	}

	public void play()
	{
		active = true;
		justActivated = true;
		sound.start();
		loopOrPlay = false;
	}

	public void stop()
	{
		active = false;
		justActivated = false;
		paused = false;
		sound.stop();
		sound.setFramePosition(0);
		
	}

	public void pause()
	{
		if (active)
		{
			active = false;
			justActivated = false;
			sound.stop();
			paused = true;
		}
	}

	public void cont()// inue
	{
		if (paused)
		{
			if (loopOrPlay)
				loop();
			else
				play();
			paused = false;
		}
	}
}
