package org.example;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeOrderBoard {
    private ArrayList<Order> orderList;
    private int nextNumber;
    private Logger logger;

    public CoffeeOrderBoard() {
        orderList = new ArrayList<>();
        nextNumber = 1;

        logger = Logger.getLogger("CoffeeOrderBoard");
        logger.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("coffee_order.log");
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int add(String name) {
        Order order = new Order(nextNumber, name);
        orderList.add(order);
        logger.info("Order " + order.getNumber() + " added for " + order.getName());
        nextNumber++;
        return order.getNumber();
    }

    public Order deliver() {
        if (orderList.isEmpty()) {
            logger.info("No orders to deliver");
            return null;
        }

        Order nextOrder = orderList.get(0);
        orderList.remove(0);
        logger.info("Delivered order " + nextOrder.getNumber() + " for " + nextOrder.getName());
        return nextOrder;
    }

    public Order deliverNumber(int orderNumber) {
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getNumber() == orderNumber) {
                orderList.remove(i);
                logger.info("Delivered order " + order.getNumber() + " for " + order.getName());
                return order;
            }
        }
        logger.severe("Order with number " + orderNumber + " not found");
        return null;
    }

    public void draw() {
        System.out.println("====================");
        System.out.println("Num | Name");
        for (Order order : orderList) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }


    }
}
