import org.newdawn.slick.*;
import pojo.DirectionEnum;
import pojo.Snake;

/**
 * Created by Roy on 21-6-2017.
 *
 */
public class Main extends BasicGame {

    public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 480;

    private Snake snake;
    private Input input;

    public static void main (String[] args) throws SlickException {

        AppGameContainer appGameContainer;
        appGameContainer = new AppGameContainer(new Main("Snake"));
        appGameContainer.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
        appGameContainer.setTargetFrameRate(144);
        appGameContainer.setMinimumLogicUpdateInterval(100);
        appGameContainer.setMinimumLogicUpdateInterval(200);
        appGameContainer.start();
    }

    public Main(String title) {
        super(title);
    }

    public void init(GameContainer gameContainer) throws SlickException {

        input = gameContainer.getInput();

        // Initialise the snake
        snake = new Snake(50, 50, 0, 1, DirectionEnum.RIGHT);
        snake.setSpeed(1);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

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

        //
        snake.update();


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        snake.getImage().draw(snake.getxPos(), snake.getyPos(), Snake.imageHeight, Snake.imageWidth);

    }
}
