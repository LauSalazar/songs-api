package co.com.laura.songsadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.laura.songsadmin.model.Song;
import co.com.laura.songsadmin.service.SongService;

@RestController
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping(path = "/songs")
public class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping(path = "/saveSong")
	public ResponseEntity<Song> saveSong(@RequestBody Song song) {
		songService.saveSong(song);
		return new ResponseEntity<Song>(song, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteSong/{id}")
	public ResponseEntity<Song> deleteSong(@PathVariable Long id) {
		songService.deleteSong(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/updateSong")
	public ResponseEntity<Song> updateSong(@RequestBody Song song) {
		songService.updateSong(song);
		return new ResponseEntity<Song>(song, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getSongById/{id}")
	public Song getSongById(@PathVariable Long id) {
		return songService.getSongById(id);
	}
	
	@GetMapping(path = "/getSongs")
	public List<Song> getSongs() {
		return songService.getSongs();
	}

}
