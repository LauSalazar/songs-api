package co.com.laura.songsadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.laura.songsadmin.model.Song;
import co.com.laura.songsadmin.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	public Song saveSong(Song song) {
		return songRepository.saveSong(song);
	}
	
	public boolean deleteSong(Long id) {
		return songRepository.deleteSong(id);
	}
	
	public void updateSong(Song song) {
		songRepository.updateSong(song);
	}
	
	public Song getSongById(Long id) {
		return songRepository.getSongById(id);
	}
	
	public List<Song> getSongs(){
		return songRepository.getSongs();
	}

}
