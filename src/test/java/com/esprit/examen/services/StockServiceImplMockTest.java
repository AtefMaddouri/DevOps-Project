package com.esprit.examen.services;


import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class StockServiceImplMockTest {



    @Spy // ou bien @Mock
    StockRepository stockRepository;

    @Mock
    CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    StockServiceImpl stockService;

    @Test
    void testRetrieveStockByID() {

        //Stock stock = new Stock("stock test",10,100);
        Stock stock = new Stock(1,"stock test",10,100);
        Mockito.when(stockRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(stock));


      //  Stock s = new Stock(1,"stock test",10,100);
     //   Stock savedStock= stockService.addStock(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(stockService.retrieveStock(1L));


    }

    // Stock

}
