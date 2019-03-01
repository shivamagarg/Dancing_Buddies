/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.main;

import dancingbuddies.game.Game;

/**
 *
 * @author Dell
 */
public class Launcher {
    public static void main(String[] args) {
    Game game =new Game("Dancing Buddies",720,480);
    game.start();
       // System.out.println("Current:"+Thread.currentThread());
    }
   
}
