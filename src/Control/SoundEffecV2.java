package Control;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffecV2 {
    private Clip audioClip;
    
    //se recibe el clip desde la raiz del programa
    public SoundEffecV2(InputStream path) {
        
        try {
            //guardamos el clip
            InputStream bufferedIn = new BufferedInputStream(path);
            audioClip = AudioSystem.getClip();
            //al recuperar de la raiz y pasar a jar se necesita realizar una comprobacion de bits
            audioClip.open(AudioSystem.getAudioInputStream(bufferedIn));
            

        } catch (Exception fallo) {
            System.out.println(fallo);

        }
        
    }
    
      public void PlaySound() {
        new Thread(() -> {
            audioClip.setFramePosition(0);
            audioClip.start();
        }) {
        }.start();
    }

    public void loopMusic() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }){}.start();
    }

    public void stopSounds() {
        audioClip.stop();
    }

}
