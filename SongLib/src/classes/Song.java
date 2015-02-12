package classes;

public class Song {
	
	
	
	private String name;
	private String artist;
	private String album;
	private int year;
	
	

	public static final String INITIAL_ALBUM="";
	public static final int INITIAL_YEAR=-1;
	
	public Song(String name, String artist){
		this.name=name;
		this.artist=artist;
		this.album=INITIAL_ALBUM;
		this.year=INITIAL_YEAR;
	}
	
	public Song(String name, String artist, String album, int year){
		this.name=name;
		this.artist=artist;
		this.album=album;
		this.year=year; //already parsed and checked for actual value

	}
	
	
	public String getName(){
		return name;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public int getYear(){
		return year;
	}
	
}
