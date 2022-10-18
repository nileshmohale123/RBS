package com.yash.rbs.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.rbs.model.Customer;
import com.yash.rbs.repository.CustomerRepository;
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

		@Autowired
		MockMvc mockMvc;

		@MockBean
		CustomerRepository custrepo;

		@Test
		public void addCustomerTest() throws Exception {
			Customer cust = new Customer();
			cust.setcId(1L);
			cust.setName("Nilesh");
			cust.setAddress("Pune");
			cust.setPassword("1221");
			cust.setUsername("sd");
			ObjectMapper mapper = new ObjectMapper();
	        this.mockMvc
	                .perform(post("/customer").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	                        .content(mapper.writeValueAsString(cust)))

	               .andExpect(status().isOk());



	   }

		@Test
		public void getAllCustomerTest() throws Exception {
			List<Customer> empList = Arrays.asList(new Customer(102, "e1", "gmail", "pune"),
					new Customer(103, "e2", "gmail2", "pune2"));

			mockMvc.perform(get("/customers"))

					.andExpect(status().isOk());

					//.andExpect(content().json("[{}, {}]"));

		   }

}
