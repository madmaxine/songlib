package library;

import javax.swing.JFrame;

import classes.Lib;

public class SongLib {

	public static void main(String[] args) {
		JFrame lib = new Lib("Song Lib");
		lib.setSize(800, 500); //size of frame
		lib.setLocationRelativeTo(null); //center frame in center of display
		lib.setVisible(true); //show frame
		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to kill program when close frame

	}

}
