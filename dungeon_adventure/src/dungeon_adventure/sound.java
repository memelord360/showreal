/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;
//import resources
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 
//set varible
public class sound
{
public static synchronized void play(InputStream soundResource)
 {
 new Thread(new Runnable()
{
@Override//play sound
 public void run()
 {
 try
 {
 Clip clip = AudioSystem.getClip();
 AudioInputStream ais = AudioSystem.getAudioInputStream(soundResource);
 clip.open(ais);
 clip.start();
 }catch(Exception ex)
 {//display error message
 System.out.println("Error playing sound " + ex.getMessage());
 }
 }
 }).start();
 }
 }

