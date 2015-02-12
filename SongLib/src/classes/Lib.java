package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class Lib extends JFrame { 

	JButton add, delete,edit,cancel,submit; //first three represent actions, cancel cancels add/edit, submit submits
	JTextField song,artist,album,year;
	JTextField songdisplay,artistdisplay,albumdisplay,yeardisplay;
	ArrayList<Song> songlist;
	JPanel songDescription, options, songList, songInput, message;
	JList displaylist;
	JScrollPane listScroller;
	public Lib(String title){
		super(title);
		songlist=new ArrayList<Song>();
		
		songInput = new JPanel();
		songInput.setLayout(new BoxLayout(songInput, BoxLayout.PAGE_AXIS));
		add(songInput);
		setLayout(new FlowLayout()); //can I do this???
		songInput.add(new JLabel("Song: "));
		song=new JTextField(16);
		songInput.add(song);
		songInput.add(new JLabel("Artist: "));
		artist=new JTextField(16);
		songInput.add(artist);
		songInput.add(new JLabel("Year: "));
		year=new JTextField(4);
		songInput.add(year);
		songInput.add(new JLabel("Album: "));
		album=new JTextField(16);
		songInput.add(album);
		
		
		//add function
		add=new JButton("add");
	
		add.addActionListener(new ActionListener(){ //defining new class, so must have actionPerformed as defined in interface
			public void actionPerformed(ActionEvent e){
				
				if(song.getText().equals("")||artist.getText().equals("")){
					//output dialogue hey need name and/or artist
					//also can make more specific later
					System.out.println("hu");
					return;
				}
				int yearnum;
				try{
				 yearnum=Integer.parseInt(year.getText()); //getting float from textbox
				 if (yearnum<0){
					 //print hey put in actual years
					 return;
				 }
				}catch(NumberFormatException err){
					yearnum=-1;
					System.out.println("hi");
				}
				
				Song newsong=new Song(song.getText(),artist.getText(),album.getText(),yearnum);
				songlist.add(newsong);
				Object[] objectlist=songlist.toArray();
				int size=songlist.size();
				displaylist.setListData(objectlist);
				displaylist.setSelectedIndex(size-1);
				displaylist.ensureIndexIsVisible(displaylist.getSelectedIndex());

				//listScroller.revalidate();
				//listScroller.repaint();
				//add to arraylist
				//display song (is there a scrolling list thing I could add?
				//select song (need select method)
				

			}
		});
		
		songInput.add(add);
		
		//display song info
		
		
		Object[] objectlist=songlist.toArray();
		displaylist = new JList(objectlist); //data has type Object[]
		displaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		displaylist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		displaylist.setVisibleRowCount(-1);
	
		listScroller = new JScrollPane(displaylist);
		listScroller.setPreferredSize(new Dimension(250, 80));
		add(listScroller);
		
	}
	
}
