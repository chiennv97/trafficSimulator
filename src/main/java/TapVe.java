import javax.swing.*;
import java.awt.*;

public class TapVe extends JPanel implements Runnable {
    int defautPositionLane1 = 1300;
    int defautPositionLane2 = 1000;
    int defautPositionLane3 = 1100;
    int defautPositionLane4 = 1200;
    //size cửa sổ, nếu dọc là 1000, ngang là 1200
    //typeX = true thì là hướng dọc,
    //distanse khoảng cách giữa các xe, dùng để giảm số lượng xe ô tô
    //stopline vạch dừng
    //postionY vị trí vẽ
    //turnX vị trí rẽ

    //Làn 1 đi thẳng
    Oto oto = new Oto(30, Color.CYAN, defautPositionLane1/2+20, 1000,  true, 1000, 1000/2+140);
    Oto oto2 = new Oto(30, Color.CYAN, defautPositionLane1/2-40, 1000,  true, 1000, 1000/2+140);
    Oto moto = new Oto(15, Color.red, defautPositionLane1/2+60, 1000, true, 200, 1000/2+140);
    Oto moto2 = new Oto(15, Color.red, defautPositionLane1/2-5, 1000, true, 200, 1000/2+140);
    //Làn 1 rẽ trái
    OtoTurnRight motoTurnRight = new OtoTurnRight(defautPositionLane1/2-60, 15, Color.red, 400, 1000, true, 200, 1000/2+140);
    OtoTurnRight otoTurnRight = new OtoTurnRight(defautPositionLane1/2-95, 30, Color.CYAN, 430, 1000, true, 1000, 1000/2+140);
    //Làn 1 rẽ phải
    OtoTurnLeft motoTurnLeft = new OtoTurnLeft(defautPositionLane1/2+120, 1000, 15, Color.red, 580, 1200, true, 200, 1000/2+140);
    OtoTurnLeft otoTurnLeft = new OtoTurnLeft(defautPositionLane1/2+80, 1000, 30, Color.CYAN, 540, 1200, true, 1000, 1000/2+140);

    //làn 2 đi thẳng
    Oto otoRight = new Oto(30, Color.CYAN, defautPositionLane2/2-100, 1200, false, 1000, 1200/2+200);
    Oto motoRight = new Oto(15, Color.red, defautPositionLane2/2-120, 1200, false, 200, 1200/2+200);
    //làn 2 rẽ phải
    OtoTurnRight otoRightTurnRight = new OtoTurnRight(defautPositionLane2/2-155, 30, Color.CYAN, 680, 1000, false, 1000, 1200/2+200);
    OtoTurnRight motoRightTurnRight = new OtoTurnRight(defautPositionLane2/2-173, 15, Color.red, 720, 1000, false, 200, 1200/2+200);
    //làn 2 rẽ trái
    OtoTurnLeft otoRightTurnLeft = new OtoTurnLeft(defautPositionLane2/2-47, 1000, 30, Color.CYAN, 500, 1200, false,1000, 1200/2+200);
    OtoTurnLeft motoRightTurnLeft = new OtoTurnLeft(defautPositionLane2/2-65, 1000, 15, Color.red, 480, 1200, false,200, 1200/2+200);

    //làn 3 đi thẳng
    OtoY otoY = new OtoY(30, Color.CYAN, defautPositionLane3/2-90, 1000, true, 1000, 1000/2-200);
    OtoY motoY = new OtoY(15, Color.red, defautPositionLane3/2-110, 1000, true, 200, 1000/2-200+15);
    //làn 3 rẽ phải
    OtoYTurnRight otoYTurnRight = new OtoYTurnRight(defautPositionLane3/2-40, 1000, 30, Color.CYAN, 500, 1200, true, 1000,1000/2-200);
    OtoYTurnRight motoYTurnRight = new OtoYTurnRight(defautPositionLane3/2-58, 1000, 15, Color.red, 540, 1200, true, 200,1000/2-200+15);
    //làn 3 rẽ trái
    OtoYTurnLeft otoYTurnLeft = new OtoYTurnLeft(defautPositionLane3/2-145, 1000, 30, Color.CYAN, 420, 1200, true, 1000, 1000/2-200);
    OtoYTurnLeft motoYTurnLeft = new OtoYTurnLeft(defautPositionLane3/2-165, 1000, 15, Color.red, 400, 1200, true, 200, 1000/2-200+15);

