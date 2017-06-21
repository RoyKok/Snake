package pojo;


import org.newdawn.slick.*;


/**
 * Created by Roy on 22-6-2017.
 *
 */
public class Body {

    private int xPos;
    private int yPos;
    private int xPosOld;
    private int yPosOld;
    private Image image;

    public Body (int x, int y) throws SlickException {
        this.xPos = x;
        this.yPos = y;

        image = new Image("res/snake.png");
    }

    public void updatePosition(int x, int y){
        xPosOld = xPos;
        yPosOld = yPos;
        xPos = x;
        yPos = y;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
}
