package pojo;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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



    public Snake(int xPos, int yPos, int speed, int length, DirectionEnum direction) throws SlickException {
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
        this.length = length;
        this.direction = direction;

        image = new Image("res/snake.png");

    }

    public void update(){

        //set the position of the snake
        updatePosition();

    }

    private void updatePosition(){

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

    public void setImage(Image image) {
        this.image = image;
    }
}
