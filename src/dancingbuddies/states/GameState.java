/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.states;

import dancingbuddies.enities.Player;
import dancingbuddies.enities.arrows;
import dancingbuddies.game.Game;
import dancingbuddies.gfx.Asset;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class GameState extends state {
private int width=120;
private int height=250;
private int width_arrow=350;
private int height_arrow=50;
private int flag;
private Player player;
private arrows arrow; 
private float score=0;

    public GameState(Game game)
    {
        
        super(game);
        System.out.println(""+Thread.currentThread().getId());
        flag=0;
     player=new Player(game, width, height);
      arrow=new arrows(game, width_arrow, height_arrow);
    }
    @Override
    public void update() {
   player.update();
     arrow.update();
     check();
    }
    
    @Override
    public void render(Graphics g) {
     g.drawImage(Asset.background,0,0, null); 
     //g.drawString();
     player.render(g);
    arrow.render(g,score);
    }
    
    public void check()
    {
         if(player.getFlag()==arrow.getValue())
         {
             try {
                 score+=1.6666;
                 System.out.println("Score:"+(int)score);
                 
                 
                 
                 Thread.sleep(10);
             } catch (InterruptedException ex) {
                 Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else
         {
            // System.out.println("Wrong Choice");
         }
         
    }
    
}
