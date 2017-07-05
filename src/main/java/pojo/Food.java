package pojo;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by Roy on 24-6-2017.
 *
 */
public class Food extends Rectangle{

    private Image image;

    public Food(int xPos, int yPos) throws SlickException {
        super(xPos, yPos, 25, 25);

        image = new Image("res/food.png");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
