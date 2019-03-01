/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.enities;

import dancingbuddies.game.Game;
import dancingbuddies.gfx.Asset;
import dancingbuddies.states.GameState;
import java.awt.Graphics;

/**
 *
 * @author Dell
 */
public class Player extends Thread{
    
    private Game game;
    private int flag;
    private int width,height;
    public Player(Game game,int width,int height)
    {
      this.game=game;
      this.width=width;
      this.height=height;
      flag=-1;
      }
    public void getInput()
    {
        if(game.getKeyManager().up)
        {
            flag=0;
        }
        if(game.getKeyManager().down)
        {
            flag=1;
        }
        if(game.getKeyManager().right)
        {
            flag=3;
        }
        if(game.getKeyManager().left)
        {
            flag=2;
        }
        if(game.getKeyManager().que)
        {
            flag=4;
        }
        if(game.getKeyManager().ee)
        {
            flag=5;
        }
        if(game.getKeyManager().shift)
        {
            if(game.getKeyManager().left)
            {
                flag=6;
                Asset.anim_left.update();
            }
            if(game.getKeyManager().right)
            {
                flag=7;
                Asset.anim_right.update();
            }
        }
       
    }
    
    public void update()
    {
        getInput();
    }
    public void render(Graphics g)
    {
     if(flag==3)
     {
          g.drawImage(Asset.p1[0], width,height, null);
     }
     if(flag==2)
     {
     g.drawImage(Asset.p1[1], width,height, null);
    }
     if(flag==0)
     {
     g.drawImage(Asset.p1[2], width,height, null);
    }
     if(flag==1)
     {
     g.drawImage(Asset.p1[3], width,height, null);
    }
     if(flag==4)
     {
     g.drawImage(Asset.p1[10], width,height, null);
    }
     if(flag==5)
     {
     g.drawImage(Asset.p1[11], width,height, null);
    }
     if(flag==6)
     {
         //Animation
     g.drawImage(Asset.anim_left.getCurrentFrame(), width,height, null);
    }
     if(flag==7)
     {
         //Animation
     g.drawImage(Asset.anim_right.getCurrentFrame(), width,height, null);
    }
    }

    public int getFlag() {
        return flag;
    }
    
}
