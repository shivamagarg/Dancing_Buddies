/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.gfx;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Dell
 */
public class Asset {
    public static BufferedImage background;
    public static BufferedImage p1[]= new BufferedImage[15];
    public static BufferedImage arrows[]=new BufferedImage[10];
    public static BufferedImage dance_left[]=new BufferedImage[2];
    public static BufferedImage dance_right[]=new BufferedImage[2];
    public static Animations anim_left,anim_right,anim_arrow;
    public static final int width=225,height=230;
    public static final int arrow_width=80,arrow_height=80;
    public static void init(){
        
        spritesheet sheet=new spritesheet(ImageLoader.loadImage("/textures/player1.png"));
        spritesheet sheet2=new spritesheet(ImageLoader.loadImage("/textures/symbols.png"));
         background = ImageLoader.loadImage("/textures/street.png");
        //player
        p1[0]=sheet.crop(0,0,width,height);
        p1[1]=sheet.crop(width,0, width, height);
        p1[2]=sheet.crop(width*2,0, width, height);
        p1[3]=sheet.crop(width*3,0, width, height);
        p1[4]=sheet.crop(width*4,0, width, height);
        p1[5]=sheet.crop(width*5,0, width, height);
        p1[6]=sheet.crop(0,height, width, height);
        p1[7]=sheet.crop(width,height, width, height);
        p1[8]=sheet.crop(width*2,height, width, height);
        p1[9]=sheet.crop(width*3,height, width, height);
        p1[10]=sheet.crop(width*4,height, width, height);
        p1[11]=sheet.crop(width*5,height, width, height);
        //arrows
        arrows[0]=sheet2.crop(0,0,arrow_width,arrow_height);
        arrows[1]=sheet2.crop(arrow_width,0,arrow_width,arrow_height);
        arrows[2]=sheet2.crop(arrow_width*2,0,arrow_width,arrow_height);
        arrows[3]=sheet2.crop(0,arrow_height,arrow_width,arrow_height);
        arrows[4]=sheet2.crop(arrow_width,arrow_height,arrow_width,arrow_height);
        arrows[5]=sheet2.crop(arrow_width*2,arrow_height,arrow_width,arrow_height);
         arrows[6]=sheet2.crop(0,arrow_height*2,arrow_width,arrow_height);
         arrows[7]=sheet2.crop(arrow_width,arrow_height*2,arrow_width,arrow_height);
         arrows[8]=sheet2.crop(arrow_width*2,arrow_height*2,arrow_width,arrow_height);
        //Animations
        dance_left[0]=p1[6];
        dance_left[1]=p1[7];
        
        dance_right[0]=p1[8];
        dance_right[1]=p1[9];
        
        anim_arrow=new Animations(2000, arrows);
       
        anim_left=new Animations(90000000,dance_left);
        anim_right=new Animations(90000000,dance_right);
        
    }
}
