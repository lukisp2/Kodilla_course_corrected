package com.kodilla.decorator;

import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.AbstractTaxiOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.ChildSeatDecorator;
import com.kodilla.patterns2.decorator.taxiportal.ExpressDecorator;
import com.kodilla.patterns2.decorator.taxiportal.MyTaxiNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.TaxiNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.UberNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.VipCarDecorator;





import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxiOrderTestSuite {                               // [5]

        @Test                                                 // [6]
        public void testBasicTaxiOrderGetCost() {             // [7]
            // Given
            TaxiOrder theOrder = new BasicTaxiOrder();         // [8]
            // When
            BigDecimal calculatedCost = theOrder.getCost();    // [9]
            // Then
            assertEquals(new BigDecimal(5), calculatedCost);   // [10]
        }                                                     // [11]

        @Test                                                 // [12]
        public void testBasicTaxiOrderGetDescription() {      // [13]
            // Given
            TaxiOrder theOrder = new BasicTaxiOrder();         // [14]
            // When
            String description = theOrder.getDescription();    // [15]
            // Then
            assertEquals("Drive a course", description);       // [16]
        }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }
    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(57), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network express service variant VIP + child seat", description);
    }

}







