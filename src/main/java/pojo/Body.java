package pojo;


import org.newdawn.slick.*;


/**
 * Created by Roy on 22-6-2017.
 *
 */
public class Body {

    private float xPos;
    private float yPos;
    private float xPosOld;
    private float yPosOld;
    private Image image;

    public Body (float x, float y) throws SlickException {
        this.xPos = x;
        this.yPos = y;

        image = new Image("res/snake.png");
    }

    public void updatePosition(float x, float y, float delta){
        xPosOld = xPos;
        yPosOld = yPos;
        xPos = xPos + (x - xPos);
        yPos = yPos + (y - yPos);
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
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
}
