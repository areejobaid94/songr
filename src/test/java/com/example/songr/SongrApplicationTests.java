package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class SongrApplicationTests {
	Album album = new Album("anything","any one","https://i.ytimg.com/vi/mCPQspoRMxo/maxresdefault.jpg",10,150.0);

	@Test
	void TestConstructorAlbum () {
		assertThat(album instanceof Album).isEqualTo(true);
	}

	@Test
	void TestConstructorAlbumGetTitle () {
		assertThat(album.getTitle()).isEqualTo("anything");
	}

	@Test
	void TestConstructorAlbumGetArtist () {
		assertThat(album.getArtist()).isEqualTo("any one");
	}

	@Test
	void TestConstructorAlbumGetLength () {
		assertThat(album.getLength()).isEqualTo(150.0);
	}

	@Test
	void TestConstructorAlbumGetImageUrl () {
		assertThat(album.getImageUrl()).isEqualTo("https://i.ytimg.com/vi/mCPQspoRMxo/maxresdefault.jpg");
	}

	@Test
	void TestConstructorAlbumGetSongCount () {
		assertThat(album.getSongCount()).isEqualTo(10);
	}

	@Test
	void TestConstructorAlbumSetTitle () {
		album.setTitle("Hello");
		assertThat(album.getTitle()).isEqualTo("Hello");
	}

	@Test
	void TestConstructorAlbumSetArtist () {
		album.setTitle("Hello Word");
		assertThat(album.getTitle()).isEqualTo("Hello Word");
	}

	@Test
	void TestConstructorAlbumSetLength () {
		album.setLength(200.0);
		assertThat(album.getLength()).isEqualTo(200.0);
	}

	@Test
	void TestConstructorAlbumSetImageUrl () {
		album.setImageUrl("https://i.ytimg.com/vi/ek68Del9bfw/maxresdefault.jpg");
		assertThat(album.getImageUrl()).isEqualTo("https://i.ytimg.com/vi/ek68Del9bfw/maxresdefault.jpg");
	}

	@Test
	void TestConstructorAlbumSetSongCount () {
		album.setSongCount(15);
		assertThat(album.getSongCount()).isEqualTo(15);
	}
}

