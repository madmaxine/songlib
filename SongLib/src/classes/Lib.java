package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Lib extends JFrame { 

	JButton add, delete,edit,cancel,submit; //first three represent actions, cancel cancels add/edit, submit submits
	JTextField song,artist,album,year;
	JTextField songdisplay,artistdisplay,albumdisplay,yeardisplay;
	JTextArea messageinfo;
	ArrayList<Song> songlist;
	JPanel songDescription, options, songList, songInput, message;
	JList displaylist;
	JScrollPane listScroller;
	JPanel songInfo;
	ListSelectionListener selectionlistener;
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
					messageinfo.setText("You need a song title and artist for your song!");
					return;
				}
				int yearnum;
				try{
				 yearnum=Integer.parseInt(year.getText()); //getting float from textbox
				 if (yearnum<0){
					 messageinfo.setText("Please enter an existing year!");
					 return;
				 }
				}catch(NumberFormatException err){
					yearnum=-1;
					System.out.println("hi");
				}
				
				int index=-1;
				Song newsong=new Song(song.getText(),artist.getText(),album.getText(),yearnum);
				if (songlist.size()==0){
					songlist.add(newsong);
					index=0;
				}else{
					int low=0;
					int high=songlist.size();
					System.out.println("wha"+high);

					while(low<high){
						Song tempsong=songlist.get((low+high)/2);
						if (newsong.compareTo(tempsong)>0)
							low=(low+high)/2+1;
						else if (newsong.compareTo(tempsong)<0)
							high=(low+high)/2-1;
						else{
							 messageinfo.setText("This song is the same as a song already on the list!");	
							return;
						}
					}
					index=low;
					songlist.add(index, newsong);	
				}
				Object[] objectlist=songlist.toArray();
				int size=songlist.size();
				displaylist.setListData(objectlist);
				displaylist.setSelectedIndex(index);
				displaylist.ensureIndexIsVisible(displaylist.getSelectedIndex());

				//listScroller.revalidate();
				//listScroller.repaint();
				//add to arraylist
				//display song (is there a scrolling list thing I could add?
				//select song (need select method)
				

			}
		});
		
		songInput.add(add);
		
		  songInfo = new JPanel();
	        songInfo.setOpaque(true);
	        songInfo.setBackground(Color.WHITE);
	        songInfo.setBorder(
	            BorderFactory.createTitledBorder("Song Information: "));
		
	        songInfo.add(new JLabel("Name: "));
		songdisplay=new JTextField(16);
		songdisplay.setEditable(false);
		songInfo.add(songdisplay);
		songInfo.add(new JLabel("Artist: "));
		artistdisplay=new JTextField(16);
		artistdisplay.setEditable(false);
		songInfo.add(artistdisplay);
		songInfo.add(new JLabel("Year: "));
		yeardisplay=new JTextField(4);
		yeardisplay.setEditable(false);
		songInfo.add(yeardisplay);
		songInfo.add(new JLabel("Album: "));
		albumdisplay=new JTextField(16);
		albumdisplay.setEditable(false);
		songInfo.add(albumdisplay);
		
		
		add(songInfo);
		
		
		Object[] objectlist=songlist.toArray();
		displaylist = new JList(objectlist); //data has type Object[]
		displaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		displaylist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		displaylist.setVisibleRowCount(-1);
	
		listScroller = new JScrollPane(displaylist);
		listScroller.setPreferredSize(new Dimension(250, 80));
		

		selectionlistener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent){
		    	  System.out.println("yeah?");
		        if (!displaylist.getValueIsAdjusting()&&displaylist.getSelectedIndex()!=-1) {
		          int selectedIndex = displaylist.getSelectedIndex();
		          System.out.println(selectedIndex);
		          Song selectedsong=songlist.get(selectedIndex);
		          songdisplay.setText(selectedsong.getName());
		          artistdisplay.setText(selectedsong.getArtist());
		          if(selectedsong.getYear()>=0)
		        	  yeardisplay.setText(Integer.toString(selectedsong.getYear()));
		          albumdisplay.setText(selectedsong.getAlbum());
		        }
		      }
		    };
		displaylist.addListSelectionListener(selectionlistener);
		add(listScroller);
	
		message=new JPanel();
        message.setOpaque(true);
        message.setBackground(Color.WHITE);
        message.setBorder(
            BorderFactory.createTitledBorder("Message: "));
        messageinfo=new JTextArea();
        messageinfo.setSize(700, 100);
        messageinfo.setEditable(false);
        message.add(messageinfo);
        add(message);
        
	}
	
}
