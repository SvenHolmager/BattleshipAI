/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y8;

import battleships.BattleshipAI;
import battleships.Board;
import battleships.Fleet;
import battleships.Position;
import battleships.Ship;
import java.util.Random;

/**
 *
 * @author Tobias
 */
public class MyAI implements BattleshipAI {

    private static final Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    private int nextX;
    private int nextY;
    private boolean lastAttackHit;

    @Override
    public String getName() {
        return "y8";
    }

    @Override
    public void newMatch(int rounds) {
        //Do nothing
    }

    @Override
    public void placeShips(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {


            Ship s = fleet.getShip(0);
            boolean vertical = rnd.nextBoolean();
            Position pos;
            if (vertical) {
                int x = rnd.nextInt(sizeX);
                int y = rnd.nextInt(sizeY - (s.size() - 1));
                pos = new Position(x, y);
            } else {
                int x = rnd.nextInt(sizeX - (s.size() - 1));
                int y = rnd.nextInt(sizeY);
                pos = new Position(x, y);
            }
            board.placeShip(pos, s, vertical);
        }
    }

    @Override
    public void incoming(Position pos) {
        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips) {

        Position shot = new Position(nextX, nextY);
        ++nextX;
        if (nextX >= sizeX) {
            nextX = 0;
            ++nextY;
            if (nextY >= sizeY) {
                nextY = 0;
                nextX++;
            }
        }

        return shot;
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips) {
        if (hit) {
            lastAttackHit = true;
        } else {
            lastAttackHit = false;
        }
    }
}
