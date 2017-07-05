package pojo;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy on 21-6-2017.
 *
 */
public class Snake extends Rectangle{

    public static final int imageWidth = 25;
    public static final int imageHeight = 25;

    private int speed;
    private int length;
    private DirectionEnum direction;
    private Image image;

    private float xPosOld;
    private float yPosOld;
    private List<Body> bodyParts = new ArrayList<Body>();

    public Snake(float xPos, float yPos, int speed, int length, DirectionEnum direction) throws SlickException {
        super(xPos, yPos, 25, 25);
        this.speed = speed;
        this.length = length;
        this.direction = direction;

        image = new Image("res/snake.png");

    }

    public void addNewBodyPart() throws SlickException {
        if (bodyParts.size() == 0){
            //This is the first bodyPart
            bodyParts.add(new Body(xPosOld-25, yPosOld-25));
        } else {
            //Get the last Body in the list
            Body body = bodyParts.get(bodyParts.size()-1);
            bodyParts.add(new Body(body.getxPosOld()-25, body.getyPosOld()-25));
        }
    }

    public void update(int delta){

        //set the position of the snake
        updatePosition(delta);

    }

    private void updatePosition(int delta){

        xPosOld = x;
        yPosOld = y;

        for (int i=0; i<bodyParts.size(); i++){

            Body body = bodyParts.get(i);

            //This is the first body part after the head, this one needs the x,y from the head.
            if (i==0){
                body.updatePosition(xPosOld, yPosOld, delta);
            } else {
                //We need x,y from the part above this one.
                body.updatePosition(bodyParts.get(i-1).getxPosOld(), bodyParts.get(i-1).getyPosOld(), delta);
            }

        }


        switch(direction){

            case UP:
                y = y - (delta / 5) ;
                if (y < 0){
                    y = 480;
                }
                break;
            case DOWN:
                y = y + (delta / 5) ;
                if (y > 480){
                    y = 0;
                }
                break;
            case LEFT:
                x = x - (delta / 5) ;
                if (x < 0){
                    x = 640;
                }
                break;
            case RIGHT:
                x = x + (delta / 5) ;
                if (x > 640){
                    x = 0;
                }
                break;
        }

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

    public float getxPosOld() {
        return xPosOld;
    }

    public void setxPosOld(int xPosOld) {
        this.xPosOld = xPosOld;
    }

    public float getyPosOld() {
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
