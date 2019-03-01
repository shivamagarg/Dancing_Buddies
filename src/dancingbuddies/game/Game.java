/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.game;

import dancingbuddies.display.Display;
import dancingbuddies.gfx.Asset;
import dancingbuddies.gfx.ImageLoader;
import dancingbuddies.input.KeyManager;
import dancingbuddies.sounds.Sound;
import dancingbuddies.states.GameState;
import dancingbuddies.states.state;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Game implements Runnable{
    private String name;
    private int width;
    private int height;
    private Display display;
    private Graphics g;
    private BufferStrategy bs;
    public Thread thread;
    private boolean running=false;
    private BufferedImage background;
    private KeyManager keyManager;
    private Sound sound;
    
    public Game(String name,int width ,int height)
    {
        this.name=name;
        this.height=height;
        this.width=width;
        sound=new Sound();
        keyManager=new KeyManager();
    }
    public void init()
    {
        display=new Display(name, width, height);
        display.getJframe().addKeyListener(keyManager);
        Asset.init();
        GameState gameState=new GameState(this);
        state.setState(gameState);

    }
    
    public synchronized void start()
    {
    if(running){
            return;
        }
        running=true;
        thread=new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop()
    {
        if(!running){
            return;
        }
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override 
    public void run()
    {
        init();
        //System.out.println("Current:"+Thread.currentThread());
	int fps=60;
        double timeperupdate=1000000000.0/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        long updates=0;
        while(running){
            now=System.nanoTime();
            delta +=(now-lastTime)/timeperupdate;
            timer +=(now-lastTime);
            lastTime=now;
            
            if(delta>=1){
               
                update();
                
                render();
               
                updates++;
                delta--;
            }
          if(timer>=1000000000){
              //System.out.println("Updates And Frames:"+updates);
              updates=0;
              timer=0;
          }
		

    }
    }
    
   public void update()
    {
        keyManager.update();
     if(state.getState()!=null)
     {
         state.getState().update();
     }
   
    }
    public void render()
    {
     bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
                g.clearRect(0, 0, width, height);
                setG(g);
		//Draw Here!
		if(state.getState()!=null)
                 {
                    state.getState().render(g);
                  }
		
		
		//End Drawing!
		bs.show();
		g.dispose();
    }
    
    public void check(int flag)
    {
        int input[]=new int[]{0,1,2,3,4,5,6,7};
    }
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }
    
   
}