    //làn 4 đi thẳng
    OtoY otoYRight = new OtoY(30, Color.CYAN, defautPositionLane4/2-67, 1200, false, 1000, 1000/2-150);
    OtoY motoYRight = new OtoY(15, Color.red, defautPositionLane4/2-32, 1200, false, 200, 1000/2-135);

    OtoYTurnLeft otoYRightTurnLeft = new OtoYTurnLeft(defautPositionLane4/2-120, 1000, 30, Color.CYAN, 600, 1200, false, 1000, 1000/2-150);
    OtoYTurnLeft motoYRightTurnLeft = new OtoYTurnLeft(defautPositionLane4/2-87, 1000, 15, Color.red, 650, 1200, false, 200, 1000/2-135);
    OtoYTurnRight otoYRightTurnRight = new OtoYTurnRight(defautPositionLane4/2-13, 1000, 30, Color.CYAN, 400, 1200, false, 1000, 1000/2-150);
    OtoYTurnRight motoYRightTurnRight = new OtoYTurnRight(defautPositionLane4/2+20, 1000, 15, Color.red, 380, 1200, false, 200, 1000/2-135);


    boolean stop = false;
    boolean pause = false;
    int lane = 1;
    int countCar = 0;
    int countMoto = 0;
    int timeLane[] = new int[4];
    int time = 0;
    int totalTime = 0;
    int xGreenLight = 800;
    int yGreenLight = 650;
    int x2GreenLight = 840;
    int y2GreenLight = 675;
    int speed = 5;
    public void reset(){
        defautPositionLane1 = 1300;
        defautPositionLane2 = 1000;
        defautPositionLane3 = 1100;
        defautPositionLane4 = 1200;
        //size cửa sổ, nếu dọc là 1000, ngang là 1200
        //typeX = true thì là hướng dọc,
        //distanse khoảng cách giữa các xe, dùng để giảm số lượng xe ô tô
        //stopline vạch dừng
        //postionY vị trí vẽ
        //turnX vị trí rẽ

        //Làn 1 đi thẳng
        oto = new Oto(30, Color.CYAN, defautPositionLane1/2+20, 1000,  true, 1000, 1000/2+140);
        oto2 = new Oto(30, Color.CYAN, defautPositionLane1/2-40, 1000,  true, 1000, 1000/2+140);
        moto = new Oto(15, Color.red, defautPositionLane1/2+60, 1000, true, 200, 1000/2+140);
        moto2 = new Oto(15, Color.red, defautPositionLane1/2-5, 1000, true, 200, 1000/2+140);
        //Làn 1 rẽ trái
        motoTurnRight = new OtoTurnRight(defautPositionLane1/2-60, 15, Color.red, 400, 1000, true, 200, 1000/2+140);
        otoTurnRight = new OtoTurnRight(defautPositionLane1/2-95, 30, Color.CYAN, 430, 1000, true, 1000, 1000/2+140);
        //Làn 1 rẽ phải
        motoTurnLeft = new OtoTurnLeft(defautPositionLane1/2+120, 1000, 15, Color.red, 580, 1200, true, 200, 1000/2+140);
        otoTurnLeft = new OtoTurnLeft(defautPositionLane1/2+80, 1000, 30, Color.CYAN, 540, 1200, true, 1000, 1000/2+140);

        //làn 2 đi thẳng
        otoRight = new Oto(30, Color.CYAN, defautPositionLane2/2-100, 1200, false, 1000, 1200/2+200);
        motoRight = new Oto(15, Color.red, defautPositionLane2/2-120, 1200, false, 200, 1200/2+200);
        //làn 2 rẽ phải
        otoRightTurnRight = new OtoTurnRight(defautPositionLane2/2-155, 30, Color.CYAN, 680, 1000, false, 1000, 1200/2+200);
        motoRightTurnRight = new OtoTurnRight(defautPositionLane2/2-173, 15, Color.red, 720, 1000, false, 200, 1200/2+200);
        //làn 2 rẽ trái
        otoRightTurnLeft = new OtoTurnLeft(defautPositionLane2/2-47, 1000, 30, Color.CYAN, 500, 1200, false,1000, 1200/2+200);
        motoRightTurnLeft = new OtoTurnLeft(defautPositionLane2/2-65, 1000, 15, Color.red, 480, 1200, false,200, 1200/2+200);

        //làn 3 đi thẳng
        otoY = new OtoY(30, Color.CYAN, defautPositionLane3/2-90, 1000, true, 1000, 1000/2-200);
        motoY = new OtoY(15, Color.red, defautPositionLane3/2-110, 1000, true, 200, 1000/2-200+15);
        //làn 3 rẽ phải
        otoYTurnRight = new OtoYTurnRight(defautPositionLane3/2-40, 1000, 30, Color.CYAN, 500, 1200, true, 1000,1000/2-200);
        motoYTurnRight = new OtoYTurnRight(defautPositionLane3/2-58, 1000, 15, Color.red, 540, 1200, true, 200,1000/2-200+15);
        //làn 3 rẽ trái
        otoYTurnLeft = new OtoYTurnLeft(defautPositionLane3/2-145, 1000, 30, Color.CYAN, 420, 1200, true, 1000, 1000/2-200);
        motoYTurnLeft = new OtoYTurnLeft(defautPositionLane3/2-165, 1000, 15, Color.red, 400, 1200, true, 200, 1000/2-200+15);

        //làn 4 đi thẳng
        otoYRight = new OtoY(30, Color.CYAN, defautPositionLane4/2-67, 1200, false, 1000, 1000/2-150);
        motoYRight = new OtoY(15, Color.red, defautPositionLane4/2-32, 1200, false, 200, 1000/2-135);

        otoYRightTurnLeft = new OtoYTurnLeft(defautPositionLane4/2-120, 1000, 30, Color.CYAN, 600, 1200, false, 1000, 1000/2-150);
        motoYRightTurnLeft = new OtoYTurnLeft(defautPositionLane4/2-87, 1000, 15, Color.red, 650, 1200, false, 200, 1000/2-135);
        otoYRightTurnRight = new OtoYTurnRight(defautPositionLane4/2-13, 1000, 30, Color.CYAN, 400, 1200, false, 1000, 1000/2-150);
        motoYRightTurnRight = new OtoYTurnRight(defautPositionLane4/2+20, 1000, 15, Color.red, 380, 1200, false, 200, 1000/2-135);


        stop = false;
        pause = false;
        lane = 1;
        countCar = 0;
        countMoto = 0;
        time = 0;
        totalTime = 0;
        xGreenLight = 800;
        yGreenLight = 650;
        x2GreenLight = 840;
        y2GreenLight = 675;
        stop();
    }
    public void setTime(int timeLane1, int timeLane2, int timeLane3, int timeLane4){
        this.timeLane[0] = timeLane1;
        this.timeLane[1] = timeLane2;
        this.timeLane[2] = timeLane3;
        this.timeLane[3]= timeLane4;
    }
    public TapVe(){
        Thread threadTV = new Thread(this);
        threadTV.start();
        stop();
//        otoRightTurnRight.redLight(1200/2+150);
//        otoRightTurnLeft.redLight(1200/2+150);
    }
    public void stop(){
        otoRight.redLight();
        motoRight.redLight();
        //làn 2 rẽ phải
        otoRightTurnRight.redLight();
        motoRightTurnRight.redLight();
        //làn 2 rẽ trái
        otoRightTurnLeft.redLight();
        motoRightTurnLeft.redLight();

        //làn 3 đi thẳng
        otoY.redLight();
        motoY.redLight();
        //làn 3 rẽ phải
        otoYTurnRight.redLight();
        motoYTurnRight.redLight();
        //làn 3 rẽ trái
        otoYTurnLeft.redLight();
        motoYTurnLeft.redLight();

        //làn 4 đi thẳng
        otoYRight.redLight();
        motoYRight.redLight();
        //làn 4 rẽ trái
        otoYRightTurnLeft.redLight();
        motoYRightTurnLeft.redLight();
        //làn 4 rẽ phải
        otoYRightTurnRight.redLight();
        motoYRightTurnRight.redLight();
        this.timeLane[0] = 45;
        this.timeLane[1] = 15;
        this.timeLane[2] = 15;
        this.timeLane[3]= 15;
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(getWidth()/2-210,0,410,getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(0,getHeight()/2-150,getWidth(),310);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
//        g.drawString("Time: "+String.valueOf(Math.round((timeLane[lane-1]*50-time)/50)),30,850);
        g.drawString("Tổng Thời gian: "+String.valueOf(Math.round(totalTime/50)),30,840);
        g.drawString("Oto: "+String.valueOf(countCar),30,870);
        g.drawString("Moto: "+String.valueOf(countMoto),30,900);
        g.drawString("Tây Sơn 2",30,670);
        g.drawString("Tây Sơn 1",950,300);
        g.drawString("Chùa Bộc",820,900);
        g.drawString("Thái Hà",270,70);
        g.setColor(Color.green);
        g.fillOval(xGreenLight,yGreenLight,30,30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(Math.round((timeLane[lane-1]*50-time)/50)),x2GreenLight, y2GreenLight);
        //làn 1 đi thẳng
        oto.paint(g);
        oto2.paint(g);
        moto.paint(g);
        moto2.paint(g);
        //làn 1 rẽ phải
        motoTurnRight.paint(g);
        otoTurnRight.paint(g);
        //làn 1 rẽ trái
        otoTurnLeft.paint(g);
        motoTurnLeft.paint(g);

        //làn 2 đi thẳng
        otoRight.paint(g);
        motoRight.paint(g);
        //làn 2 rẽ phải
        otoRightTurnRight.paint(g);
        motoRightTurnRight.paint(g);
        //làn 2 rẽ trái
        otoRightTurnLeft.paint(g);
        motoRightTurnLeft.paint(g);

        //làn 3 đi thẳng
        otoY.paint(g);
        motoY.paint(g);
        //làn 3 rẽ trái
        otoYTurnLeft.paint(g);
        motoYTurnLeft.paint(g);
        //làn 3 rẽ phải
        otoYTurnRight.paint(g);
        motoYTurnRight.paint(g);

        //làn 4 đi thẳng
        otoYRight.paint(g);
        motoYRight.paint(g);
        //làn 4 rẽ phải
        otoYRightTurnLeft.paint(g);
        motoYRightTurnLeft.paint(g);
        //làn 4 rẽ trái
        otoYRightTurnRight.paint(g);
        motoYRightTurnRight.paint(g);

    }
    public void run() {
        while (true){
            repaint();
            time++;
            totalTime++;
            if(time == timeLane[lane-1]*50){
                setStop();
                setRun();
                time =0;
            }
            if(pause == false){
                //làn 1 đi thẳng
                oto.goX();
                oto2.goX();
                moto.goX();
                moto2.goX();
                //làn 1 rẽ phải
                motoTurnRight.goX();
                otoTurnRight.goX();
                //làn 1 rẽ trái
                otoTurnLeft.goX();
                motoTurnLeft.goX();

                //làn 2 đi thẳng
                otoRight.goX();
                motoRight.goX();
                //làn 2 rẽ phải
                otoRightTurnRight.goX();
                motoRightTurnRight.goX();
                //làn 2 rẽ trái
                otoRightTurnLeft.goX();
                motoRightTurnLeft.goX();

                //làn 3 đi thẳng
                otoY.goX();
                motoY.goX();
                //làn 3 ré trái
                otoYTurnLeft.goX();
                motoYTurnLeft.goX();
                //làn 3 rẽ phải
                otoYTurnRight.goX();
                motoYTurnRight.goX();

                //làn 4 đi thẳng
                otoYRight.goX();
                motoYRight.goX();
                //làn 4 rẽ phải
                otoYRightTurnLeft.goX();
                motoYRightTurnLeft.goX();
                //làn 4 rẽ trái
                otoYRightTurnRight.goX();
                motoYRightTurnRight.goX();
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(pause == false){
                //làn 1 đi thẳng
                oto.laplaiX();
                oto2.laplaiX();
                moto.laplaiX();
                moto2.laplaiX();
                //làn 1 rẽ phải
                motoTurnRight.laplaiX();
                otoTurnRight.laplaiX();
                //làn 1 rẽ trái
                otoTurnLeft.laplaiX();
                motoTurnLeft.laplaiX();

                //làn 2 đi thẳng
                otoRight.laplaiX();
                motoRight.laplaiX();
                //làn 2 rẽ phải
                otoRightTurnRight.laplaiX();
                motoRightTurnRight.laplaiX();
                //làn 2 rẽ trái
                otoRightTurnLeft.laplaiX();
                motoRightTurnLeft.laplaiX();

                //làn 3 đi thẳng
                otoY.laplaiX();
                motoY.laplaiX();
                //làn 3 rẽ phải
                otoYTurnRight.laplaiX();
                motoYTurnRight.laplaiX();
                //làn 3 rẽ trái
                otoYTurnLeft.laplaiX();
                motoYTurnLeft.laplaiX();

                //làn 4 đi thẳng
                otoYRight.laplaiX();
                motoYRight.laplaiX();
                //làn 4 rẽ phải
                otoYRightTurnLeft.laplaiX();
                motoYRightTurnLeft.laplaiX();
                //làn 4 rẽ trái
                otoYRightTurnRight.laplaiX();
                motoYRightTurnRight.laplaiX();
                //đếm xe
                countCar=oto.getCountCar()+oto2.getCountCar()+otoTurnLeft.getCountCar()+otoTurnRight.getCountCar()+otoRight.getCountCar()
                        +otoRightTurnRight.getCountCar()+otoRightTurnLeft.getCountCar()+otoYTurnRight.getCountCar()+otoYTurnLeft.getCountCar()
                        +otoYRight.getCountCar()+otoYRightTurnLeft.getCountCar()+otoYRightTurnRight.getCountCar();
                countMoto=moto.getCountCar()+moto2.getCountCar()+motoTurnLeft.getCountCar()+motoTurnRight.getCountCar()+ motoRight.getCountCar()
                        +motoRightTurnRight.getCountCar()+motoRightTurnLeft.getCountCar()+ motoYTurnRight.getCountCar()+motoYTurnLeft.getCountCar()
                        +motoYRight.getCountCar()+motoYRightTurnLeft.getCountCar()+motoYRightTurnRight.getCountCar();
            }
        }
    }
    public void setStop(){
        if( lane == 1){
            // đi thẳng
            oto.redLight();
            oto2.redLight();
            moto.redLight();
            moto2.redLight();
            //rẽ phải
            otoTurnRight.redLight();
            motoTurnRight.redLight();
            //rẽ trái
            otoTurnLeft.redLight();
            motoTurnLeft.redLight();
            xGreenLight = 800;
            yGreenLight = 280;
            x2GreenLight = 840;
            y2GreenLight = 305;
        }
        if( lane == 2){
            //đi thẳng
            otoRight.redLight();
            motoRight.redLight();
            //rẽ phải
            otoRightTurnRight.redLight();
            motoRightTurnRight.redLight();
            //làn 2 rẽ trái
            otoRightTurnLeft.redLight();
            motoRightTurnLeft.redLight();
            xGreenLight = 330;
            yGreenLight = 280;
            x2GreenLight = 300;
            y2GreenLight = 305;
        }
        if( lane == 3){
            //làn 3 đi thẳng
            otoY.redLight();
            motoY.redLight();
            //rẽ phải
            otoYTurnRight.redLight();
            motoYTurnRight.redLight();
            //rẽ trái
            otoYTurnLeft.redLight();
            motoYTurnLeft.redLight();
            xGreenLight = 330;
            yGreenLight = 650;
            x2GreenLight = 300;
            y2GreenLight = 675;
        }
        if( lane == 4){
            otoYRight.redLight();
            motoYRight.redLight();
            otoYRightTurnRight.redLight();
            motoYRightTurnRight.redLight();
            otoYRightTurnLeft.redLight();
            motoYRightTurnLeft.redLight();
            xGreenLight = 800;
            yGreenLight = 650;
            x2GreenLight = 840;
            y2GreenLight = 675;
        }
        if( lane == 4){
            lane = 1;
        }else {
            lane++;
        }
    }
    public void setRun(){
        if( lane == 1){
            //đi thẳng
            oto.greenLight();
            oto2.greenLight();
            moto.greenLight();
            moto2.greenLight();
            //rẽ phải
            otoTurnRight.greenLight();
            motoTurnRight.greenLight();
            //rẽ trái
            otoTurnLeft.greenLight();
            motoTurnLeft.greenLight();
        }
        if( lane ==2){
            //đi thẳng
            otoRight.greenLight();
            motoRight.greenLight();
            //rẽ phải
            otoRightTurnRight.greenLight();
            motoRightTurnRight.greenLight();
            //làn 2 rẽ trái
            otoRightTurnLeft.greenLight();
            motoRightTurnLeft.greenLight();
        }
        if( lane ==3){
            //đi thẳng
            otoY.greenLight();
            motoY.greenLight();
            //rẽ phải
            otoYTurnRight.greenLight();
            motoYTurnRight.greenLight();
            //rẽ trái
            otoYTurnLeft.greenLight();
            motoYTurnLeft.greenLight();
        }
        if( lane == 4){
            otoYRight.greenLight();
            motoYRight.greenLight();
            otoYRightTurnRight.greenLight();
            motoYRightTurnRight.greenLight();
            otoYRightTurnLeft.greenLight();
            motoYRightTurnLeft.greenLight();
        }
    }
    public void showPosition(){
        oto.showPosition();
    }
    public void pause(){
        this.pause = ! this.pause;
    }
}
