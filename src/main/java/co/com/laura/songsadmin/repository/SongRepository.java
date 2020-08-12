package co.com.laura.songsadmin.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.laura.songsadmin.model.Song;

@Repository
public class SongRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Song saveSong(Song song) {
		String sql = " INSERT INTO SONGS (TITLE, ARTIST, GENRE, ALBUM, LYRIC, IMAGE) "
				+ " VALUES (?, ?, ?, ?, ?, ?) ";
		jdbcTemplate.update(sql, new Object[] { 
				song.getTitle(), 
				song.getArtist(), 
				song.getGenre(), 
				song.getAlbum(),
				song.getLyric(), 
				song.getImage()});
		return song;
	}
	
	public boolean deleteSong(Long id){
	    String sql = "DELETE FROM SONGS WHERE ID = ?";
	    return jdbcTemplate.update(sql, new Object[] {id}) == 1;
	}
	
	public void updateSong(Song song) {
		String sql = " UPDATE SONGS SET TITLE = ?, ARTIST = ?, GENRE = ?, ALBUM = ?, LYRIC = ?, IMAGE = ? "
				+ " WHERE ID = ? ";
		jdbcTemplate.update(sql, new Object[] { 
				song.getTitle(), 
				song.getArtist(), 
				song.getGenre(), 
				song.getAlbum(),
				song.getLyric(), 
				song.getImage(), 
				song.getId()});
	}
	
	public Song getSongById(Long id) {
		String sql = "SELECT ID, TITLE, ARTIST, GENRE, ALBUM, LYRIC, IMAGE FROM SONGS WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
        new Song(
        		rs.getLong("id"), 
        		rs.getString("title"), 
        		rs.getString("artist"),
				rs.getString("genre"), 
				rs.getString("album"), 
				rs.getString("lyric"),
				rs.getString("image")));
	}

	public List<Song> getSongs() {
		String sql = "SELECT ID, TITLE, ARTIST, GENRE, ALBUM, LYRIC, IMAGE FROM SONGS";
		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new Song(rs.getLong("id"), 
						rs.getString("title"), 
						rs.getString("artist"),
						rs.getString("genre"), 
						rs.getString("album"), 
						rs.getString("lyric"),
						rs.getString("image")));
	}

}
