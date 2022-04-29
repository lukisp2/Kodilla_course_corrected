package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    private ItemDao itemDao;
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product chleb = new Product("Bread");
        Product maslo = new Product("Butter");
        Product mleko = new Product("Milk");

        Item item = new Item(chleb, new BigDecimal(2.33), 2);
        Item item1 = new Item(maslo, new BigDecimal(6.49), 10);
        Item item2 = new Item(mleko, new BigDecimal(1.49), 24);

        Invoice invoice = new Invoice();
        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        productDao.save(chleb);
        productDao.save(maslo);
        productDao.save(mleko);

        itemDao.save(item);
        itemDao.save(item1);
        itemDao.save(item2);

        invoiceDao.save(invoice);

        //Then
        long productNo = productDao.count();
        long itemNo = itemDao.count();
        long invoiceNo = invoiceDao.count();

        Assertions.assertEquals(3,productNo);
        Assertions.assertEquals(3,itemNo);
        Assertions.assertEquals(1,invoiceNo);

        //CleanUp
        productDao.deleteAll();
        invoiceDao.deleteAll();
        invoiceDao.deleteAll();
    }


}
