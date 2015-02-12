package classes;

public class Song implements Comparable {
	
	
	
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
	
	public String getAlbum(){
		return album;
	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0==null||!(arg0 instanceof Song)){
			throw new IllegalArgumentException();
		}
		Song otherSong=(Song)arg0;
		if(name.compareTo(otherSong.getName())>0)
			return 1;
		else if(name.compareTo(otherSong.getName())<0)
			return -1;
		else {
			if(artist.compareTo(otherSong.getArtist())>0)
				return 1;
			else if(artist.compareTo(otherSong.getArtist())<0)
				return -1;
		}
		return 0;
	}
	
}
