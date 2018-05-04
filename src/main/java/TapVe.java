import javax.swing.*;
import java.awt.*;

public class TapVe extends JPanel implements Runnable {
    Oto oto = new Oto();
    public TapVe(){
        Thread threadTV = new Thread(this);
        threadTV.start();
    }
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(getWidth()/2-150,0,300,getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(0,getHeight()/2-150,getWidth(),300);
        oto.paint(g, getWidth()/2, getHeight()/2);
    }
    public void run() {
        while (true){
            repaint();
            oto.giamX();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            oto.laplaiX();
        }
    }
}
