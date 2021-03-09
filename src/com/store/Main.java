package com.store;

import com.components.MotherBoard;

public class Main {
	
    public static void main(String[] args)    
    {

        MotherBoard board = new MotherBoard();
     BuilderWindow builder = new BuilderWindow(815, 450, board);

    }
}
