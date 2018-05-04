import javax.swing.*;

public class ManHinh extends JFrame {
    TapVe tapveM = new TapVe();
    public ManHinh(){
        setSize(1200, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 0);
        add(tapveM);
    }

    public static void main(String[] args) {
        ManHinh mh = new ManHinh();
    }
}
