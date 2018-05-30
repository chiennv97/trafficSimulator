import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManHinh extends JFrame {
    static TapVe tapveM = new TapVe();
    static ManHinh mh;
    public ManHinh(){
        setSize(1200, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        add(tapveM);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    tapveM.showPosition();
                }
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    tapveM.setStop();
                    tapveM.setRun();
                }
                if (e.getKeyCode()==KeyEvent.VK_A){
                    tapveM.pause();
                }
                if (e.getKeyCode()==KeyEvent.VK_B){
                    tapveM.setRun();
                }
            }
        });
    }
    public static void main(String[] args) {
        mh = new ManHinh();
        new MyGridLayout(tapveM);
    }
}
