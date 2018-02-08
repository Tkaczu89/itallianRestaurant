package pl.sdacademy.italianrestaurant.staff;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pl.sdacademy.italianrestaurant.food.FoodFactory;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChefTest {

    @Mock
    private FoodFactory factory;
    @Mock
    private Kitchen kitchen;
    @InjectMocks
    private Chef ramsey;

    @Before
    public void init(){
        ramsey = new Chef(kitchen,"Antonio");
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldUseFoodFactory() {

        //given
        Order order = mock(Order.class);
        OrderElement orderElement = mock(OrderElement.class);
        List<OrderElement> orderElements = new ArrayList<>();
        orderElements.add(orderElement);
        when(order.getElements()).thenReturn(orderElements);

        //when
        ramsey.prepareOrderedFood(order);

        //then
        // zweryfikuj to że na obiekcie foodfactory zostala wykonana
        // metoda prepare food z dowolnym parametrem

        verify(factory).prepareFood(any());
    }

    @Test
    public void shouldUseFoodFactory3times() {
        //given
        Order order = mock(Order.class);
        OrderElement orderElement = mock(OrderElement.class);
        List<OrderElement> orderElements = new ArrayList<>();
        orderElements.add(orderElement);
        orderElements.add(orderElement);
        orderElements.add(orderElement);
        when(order.getElements()).thenReturn(orderElements);

        //when
        ramsey.prepareOrderedFood(order);

        //then
        // zweryfikuj to że na obiekcie foodfactory zostala wykonana
        // metoda prepare food z dowolnym parametrem

        verify(factory, times(3)).prepareFood(any());

    }

}