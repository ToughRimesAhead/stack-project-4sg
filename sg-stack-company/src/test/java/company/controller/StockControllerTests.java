package company.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import company.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@WebMvcTest(StockController.class)
public class StockControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StockService stockService;

	@Test
	public void stock_basic() throws Exception{
		//call GET "/stocks/test"  application/json

		RequestBuilder request = MockMvcRequestBuilders
				.get("/stocks/test");
		//    .accept(MediaType.APPLICATION_JSON);


		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Stock Controller works"))
				.andReturn();


		//verify "Hello World"
		assertEquals("Stock Controller works", result.getResponse().getContentAsString());
	}



}