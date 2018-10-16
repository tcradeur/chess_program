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
public class Move_check {
    
    //return 2 means player is attaching his own piece
    //return 0 means there is no problem
    public int player_check(int x_start, int y_start, int x_finish, int y_finish, char player, Board my_board){
        //check if player is moving his own piece
        char player_temp = my_board.get_player(x_start, y_start); 
        if (player_temp != player){
            return 2;
        }
        //check it the move lands on empty or enemy space
        player_temp = my_board.get_player(x_finish, y_finish);      
        if(player_temp == player){
            return 2;
        }       
        return 0; 
    }
    
    //return 3 out of bounds
    //return 0 means there is no problem
    public int check_boundary(int x_start, int y_start, int x_finish, int y_finish){
        if(x_start < 0 || x_start > 7){return 3;}       
        if(y_start < 0 || y_start > 7){return 3;}        
        if(x_finish < 0 || x_finish > 7){return 3;}         
        if(y_finish < 0 || y_finish > 7){return 3;}
        
        return 0;      
    }    
    
    
    public int check_move(int x_start, int y_start, int x_finish, int y_finish, char player, Board my_board){
        
        
        char piece_temp = Character.toUpperCase(my_board.get_piece(x_start, y_start));
        
        //if(check_boundary(x_start, y_start, x_finish, y_finish) != 0){return 3;}
        //if(player_check(x_start, y_start, x_finish, y_finish, player, my_board) != 0){return 2;}
                
        
        switch (piece_temp){
            case 'P':
                return pawn_check(x_start, y_start, x_finish, y_finish, player, my_board);
            case 'R':
                return rook_check(x_start,y_start,x_finish,y_finish, my_board);
            case 'B':
                return bishop_check(x_start,y_start,x_finish,y_finish, my_board);
            case 'K':
                return knight_check(x_start,y_start,x_finish,y_finish);
            case 'Q':
                return queen_check(x_start,y_start,x_finish,y_finish, my_board);
            case 'C':
                return king_check(x_start,y_start,x_finish,y_finish);
            default:
                break;
        
        }
        return 1;

    }
        //return 1 means an illegal move
        //return 0 means there is no problem
    public int pawn_check(int x_start, int y_start, int x_finish, int y_finish, char player, Board my_board){
        //black player check
        if(player == 'B'){
            //one positon forward
            if((x_finish == x_start && y_finish == y_start+1) && (my_board.get_player(x_finish, y_finish) == 'S')){
                return 0;
            //two positions forward
            }else if(x_finish == x_start && y_start + 2 == y_finish)
            {
                //allow two space jump only from beg position
                if(y_start == 1 && my_board.get_player(x_finish, y_finish) == 'S'){return 0;}
            //diagnal movment
            }else if((x_finish == x_start+1 || x_finish == x_start-1) && y_finish == y_start+1){
                //check if position contains an enemy piece
                if(my_board.get_player(x_finish, y_finish) == 'W'){return 0;}
            }
        }
        //white player check
        else if(player == 'W'){
            //one position forward
            if((x_finish == x_start && y_finish == y_start-1) && (my_board.get_player(x_finish, y_finish) == 'S')){
                return 0;
            //two positions forward
            }else if(x_finish == x_start && y_start-2 == y_finish)
            {
                //allow two space jump only from beg position
                if(y_start == 6 && my_board.get_player(x_finish, y_finish) == 'S'){
                    return 0;}
            //diagnal movement
            }else if((x_finish == x_start+1 || x_finish == x_start-1) && y_finish == y_start-1){
                //check if position contains an enemy piece
                if(my_board.get_player(x_finish, y_finish) == 'B'){return 0;}
            }
        }
        return 1;   
    }
    //return 1 means an illegal move
    //return 0 means there is no problem
    public int rook_check(int x_start, int y_start, int x_finish, int y_finish, Board my_board){
        
        //check legal move
        if(x_start == x_finish){
            //check path is clear
            if(y_start > y_finish){
                for(int y = y_start-1;y > y_finish;y--){
                    System.out.println(my_board.get_player(x_start, y));
                    if(my_board.get_piece(x_start, y) != ' ' ){return 1;}
                }
            
            }else if (x_start < x_finish){
                for(int y = y_start+1;y < y_finish;y++){
                    if(my_board.get_piece(x_start, y) != ' ' ){return 1;}
                }
            }
            return 0;      
        }else if (y_start == y_finish){
            //check path is clear
            if(x_start > x_finish){
                for(int x = x_start-1;x > x_finish;x--){
                    if(my_board.get_piece(x, y_start) != ' ' ){return 1;}
                }
            }else if (x_start < x_finish){
                for(int x = x_start+1;x < x_finish;x++){
                    if(my_board.get_piece(x, y_start) != ' ' ){return 1;}
                }
            }
            return 0;
        
        }else{
            return 1;
        }     
    }
    //return 1 means an illegal move
    //return 0 means there is no problem
    public int bishop_check(int x_start, int y_start, int x_finish, int y_finish, Board my_board){
       //check diagnal movement
        if(Math.abs(x_start - x_finish) == Math.abs(y_start - y_finish)){
           //upper left
            if ((x_start > x_finish) && (y_start < y_finish)){ 
                for(int x = x_start-1, y = y_start+1; x > x_finish; x--, y++)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //upper right
            }else if ((x_start < x_finish) && (y_start < y_finish)){
                for(int x = x_start+1, y = y_start+1; x < x_finish; x++, y++)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //lower left
            }else if ((x_start > x_finish) && (y_start > y_finish)){
                for(int x = x_start-1,y = y_start-1; x > x_finish; x--, y--)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //upper right
            }else if ((x_start < x_finish) && (y_start > y_finish)){
                for(int x = x_start+1,y = y_start-1; x > x_finish; x++, y--)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            }
        }else{return 1;}
        return 0;  
    }
    
