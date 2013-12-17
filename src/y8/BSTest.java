/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package y8;

import battleships.BattleshipAI;
import battleships.exampleplayers.RandomPlayer;
import battleships.exampleplayers.SystematicShooter;
import battleships.game.Game;
import battleships.game.GameResult;

/**
 *
 * @author Tobias
 */
public class BSTest
{

    public static void main(String[] args)
    {
        int pointsA = 0;
        int pointsB = 0;
        int[] ships = {2,3,3,4,5};
        Game game = new Game(10,10, ships);
        
        BattleshipAI pa = new SystematicShooter();
        BattleshipAI pb = new MyAI();
        for(int i = 0; i < 100; ++i)
        {
            GameResult res = game.playRound(pa, pb);
            if(res == GameResult.AWINS) pointsA++;
            else if(res == GameResult.BWINS) pointsB++;
        }
        System.out.println(pa.getName() + ": " + pointsA);
        System.out.println(pb.getName() + ": " + pointsB);
    }
    
}
