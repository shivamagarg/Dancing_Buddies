/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dell
 */
public class KeyManager implements KeyListener {
    private  boolean keys[];
    public boolean up,down,left,right,que,ee,shift;
    public KeyManager(){
        keys=new boolean[256];
    }
    
    public void update()
    {
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
        que=keys[KeyEvent.VK_Q];
        ee=keys[KeyEvent.VK_E];
        shift=keys[KeyEvent.VK_SHIFT];
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        System.out.println("Pressed!"); 
    }

    @Override
    public void keyReleased(KeyEvent e) {
       keys[e.getKeyCode()]=false;
    }
    
}