    //return 1 means an illegal move
    //return 0 means there is no problem
    public int knight_check(int x_start, int y_start, int x_finish, int y_finish){
        //check legal move
        if ((x_start-2 == x_finish || x_start+2 == x_finish) && (y_start+1 == y_finish || y_start-1 == y_finish)){return 0;}
        else if ((x_start-1 == x_finish || x_start+1 == x_finish) && (y_start+2 == y_finish || y_start-2 == y_finish)){return 0;}
        else{return 1;}
    }
    
    
    public int queen_check(int x_start, int y_start, int x_finish, int y_finish, Board my_board){
        
        //check up,down,side movement
         if(x_start == x_finish){
          //check path is clear
            if(y_start > y_finish){
                for(int y = y_start-1;y > y_finish;y--){
                    System.out.println(my_board.get_player(x_start, y));
                    if(my_board.get_piece(x_start, y) != ' ' ){return 1;}
                }
            
            }else if (x_start < x_finish){
                for(int y = y_start+1;y < y_finish;y++){
                    if(my_board.get_piece(x_start, y) != ' ' ){return 1;}
                }
            }
            return 0;          
        }else if (y_start == y_finish){
          //check path is clear
            if(x_start > x_finish){
                for(int x = x_start-1;x > x_finish;x--){
                    if(my_board.get_piece(x, y_start) != ' ' ){return 1;}
                }
            }else if (x_start < x_finish){
                for(int x = x_start+1;x < x_finish;x++){
                    if(my_board.get_piece(x, y_start) != ' ' ){return 1;}
                }
            }
            return 0;
        }
        //check diagnal movement
        else if(Math.abs(x_start - x_finish) == Math.abs(y_start - y_finish)){
            //upper left
            if ((x_start > x_finish) && (y_start < y_finish)){ 
                for(int x = x_start-1, y = y_start+1; x > x_finish; x--, y++)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //upper right
            }else if ((x_start < x_finish) && (y_start < y_finish)){
                for(int x = x_start+1, y = y_start+1; x < x_finish; x++, y++)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //lower left
            }else if ((x_start > x_finish) && (y_start > y_finish)){
                for(int x = x_start-1,y = y_start-1; x > x_finish; x--, y--)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            //upper right
            }else if ((x_start < x_finish) && (y_start > y_finish)){
                for(int x = x_start+1,y = y_start-1; x > x_finish; x++, y--)
                    if(my_board.get_piece(x, y) != ' ' ){return 1;}
            }
        }else{return 1;}
        return 0;
           
       
    }
    
    
    //return 1 means an illegal move
    //return 0 means there is no problem
    public int king_check(int x_start, int y_start, int x_finish, int y_finish){
        //check legal move
        //up
        if (y_finish == y_start+1 && x_finish == x_start){return 0;}
        //up left    
        else if(y_finish == y_start+1 && x_finish == x_start-1){return 0;}
        //up right
        else if(y_finish == y_start+1 && x_finish == x_start+1){return 0;}
        //left
        else if(y_finish == y_start && x_finish == x_start-1){return 0;}
        //right
        else if(y_finish == y_start && x_finish == x_start+1){return 0;}
        //bottom
        else if(y_finish == y_start-1 && x_finish == x_start){return 0;}
        //bottom left
        else if(y_finish == y_start-1 && x_finish == x_start-1){return 0;}
        //bottom right
        else if(y_finish == y_start-1 && x_finish == x_start +1){return 0;}
        else{return 1;}
            
    }
}
