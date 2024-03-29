package com.esprit.examen.services;

//JUnit 4
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;

//JUnit 5
//import static org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;

	@Test
	void testAddStock() {

		int size= stockService.retrieveAllStocks().size();

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);

		int expected =  stockService.retrieveAllStocks().size();

		assertEquals(size+1,expected);
		assertNotNull(savedStock.getLibelleStock());

		stockService.deleteStock(savedStock.getIdStock());
		
	} 

	
	@Test
	void testDeleteStock() {

		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);

		stockService.deleteStock(savedStock.getIdStock());

		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

}
