package co.com.laura.songsadmin.model;

public class Song {
	
	private Long id;
	private String title;
	private String artist;
	private String genre;
	private String album;
	private String lyric;
	private String image;
	
	public Song() {}
	public Song(Long id, String title, String artist, String genre, String album, String lyric, String image) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.album = album;
		this.lyric = lyric;
		this.image = image;
	}
	
	public Song(String title, String artist, String genre, String album, String lyric, String image) {
		super();
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.album = album;
		this.lyric = lyric;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", genre=" + genre + ", album=" + album
				+ ", lyric=" + lyric + ", image=" + image + "]";
	}

}
