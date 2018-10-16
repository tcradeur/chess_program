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
public class Piece {
    
    private char piece_type;
    private char player;
    
    public Piece(){
        this.piece_type = ' ';
        this.player = 'S';
    }
    
    public char get_piece(){
        return this.piece_type;
    }
    public void put_piece(char p_type){
        this.piece_type = p_type;
    }
    public char get_player(){
        return this.player;
    }
    public void put_player(char p_player){
        this.player = p_player;
    }
    
}
