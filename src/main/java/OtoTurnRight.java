import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class OtoTurnRight extends JPanel {
    LinkedList<PositionExtend> postions;
    Random rd;
    boolean stop;
    int numberCar = 20;
    int sizeCar;
    int positionY;
    java.awt.Color color;
    int turnX;
    int size;
    boolean typeX;
    int distance;
    int stopline;
    int countCar=0;
    public OtoTurnRight(int positionY, int sizeCar, java.awt.Color color, int turnX, int size, boolean typeX, int distance, int stopline){
        this.positionY = positionY;
        this.sizeCar = sizeCar;
        this.color = color;
        this.turnX = turnX;
        this.size  = size;
        this.typeX = typeX;
        this.distance = distance;
        this.stopline = stopline;
        this.postions = new LinkedList<PositionExtend>();
        this.rd = new Random();
        this.postions.add(new PositionExtend(this.rd.nextInt(200) + size, this.turnX, this.positionY, false));
        for( int i=1; i<numberCar; i++){
            this.postions.add(new PositionExtend(postions.get(i-1).x + this.rd.nextInt(distance)+120, this.turnX, this.positionY, false));
        }
    }
    public void paint(Graphics g){
        if(typeX){
            for(int i=0; i< numberCar; i++){
                g.setColor(color);
                g.fillRect(postions.get(i).y, postions.get(i).x, sizeCar, sizeCar);
            }
        }else {
            for(int i=0; i< numberCar; i++){
                g.setColor(color);
                g.fillRect(postions.get(i).x, postions.get(i).y,  sizeCar, sizeCar);
            }
        }

    }
    public void goX(){
        for( int i=0; i<numberCar; i++){
            if( postions.get(i).x > postions.get(i).xStop){
                postions.get(i).x = postions.get(i).x -2;
            }
            if( postions.get(i).x <= turnX){
                postions.get(i).y = postions.get(i).y -2;
            }
            if(postions.get(i).x < stopline -5){
                if(postions.get(i).count==false){
                    countCar++;
                    postions.get(i).count = true;
                }
            }
        }
    }
    public void redLight(){
        this.stop = false;
        for( int i=0; i<numberCar; i++){
            if(postions.get(i).x > stopline && this.stop == true){
                postions.get(i).xStop = postions.get(i-1).xStop + sizeCar +15;
            }
            if( postions.get(i).x > stopline && this.stop == false){
                postions.get(i).xStop = stopline;
                stop = true;
            }
        }
    }
    public void greenLight(){
        this.stop = false;
        for( int i=0; i<numberCar; i++){
            postions.get(i).xStop = turnX;
        }
    }
    public void laplaiX(){
//        for(int i=0; i<10;i++){
        if(postions.get(0).y <= -sizeCar){
//                showPosition();
            if(postions.get(numberCar-1).x > size){
                postions.get(0).x = postions.get(numberCar-1).x + this.rd.nextInt(distance)+120;
            }else {
                postions.get(0).x = this.rd.nextInt(distance) + size;
            }
            postions.get(0).y = this.positionY;
            if(this.stop){
                postions.get(0).xStop= postions.get(numberCar-1).xStop + sizeCar+15;
            }else {
                postions.get(0).xStop= turnX;
            }
            PositionExtend tempPos = postions.poll();
            tempPos.count = false;
            postions.addLast(tempPos);
//            postions.addLast(postions.poll());
//                showPosition();
        }
//        }
    }
    public void showPosition(){
        for(int i=0; i<numberCar;i++){
            System.out.print(i);
            System.out.print(' ');
            System.out.print(postions.get(i).x );
            System.out.print(' ');
            System.out.print(postions.get(i).xStop );
            System.out.print(' ');
            System.out.print(postions.get(i).y );
            System.out.println();
        }
        System.out.println();
    }
    public int getCountCar() {
        return countCar;
    }
}
