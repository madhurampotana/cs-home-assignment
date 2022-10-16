package com.problem.three;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.problem.three.controller.EvaluateController;
import com.problem.three.service.EvaluateService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EvaluateController.class)
public class EvaluateControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EvaluateService evaluateService;

	@Test
	public void shouldReturnOurText() throws Exception {
		String expJson = "{\"inputExp\":\"+ 2 3\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/evaluateExpression")
				.accept(MediaType.APPLICATION_JSON).content(expJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		assertEquals(200, result.getResponse().getStatus());
	}

}
