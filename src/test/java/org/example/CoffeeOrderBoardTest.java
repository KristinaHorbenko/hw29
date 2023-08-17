package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    void add() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        int orderNumber = board.add("Alen");
        assertEquals(1, orderNumber);
    }

    @Test
    void deliver() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Alen");
        board.add("Yoda");

        Order deliveredOrder = board.deliver();
        assertEquals("Alen", deliveredOrder.getName());
    }

    @Test
    void testDeliver() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Alen");
        board.add("Yoda");

        Order deliveredOrder = board.deliverNumber(2);
        assertEquals("Yoda", deliveredOrder.getName());
    }


}