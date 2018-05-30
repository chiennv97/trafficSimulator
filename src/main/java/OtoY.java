import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class OtoY extends JPanel {
    LinkedList<Position> postions;
    Random rd;
    boolean stop;
    int numberCar = 20;
    int sizeCar;
    java.awt.Color color;
    int positionY;
    int size;
    boolean typeX;
    int distance;
    int stopline;
    int countCar=0;
    public OtoY(int sizeCar, java.awt.Color color, int positionY, int size, boolean typeX, int distance, int stopline){
        this.postions = new LinkedList<Position>();
        this.sizeCar = sizeCar;
        this.color = color;
        this.rd = new Random();
        this.positionY = positionY;
        this.size  = size;
        this.typeX = typeX;
        this.distance = distance;
        this.stopline = stopline;
        this.postions.add(new Position(-this.rd.nextInt(distance) -sizeCar,size+sizeCar,false));
        for( int i=1; i<numberCar; i++){
            this.postions.add(new Position(postions.get(i-1).x -this.rd.nextInt(distance)-50, size+sizeCar, false));
        }
    }
    public void paint(Graphics g){
        if(typeX){
            for(int i=0; i< numberCar; i++){
                g.setColor(color);
                g.fillRect(positionY, postions.get(i).x,  sizeCar, sizeCar);
            }
        } else{
            for(int i=0; i< numberCar; i++){
                g.setColor(color);
                g.fillRect( postions.get(i).x, positionY, sizeCar, sizeCar);
            }
        }

    }
    public void goX(){
        for( int i=0; i<numberCar; i++){
            if( postions.get(i).x < postions.get(i).xStop){
                postions.get(i).x = postions.get(i).x +2;
            }
            if(postions.get(i).x > stopline+5){
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
            if(postions.get(i).x < stopline && this.stop == true){
                postions.get(i).xStop = postions.get(i-1).xStop - sizeCar -15;
            }
            if( postions.get(i).x < stopline && this.stop == false){
                postions.get(i).xStop = stopline;
                stop = true;
            }
        }
    }
    public void greenLight(){
        this.stop = false;
        for( int i=0; i<numberCar; i++){
            postions.get(i).xStop = size+sizeCar;
        }
    }
    public void laplaiX(){
//        for(int i=0; i<10;i++){
        if(postions.get(0).x >= size+sizeCar){
//                showPosition();
//                System.out.println("true");
            if(postions.get(numberCar-1).x < 0){
                postions.get(0).x = postions.get(numberCar-1).x - this.rd.nextInt(distance)-sizeCar;
            }else {
                postions.get(0).x = -this.rd.nextInt(distance);
            }
            if(this.stop){
                postions.get(0).xStop= postions.get(numberCar-1).xStop - sizeCar-15;
            }else {
                postions.get(0).xStop= size+sizeCar;
            }
//            postions.addLast(postions.poll());
//                showPosition();
            Position tempPos = postions.poll();
            tempPos.count = false;
            postions.addLast(tempPos);
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
            System.out.println();
        }
        System.out.println();
    }
    public int getCountCar() {
        return countCar;
    }
}
