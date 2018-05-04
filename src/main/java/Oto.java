import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Oto extends JPanel {
    private static int x1= 1000, x2= x1 + 70, x3 = x2 +70 , x4 = x3 + 70;
    private static int h1, h2, h3, h4;
    public void random(){
        Random rd = new Random();
        h1 = rd.nextInt(50);
        h2 = rd.nextInt(50);
        h3 = rd.nextInt(50);
        h4 = rd.nextInt(50);
    }
    public void paint(Graphics g,int width, int height){
        random();
        g.setColor(Color.RED);
        g.fillRect(width, x1+ h1, 30, 50);
        g.setColor(Color.RED);
        g.fillRect(width, x2 + h2, 30, 50);
        g.setColor(Color.RED);
        g.fillRect(width, x3 + h3, 30, 50);
        g.setColor(Color.RED);
        g.fillRect(width, x4 + h4, 30, 50);
    }
    public void goX(){
        x1 = x1 -2;
        x2 = x2 -2;
        x3 = x3 -2;
        x4 = x4 -2;
    }
    public void laplaiX(){
        if(x1 == -50){
            x1 = 1000;
        }
        if(x2 == -50){
            x2 = 1000;
        }
        if(x3 == -50){
            x3 = 1000;
        }
        if(x4 == -50){
            x4 = 1000;
        }
    }
}
