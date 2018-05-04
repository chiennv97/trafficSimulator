import javax.swing.*;
import java.awt.*;

public class Oto extends JPanel {
    private static int x= 500;
    public void paint(Graphics g,int width, int height){
        g.setColor(Color.RED);
        g.fillRect(width, x, 30, 50);
    }
    public static void setX(int x) {
        Oto.x = x;
    }
    public void giamX(){
        x--;
    }
    public void laplaiX(){
        if(x == -50){
            x = 500;
        }
    }
}
