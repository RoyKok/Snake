package pojo;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy on 21-6-2017.
 *
 */
public class Snake{

    public static final int imageWidth = 25;
    public static final int imageHeight = 25;

    private int xPos;
    private int yPos;
    private int speed;
    private int length;
    private DirectionEnum direction;
    private Image image;

    private int xPosOld;
    private int yPosOld;
    private List<Body> bodyParts = new ArrayList<Body>();

    public Snake(int xPos, int yPos, int speed, int length, DirectionEnum direction) throws SlickException {
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
        this.length = length;
        this.direction = direction;

        image = new Image("res/snake.png");

    }

    public void addNewBodyPart() throws SlickException {
        if (bodyParts.size() == 0){
            //This is the first bodyPart
            bodyParts.add(new Body(xPosOld, yPosOld));
        } else {
            //Get the last Body in the list
            Body body = bodyParts.get(bodyParts.size()-1);
            bodyParts.add(new Body(body.getxPosOld(), body.getyPosOld()));
        }
    }

    public void update(){

        //set the position of the snake
        updatePosition();

    }

    private void updatePosition(){

        xPosOld = xPos;
        yPosOld = yPos;

        for (int i=0; i<bodyParts.size(); i++){

            Body body = bodyParts.get(i);

            //This is the first body part after the head, this one needs the x,y from the head.
            if (i==0){
                body.updatePosition(xPosOld, yPosOld);
            } else {
                //We need x,y from the part above this one.
                body.updatePosition(bodyParts.get(i-1).getxPosOld(), bodyParts.get(i-1).getyPosOld());
            }

        }


        switch(direction){

            case UP:
                yPos = yPos - imageHeight;
                if (yPos < 0){
                    yPos = 480;
                }
                break;
            case DOWN:
                yPos = yPos + imageHeight;
                if (yPos > 480){
                    yPos = 0;
                }
                break;
            case LEFT:
                xPos = xPos - imageWidth;
                if (xPos < 0){
                    xPos = 640;
                }
                break;
            case RIGHT:
                xPos = xPos + imageWidth;
                if (xPos > 640){
                    xPos = 0;
                }
                break;
        }

    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Enum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public Image getImage() {
        return image;
    }

    public int getxPosOld() {
        return xPosOld;
    }

    public void setxPosOld(int xPosOld) {
        this.xPosOld = xPosOld;
    }

    public int getyPosOld() {
        return yPosOld;
    }

    public void setyPosOld(int yPosOld) {
        this.yPosOld = yPosOld;
    }

    public List<Body> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<Body> bodyParts) {
        this.bodyParts = bodyParts;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
