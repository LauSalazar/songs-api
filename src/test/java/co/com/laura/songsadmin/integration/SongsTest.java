package co.com.laura.songsadmin.integration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.laura.songsadmin.model.Song;
import co.com.laura.songsadmin.service.SongService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SongsTest {
	 
	@Autowired
	SongService service;
	
	@Test
	public void createSongTest() {
		Song song = new Song("Beat it", "El negrito del sabor", "Rock/pop", "Thriller", "", "");
		Song responseSong = service.saveSong(song);	
		assertTrue(song.equals(responseSong));
		
	}
	
	@Test
	public void deleteSongTest() {
		boolean resp = service.deleteSong(1L);	
		assertEquals(true, resp);
	}
	
	@Test
	public void updateSongTest() {
		Song song = new Song(14L,"Beat it 2", "El negrito del sabor", "Rock/pop", "Thriller", "", "");
		service.updateSong(song);
		Song songUpdated = service.getSongById(song.getId());
		assertTrue(song.getTitle().equals(songUpdated.getTitle()));
	}
	
	@Test
	public void getSongById() {
		Song song = service.getSongById(14L);
		assertTrue(null!=song);
	}
	
	@Test
	public void getSongs() {
		List<Song> songs = service.getSongs();
		assertTrue(songs.size()>0);
	}

}
