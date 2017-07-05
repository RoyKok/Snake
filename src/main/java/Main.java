import org.newdawn.slick.*;
import pojo.Body;
import pojo.DirectionEnum;
import pojo.Food;
import pojo.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Roy on 21-6-2017.
 *
 */
public class Main extends BasicGame {

    public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 480;

    private Random random = new Random();

    private Snake snake;
    private Input input;
    private int score = 0;

    private long delayMillis = 3000;
    private long oldTime;

    private List<Food> foodList = new ArrayList<>();
    private List<Food> removeFoodList = new ArrayList<>();

    public static void main (String[] args) throws SlickException {

        AppGameContainer appGameContainer;
        appGameContainer = new AppGameContainer(new Main("Snake"));
        appGameContainer.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
        appGameContainer.setTargetFrameRate(144);
        //appGameContainer.setMinimumLogicUpdateInterval(100);
        //appGameContainer.setMaximumLogicUpdateInterval(200);
        appGameContainer.start();
    }

    public Main(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {

        foodList.add(new Food(610, 450));

        input = gameContainer.getInput();
        // Initialise the snake
        snake = new Snake(50, 50, 0, 1, DirectionEnum.RIGHT);
        snake.setSpeed(1);

        oldTime = System.currentTimeMillis();
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (input.isKeyPressed(Input.KEY_DOWN)){
            snake.setDirection(DirectionEnum.DOWN);
        }

        if (input.isKeyPressed(Input.KEY_UP)){
            snake.setDirection(DirectionEnum.UP);
        }

        if (input.isKeyPressed(Input.KEY_LEFT)){
            snake.setDirection(DirectionEnum.LEFT);
        }

        if (input.isKeyPressed(Input.KEY_RIGHT)){
            snake.setDirection(DirectionEnum.RIGHT);
        }

        if (input.isKeyPressed(Input.KEY_SPACE)){
            snake.addNewBodyPart();
        }

        if (delay(delayMillis)){
            foodList.add(new Food(randomXLocation(), randomYLocation()));
        }

        for (Food food : foodList){

            if (snake.intersects(food)){
                removeFoodList.add(food);
                snake.addNewBodyPart();
                score += 10;
            }
        }

        foodList.removeAll(removeFoodList);

        snake.update(delta);


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawString("Score: " + score, 100, 10);

        snake.getImage().draw(snake.getX(), snake.getY(), Snake.imageHeight, Snake.imageWidth);

        for (Body body : snake.getBodyParts()){
            body.getImage().draw(body.getxPos(), body.getyPos(), Snake.imageHeight, Snake.imageWidth);
        }

        for (Food food : foodList){
            food.getImage().draw(food.getX(), food.getY(), 15, 15);
        }

    }

    private boolean delay(long delayMillis){
        if (oldTime + delayMillis < System.currentTimeMillis()){
            oldTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    private int randomYLocation(){

        int randomYLocation = 25 + (25 * random.nextInt(20));

        if (randomYLocation > 455){
            randomYLocation = 455;
        }

        return randomYLocation;
    }


    private int randomXLocation(){

        int randomXLocation = 25 + (25 * random.nextInt(25));

        if (randomXLocation > 615){
            randomXLocation = 615;
        }

        return randomXLocation;
    }
}
