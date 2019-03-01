/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.enities;

import dancingbuddies.game.Game;
import dancingbuddies.gfx.Asset;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Dell
 */
public class arrows {
    
    private int width,height,value,max=7,min=0;
    private Game game;
    private static Graphics g;
    private Timer timer;
    
    public arrows(Game game, int width ,int height)
    {
        this.game=game;
        this.width=width;
        this.height=height; 
        this.value=0;
        timer=new Timer(1000, null);
        timer.start();
  }
    public void render(Graphics g,float score) 
    {
        g.drawImage(Asset.arrows[value], width, height, null);
        
    }
    public void update()
    {
        timer.start();
        timer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updatevalue();
               timer.stop();
            }
        });
        
    }
    public void updatevalue()
    {
            value=(int)(Math.random()*((max-min)+1))+min;
        
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
}
