package pl.sdacademy.italianrestaurant.staff;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.supply.Order;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KitchenTest {


    private Kitchen kitchen;

    @Before
    public void init() {
        kitchen = new Kitchen();
    }


    @Test
    public void shouldUpdateFoodObserverWhenNewFoodAppears() {

        //given
        FoodObserver foodObserver = mock(FoodObserver.class);
        Food food = mock(Food.class);
        kitchen.register(foodObserver);

        //when
        kitchen.addFood(food);

        //then
        verify(foodObserver).update();
    }

    @Test
    public void shouldUpdateAllFoodObserversWhenNewFoodAppears() {

        //given
        FoodObserver foodObserver1 = mock(FoodObserver.class);
        FoodObserver foodObserver2 = mock(FoodObserver.class);
        Food food = mock(Food.class);
        kitchen.register(foodObserver1);
        kitchen.register(foodObserver2);

        //when
        kitchen.addFood(food);

        //then
        verify(foodObserver1).update();
        verify(foodObserver2).update();
    }

    @Test
    public void shouldUpdateOrderObserverWhenNewFoodAppears() {

        //given
        OrderObserver orderObserver = mock(OrderObserver.class);
        Order order = mock(Order.class);
        kitchen.register(orderObserver);

        //when
        kitchen.addOrder(order);

        //then
        verify(orderObserver).update();
    }

    @Test
    public void shouldUpdateAllOrderObserversWhenNewFoodAppears() {
        //given
        OrderObserver orderObserver1 = mock(OrderObserver.class);
        OrderObserver orderObserver2 = mock(OrderObserver.class);
        Order order = mock(Order.class);
        kitchen.register(orderObserver1);
        kitchen.register(orderObserver2);

        //when
        kitchen.addOrder(order);

        //then
        verify(orderObserver1).update();
        verify(orderObserver2).update();
    }

}