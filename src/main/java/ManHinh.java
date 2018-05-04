import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManHinh extends JFrame {
    TapVe tapveM = new TapVe();
    public ManHinh(){
        setSize(1200, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        add(tapveM);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tapveM.setStop();
            }
        });
    }

    public static void main(String[] args) {
        ManHinh mh = new ManHinh();
    }
}
