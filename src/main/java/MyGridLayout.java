

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyGridLayout extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private GridLayout gridLayout;
    private JLabel lblane1;
    private JLabel lblane2;
    private JLabel lblane3;
    private JLabel lblane4;
    private JLabel speed;
    final int dram = 3;
    TapVe tapveM;
    boolean toiUu = false;
    JButton buttonToiUu;
    JButton addSpeed;
    JButton subSpeed;

    public MyGridLayout(TapVe tapveM) {
        this.tapveM = tapveM;
        createJFrame();
    }

    private void createJFrame() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        // add content to JFrame
        mainPanel = createMainPanel();
        add(mainPanel);
        // display
        setLocationRelativeTo(null);
        setVisible(true);
        setLocation(1200, 0);
    }

    private JPanel createMainPanel() {
        // create JPanel with GridLayout
        gridLayout = new GridLayout(10,1, 1, 1);
        JPanel panel = new JPanel(gridLayout);
        // add four JButton to panel
//        lane1.setBackground(Color.white);
//        lane1.setForeground(Color.black);
        JLabel lb = new JLabel("Thời gian đèn xanh");
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        lblane1 = createJLabel("Chùa Bộc - Thái Hà: 45s");
        panel.add(lblane1);
        lblane2 = createJLabel("Tây Sơn 1 - Tây Sơn 2: 15s");
        panel.add(lblane2);
        lblane3 = createJLabel("Thái Hà - Chùa Bộc: 15s");
        panel.add(lblane3);
        lblane4 = createJLabel("Tây Sơn 2 - Tây Sơn 1: 15s");
        panel.add(lblane4);
        speed = createJLabel("Tốc độ:"+String.valueOf(6-tapveM.speed));
        panel.add(speed);
        buttonToiUu = createJButton("Tối ưu");
        panel.add(buttonToiUu);
        addSpeed = createJButton("Tăng tốc độ");
        panel.add(addSpeed);
        subSpeed = createJButton("Giảm tốc độ");
        panel.add(subSpeed);
//        panel.add(createJButton("- vGap"));
//        panel.add(createJButton("+ hGap"));
//        panel.add(createJButton("- hGap"));
        // create and add vGap and hGap JLabel to panel

//        lbHGap = createJLabel("hGap = 5");
//        panel.add(lbVGap);
//        panel.add(lbHGap);
        return panel;
    }

    // create JButton
    private JButton createJButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }
    private JTextArea createTextArea() {
        JTextArea editTextArea = new JTextArea();
        editTextArea.setBackground(Color.white);
        editTextArea.setForeground(Color.black);
        return editTextArea;
    }

    // create JLabel
    private JLabel createJLabel(String title) {
        JLabel lb = new JLabel(title);
//        lb.setHorizontalAlignment(JLabel.CENTER);
        return lb;
    }


    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command == "Tối ưu" && toiUu == false) { // augment vGap
            tapveM.reset();
            tapveM.setTime(54,27,27,27);
            toiUu = true;
            buttonToiUu.setText("Trở lại lúc chưa tối ưu");
            lblane1.setText("Chùa Bộc - Thái Hà:54s");
            lblane2.setText("Tây Sơn 1 - Tây Sơn 2: 27s");
            lblane3.setText("Thái Hà - Chùa Bộc: 27s");
            lblane4.setText("Tây Sơn 2 - Tây Sơn 1: 27s");
        }
        if(command == "Trở lại lúc chưa tối ưu" && toiUu ==true){
            tapveM.reset();
            tapveM.setTime(45,15,15,15);
            toiUu = false;
            buttonToiUu.setText("Tối ưu");
            lblane1.setText("Chùa Bộc - Thái Hà: 45s");
            lblane2.setText("Tây Sơn 1 - Tây Sơn 2: 15s");
            lblane3.setText("Thái Hà - Chùa Bộc: 15s");
            lblane4.setText("Tây Sơn 2 - Tây Sơn 1: 15s");
        }
        if(command == "Tăng tốc độ" && tapveM.speed>1){
            tapveM.speed--;
            speed.setText("Tốc độ:"+String.valueOf(6-tapveM.speed));
        }
        if(command == "Giảm tốc độ"){
            tapveM.speed++;
            speed.setText("Tốc độ:"+String.valueOf(6-tapveM.speed));
        }
    }
}