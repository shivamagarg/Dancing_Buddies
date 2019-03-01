/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Dell
 */
public class Animations {
private int speed,index;
private long lastTime,timer;
private BufferedImage[] frames;

public Animations(int speed,BufferedImage[] frames)
{
    this.speed=speed;
    this.frames=frames;
    index=0;
    timer=0;
    lastTime=System.currentTimeMillis();
    
}
public void update()
{
    timer += System.currentTimeMillis() - timer;
    lastTime=System.currentTimeMillis();
    
    if(timer>speed)
    {
        index++;
        timer=0;
        if(index>=frames.length)
        {
            index=0;
        }
    }
}

public BufferedImage getCurrentFrame()
{
    return frames[index];
}

}
