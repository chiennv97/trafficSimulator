import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Oto extends JPanel {
    private static int x1= 1000;
    private static int h1;
    private static boolean b1= true;
    private static int stopx = -50;
    private static int tempt = 0;
    public void random(){
        Random rd = new Random();
        if(b1 != false){
            h1 = rd.nextInt(500);
            b1 =false;
        }
    }
    public void paint(Graphics g,int width, int height){
        random();
        for(int i=0; i< 5; i++){
            tempt = x1 + 170*(i+1);
            g.setColor(Color.RED);
            g.fillRect(width, tempt, 30, 50);
        }
    }
    public void goX(){
//        if(x1 > stopx){
            x1 = x1 -2;
//        }
    }
    public void laplaiX(){
        if(x1 == -50 -170*7){
            x1 = 1000;
            b1 =true;
        }
    }
    public void setStopx(){
        stopx = -50;
    }
}
