package ru.geekbrains.home_work_app;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import ru.geekbrains.home_work_app.Cell;
import ru.geekbrains.home_work_app.Snake;

public class Food extends Cell {
    private Random random;
    private Snake snake;

    public Food(Snake snake) {
        super(-1, -1, GameSnake.CELL_SIZE, GameSnake.FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public boolean isFood(int x, int y) {
        return (getX() == x) && (getY() == y);
    }

    public boolean isEaten() {
        return getX() == -1;
    }

    public void eat() {
        set(-1, -1);
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(GameSnake.CANVAS_WIDTH);
            y = random.nextInt(GameSnake.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y));    //  || poison.isPoison(x, y)
        set(x, y);
    }
}
