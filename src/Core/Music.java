package Pacman.src.Core;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.*;

public class Music {

    public static Clip playMusic(String location, boolean loop) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (loop) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                return clip;
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

}
