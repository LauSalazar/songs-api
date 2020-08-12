package co.com.laura.songsadmin.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.laura.songsadmin.model.Song;
import co.com.laura.songsadmin.service.SongService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SongController.class)
public class SongControllerTest { 

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SongService songService;
	
	Song mockSong = new Song("Beat it", "Michael", "Pop", "El mas alla", "", "");
	
	String exampleSongJson = "{" + 
			"    \"tittle\": \"Beat it\"," + 
			"    \"artist\": \"Michael\"," + 
			"    \"genre\": \"Pop\"," + 
			"    \"album\": \"Thriller\"," + 
			"    \"songLyric\": null," + 
			"    \"image\": null" + 
			"}";

	@Test
	public void createSong() throws Exception {
		Song mockSong = new Song("Beat it", "Michael", "Pop", "El mas alla", "", "");

		Mockito.when(
				songService.saveSong(
						Mockito.any(Song.class))).thenReturn(mockSong);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/songs/saveSong")
				.accept(MediaType.APPLICATION_JSON).content(exampleSongJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK, response.getStatus());
		assertEquals(mockSong, response);

	}
	
	@Test
	public void deleteSong() throws Exception {

		Mockito.when(
				songService.deleteSong(
						Mockito.any(Long.class))).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/songs/deleteSong/?id=2");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals(HttpStatus.OK, "");
	}
	
	@Test
	public void updateSong() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/songs/updateSong")
				.accept(MediaType.APPLICATION_JSON).content(exampleSongJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals(HttpStatus.OK, "");

	}
	
	@Test
	public void getSongById() throws Exception {

		Mockito.when(
				songService.getSongById(
						Mockito.any(Long.class))).thenReturn(mockSong);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/songs/getSongById/?id=2");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals(HttpStatus.OK, "");

	}
	
	@Test
	public void getSongs() throws Exception {
		
		Song firstSong = new Song(15L,"Beat it 2", "Michael", "Pop", "El mas alla", "", "");
		Song secondSong = new Song(16L,"Beat it 2", "Michael", "Pop", "El mas alla", "", "");

        Mockito.when(songService.getSongs()).thenReturn(Arrays.asList(firstSong, secondSong));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/songs/getSongs");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals(HttpStatus.OK, "");

	}
	
}
