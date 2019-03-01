/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.states;

import dancingbuddies.game.Game;
import java.awt.Graphics;

/**
 *
 * @author Dell
 */
public abstract class state {
     private static state currentState=null;
     protected Game game;
     public state(Game game)
     {
         this.game=game;
     }
    public static state getState() {
        return currentState;
    }

    public static void setState(state currentState) {
        state.currentState = currentState;
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
}
