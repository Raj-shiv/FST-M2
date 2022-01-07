package com.ibm.junit.junit_project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class Activity_1 {
	
	 ArrayList<String> list;
		
		@BeforeEach
		 void setup()
		{
			// Initialize a new ArrayList
			 list = new ArrayList<String>();

			// Add values to the list
			list.add("alpha"); // at index 0
			list.add("beta"); // at index 1
		}
		@Test
		void insertTest(){
			
			// Assert size of list
			assertEquals(2, list.size(), "Wrong size");
			
			list.add("Gamma");

			// Assert individual elements
			assertEquals("alpha", list.get(0), "Wrong element");
			
			assertEquals(3, list.size(), "Wrong size");
			assertEquals("beta", list.get(1), "Wrong element");
			assertEquals("Gamma", list.get(2), "Wrong element");
			
		}
		@Test
		void replaceTest(){
			
			list.set(1, "Wheet");

			// Assert individual elements
			assertEquals(2, list.size(), "Wrong size");
			assertEquals("Wheet", list.get(1), "Wrong element");
			assertEquals("alpha", list.get(0), "Wrong element");
			//assertEquals("Gamma", list.get(2), "Wrong element");
			//assertEquals("Wheet", list.get(1), "Wrong element");
			
		}

}
