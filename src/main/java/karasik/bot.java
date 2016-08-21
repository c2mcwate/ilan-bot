package karasik;


import java.awt.*;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * Created by Ilan-Main on 8/21/2016.
 */
public class bot implements NativeKeyListener {
    static Robot bhopper;
    private static boolean space = false;



    public static void main(String[] args) throws AWTException {
        bhopper = new Robot();
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new bot());



    }


    public static void writeChar(Robot bot, char c) {
        try{
            Thread.sleep(100);
            bot.keyPress(Character.toUpperCase(c));
            Thread.sleep(109);
            bot.keyRelease(Character.toUpperCase(c));
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

    public static void writeString(Robot bot, String s){
        for(Character c: s.toCharArray()){
            writeChar(bot, c);


        }
    }

    @Override public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
            }
        }
        if(nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_F1){
            writeString(bhopper, "hello");
        }


    }

    @Override public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}


