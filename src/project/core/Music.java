/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.core;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Music {
     public static Clip playMusic(String location, boolean loop) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
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
