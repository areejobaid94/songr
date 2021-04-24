package com.example.songr;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SongrApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testHelloPage() throws Exception {
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testHelloPageResultWithArg() throws Exception {
        this.mockMvc.perform(get("/hello?name=Areej")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2 class=\"headers\"  >Hello, AREEJ!</h2>")));
    }

    @Test
    public void testHelloPageResultWithoutArg() throws Exception {
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2 class=\"headers\"  >Hello, WORLD!</h2>")));
    }

	@Test
	public void testFactRoute() throws Exception {
		this.mockMvc.perform(get("/fact?num=100")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<h3>fact about number</h3>")));
	}

	@Test
	public void testCapitalizeRoute() throws Exception {
		this.mockMvc.perform(get("/capitalize/Areej")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<h2 class=\"headers\">AREEJ</h2>")));
	}
	@Test
	public void testAlbumsRoute() throws Exception {
		this.mockMvc.perform(get("/albums")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<h3>Add Album</h3>")));
	}

	@Test
	public void testSongsRoute() throws Exception {
		this.mockMvc.perform(get("/songs")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<h3>Add Song</h3>")));
	}


}

