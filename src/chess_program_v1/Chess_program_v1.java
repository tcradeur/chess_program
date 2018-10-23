/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_program_v1;

/**
 *
 * @author trent
 */
import java.util.Scanner;

public class Chess_program_v1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        Move_check my_check = new Move_check();
        Board my_board = new Board();
        boolean end_of_game = false;
        String move;
        int x_start;
        int y_start;
        int x_finish;
        int y_finish;
        
        int legal_move = 1;
        int move_success;
        
        my_board.setup_board();
        
        
        //loop through players until game is finished
        
        while(end_of_game == false){
            
            do{
                //print the board
                my_board.print_board();
                //white player goes first
                System.out.println("White player move(from,to)(xy,xy):");
                move=scan.nextLine();
            
                //check input
                if(my_check.input_check(move) == 1){
                    System.out.println("Improper input, try again.");
                    legal_move=1;
                }else{
                    //convert sent int string to int for 2D array to use
                    x_start = x_convert(move.substring(0,1));
                    y_start = (Integer.parseInt(move.substring(1,2)) - 1);
                    x_finish = x_convert(move.substring(3,4));
                    y_finish = (Integer.parseInt(move.substring(4)) - 1);
                
                    //check if move is legal
                    legal_move = my_check.check_move(x_start,y_start,x_finish,y_finish,'W',my_board);
                
                    if(legal_move == 0){
                        move_success = my_board.move_piece(x_start, y_start, x_finish, y_finish);
                    }
                } 
                //legal_move = 0;
            //this should be a move_success check
            }while(legal_move != 0);
            
            legal_move = 1;
        
            do{  
                //print the board
                my_board.print_board();
                System.out.println("Black player move(from,to)(xy,xy):");
                move=scan.nextLine();
            
                //check input
                if(my_check.input_check(move) == 1){
                    System.out.println("Improper input, try again.");
                    legal_move=1;
                }else{
                    //convert sent int string to int for 2D array to use
                    x_start = x_convert(move.substring(0,1));
                    y_start = (Integer.parseInt(move.substring(1,2)) - 1);
                    x_finish = x_convert(move.substring(3,4));
                    y_finish = (Integer.parseInt(move.substring(4)) - 1);
                
                    //check if move is legal
                    legal_move = my_check.check_move(x_start,y_start,x_finish,y_finish,'B',my_board);
                
                    if(legal_move == 0){
                        move_success = my_board.move_piece(x_start, y_start, x_finish, y_finish);
                    }
                }
            //black player goes
            }while(legal_move != 0);
            
        }
        
        
        

    }
    
    static private void player_move(){
        
    }
    
    //takes a passed in String and converts it to an int
    static private int x_convert(String x){
        switch(x){
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
        }
        //return number that can be identified as an error
        return 10;
    }
    
}
