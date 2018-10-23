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
public class Board {
    
    //class data
    //Represents chess board and stores piece class in its cells
    private Piece[][] chess_board;
    
    //class functions
    public void setup_board(){
        chess_board = new Piece[8][8]; 
        
        
        for (int x=0; x<8;x++)
           for(int y=0;y<8;y++)
                chess_board[x][y] = new Piece();
        
        chess_board[0][0].put_piece('R');   chess_board[0][1].put_piece('K');
        chess_board[0][2].put_piece('B');   chess_board[0][3].put_piece('Q');
        chess_board[0][4].put_piece('C');   chess_board[0][5].put_piece('B');
        chess_board[0][6].put_piece('K');   chess_board[0][7].put_piece('R');
        chess_board[1][0].put_piece('P');   chess_board[1][1].put_piece('P');
        chess_board[1][2].put_piece('P');   chess_board[1][3].put_piece('P');
        chess_board[1][4].put_piece('P');   chess_board[1][5].put_piece('P');
        chess_board[1][6].put_piece('P');   chess_board[1][7].put_piece('P');
        chess_board[0][0].put_player('B');  chess_board[0][1].put_player('B');
        chess_board[0][2].put_player('B');  chess_board[0][3].put_player('B');
        chess_board[0][4].put_player('B');  chess_board[0][5].put_player('B');
        chess_board[0][6].put_player('B');  chess_board[0][7].put_player('B');
        chess_board[1][0].put_player('B');  chess_board[1][1].put_player('B');
        chess_board[1][2].put_player('B');  chess_board[1][3].put_player('B');
        chess_board[1][4].put_player('B');  chess_board[1][4].put_player('B');
        chess_board[1][6].put_player('B');  chess_board[1][7].put_player('B');
        
        
        //initialize white player
        chess_board[6][0].put_piece('p');   chess_board[6][1].put_piece('p');
        chess_board[6][2].put_piece('p');   chess_board[6][3].put_piece('p');
        chess_board[6][4].put_piece('p');   chess_board[6][5].put_piece('p');
        chess_board[6][6].put_piece('p');   chess_board[6][7].put_piece('p');
        chess_board[7][0].put_piece('r');   chess_board[7][1].put_piece('k');
        chess_board[7][2].put_piece('b');   chess_board[7][3].put_piece('c');
        chess_board[7][4].put_piece('q');   chess_board[7][5].put_piece('b');
        chess_board[7][6].put_piece('k');   chess_board[7][7].put_piece('r');
        chess_board[6][0].put_player('W');  chess_board[6][1].put_player('W');
        chess_board[6][2].put_player('W');  chess_board[6][3].put_player('W');
        chess_board[6][4].put_player('W');  chess_board[6][5].put_player('W');
        chess_board[6][6].put_player('W');  chess_board[6][7].put_player('W');
        chess_board[7][0].put_player('W');  chess_board[7][1].put_player('W');
        chess_board[7][2].put_player('W');  chess_board[7][3].put_player('W');
        chess_board[7][4].put_player('W');  chess_board[7][5].put_player('W');
        chess_board[7][6].put_player('W');  chess_board[7][7].put_player('W');
        
    }
    
    public void print_board(){
        //print top
        System.out.println("              Black                ");
        System.out.println("    a   b   c   d   e   f   g   h  ");
        System.out.println("  ---------------------------------");
        
        for (int x=0; x<8;x++){
            System.out.print((x+1) + " | ");
           for(int y=0;y<8;y++){
                System.out.print(String.valueOf(chess_board[x][y].get_piece()) + " | ");
            }
            System.out.println();
            System.out.println("  ---------------------------------");
        }
        System.out.println("             White                 ");
        System.out.println("                                   ");
        
    }
    
    public int move_piece(int x_start, int y_start, int x_finish, int y_finish){
        int check_bool;
        
        //check_bool=my_check.check_move(x_start,y_start,x_finish,y_finish,player,this);
            //move piece to new space
            chess_board[y_finish][x_finish].put_piece(chess_board[y_start][x_start].get_piece());
            chess_board[y_finish][x_finish].put_player(chess_board[y_start][x_start].get_player());
            //set previous space to blank
            chess_board[y_start][x_start].put_piece(' ');
            chess_board[y_start][x_start].put_player('S');
        
        return 0;
        
    }
    
    public char get_player(int x, int y){
        return chess_board[y][x].get_player();  
    }
    
    public char get_piece(int x, int y){
        return chess_board[y][x].get_piece();
    }
    
    
    
}
