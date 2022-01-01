package ru.geekbrains.home_work_app;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import ru.geekbrains.home_work_app.GameSnake;

public class Snake {
    private LinkedList<Cell> snake;
    private int direction;
    private Food food;
//    private Poison poison;

    public Snake (int x, int y, int length, int direction) {
        snake = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            snake.add(new Cell(x - i, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_COLOR));
        }
        this.direction = direction;
    }

    public void setDirection(int direction) {
        if ((direction >= GameSnake.KEY_LEFT) && (direction <= GameSnake.KEY_DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public boolean isInSnake(int x, int y) {
        for (Cell cell : snake) {
            if ((cell.getX() == x) && (cell.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        switch (direction) {
            case GameSnake.KEY_LEFT: x--;
                if (x < 0)
                    x = GameSnake.CANVAS_WIDTH - 1;
                    break;
            case GameSnake.KEY_RIGHT: x++;
                if (x == GameSnake.CANVAS_WIDTH)
                    x = 0;
                    break;
            case GameSnake.KEY_UP: y--;
                if (y < 0)
                    y = GameSnake.CANVAS_HEIGHT - 1;
                    break;
            case GameSnake.KEY_DOWN: y++;
                if (y == GameSnake.CANVAS_HEIGHT)
                    y = 0;
                    break;
        }



        if (isInSnake(x, y)) {
            GameSnake.gameOver = true;
            return;
        }

        snake.addFirst(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_COLOR));

        if (food.isFood(x, y)) {
            food.eat();
        }
//        else if (poison.isPoison(x, y)) {
//            snake.removeLast();
//            snake.removeLast();
//        }
        else {
            snake.removeLast();
        }
    }

    public int size() {
        return snake.size();
    }

    public void setFood(Food food) {
        this.food = food;
    }

//    public void setPoison(Poison poison) {
//        this.food = food--;
//    }

    public void paint(Graphics2D g) {
        for (Cell cell : snake) {
            cell.paint(g);
        }
    }
}
