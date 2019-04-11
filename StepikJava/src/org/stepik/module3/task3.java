package org.stepik.module3;

import java.util.Scanner;

public class task3{
    
    private static Scanner scanner = new Scanner(System.in);
    
    private static Robot robot;
    
    public static void task() {
        robot = new Robot(0, 0, Direction.UP);
        printPos(robot);
        
        System.out.println("Куда следует отправить робота? Напишите координаты x и y");
        
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        moveRobot(robot, x, y);
        printPos(robot);
        
    }
    
    
    private enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    
    private static void printPos(Robot robot) {
        System.out.println("Позиция x = " + robot.getX());
        System.out.println("Позиция y = " + robot.getY());
        System.out.println("Смотрит = " + robot.getDirection().name());
    }
    
    /**
     * @author Egor_Stepanov
     */
    private static class Robot{
        int x;
        int y;
        Direction dir;
        
        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        
        public Direction getDirection() {
            return dir;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }
        
        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }
        
        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }
    
    public static void moveRobot(Robot robot, int toX, int toY) {
        
        if (toX > robot.getX()) {
            rotRobot(robot, Direction.RIGHT);
            
            int n = toX - robot.getX();
            for (int i = 0; i < n; i++) {
                robot.stepForward();
            }
            
        } else if (toX < robot.getX()) {
            rotRobot(robot, Direction.LEFT);
            
            int n = robot.getX() - toX;
            for (int i = 0; i < n; i++) {
                robot.stepForward();
            }
            
        }
        
        if (toY > robot.getY()) {
            rotRobot(robot, Direction.UP);
            
            int n = toY - robot.getY();
            for (int i = 0; i < n; i++) {
                robot.stepForward();
            }
            
        } else if (toY < robot.getY()) {
            rotRobot(robot, Direction.DOWN);
            
            int n = robot.getY() - toY;
            for (int i = 0; i < n; i++) {
                robot.stepForward();
            }
            
        }
        
    }
    
    public static void rotRobot (Robot robot, Direction destDir) {
        
        while (robot.getDirection() != destDir)
            robot.turnRight();
        
    }
}