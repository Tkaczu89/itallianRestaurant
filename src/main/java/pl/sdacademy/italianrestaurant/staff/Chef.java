package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.food.FoodFactory;
import pl.sdacademy.italianrestaurant.supply.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Chef extends Thread implements OrderObserver {

    private FoodFactory factory = new FoodFactory();
    private Kitchen kitchen;
    private String name;
    private boolean thereIsNewOrder = false;
    private boolean isWorking = false;

    public Chef(Kitchen kitchen, String name) {
        this.kitchen = kitchen;
        this.name = name;
        kitchen.register(this);
    }

    @Override
    public void run() {
        isWorking = true;
        while (isWorking) {
            if (thereIsNewOrder) {
                Optional<Order> optionalOrder = kitchen.getOrder();
                thereIsNewOrder = false;
                optionalOrder.map(this::prepareOrderedFood).orElseGet(ArrayList::new).forEach(kitchen::addFood);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //nothing to do
            }
        }

    }

    @Override
    public void interrupt() {
        isWorking = false;

        super.interrupt();
    }

    @Override
    public void update() {
        thereIsNewOrder = true;

    }

    public List<Food> prepareOrderedFood(Order order) {
        System.out.println(name + ": I'm making a dish!");
        return order.getElements().stream().map(factory::prepareFood).collect(Collectors.toList());
    }
}

