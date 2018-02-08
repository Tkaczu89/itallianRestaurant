package pl.sdacademy.italianrestaurant.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void shouldProvideBuilder() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        assertNotNull(builder);
        //then

    }

    @Test
    public void shouldReturnBuilderAfterDoughSetup() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        Pizza.PizzaBuilder builderAfterDough = builder.dough(Dough.SICILIAN);
        //then
        assertNotNull(builderAfterDough);
    }

    @Test
    public void shouldReturnBuilderAfterSizeSetup() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        Pizza.PizzaBuilder builderAfterSize = builder.size(Size.MEDIUM);
        //then
        assertNotNull(builderAfterSize);
    }

    @Test
    public void shouldReturnBuilderAfterSauceSetup() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        Pizza.PizzaBuilder builderAfterSauce = builder.sauce("tomato");
        //then
        assertNotNull(builderAfterSauce);
    }

    @Test
    public void shouldReturnBuilderAfterToppingsSetup() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        Pizza.PizzaBuilder builderAfterToppings = builder.toppings("mozarella");
        //then
        assertNotNull(builderAfterToppings);
    }

    @Test
    public void shouldReturnPizzaOnBuild() {
        //given
        Pizza.PizzaBuilder builder = Pizza.builder();
        //when
        Pizza pizza = builder.build();
        //then
        assertNotNull(pizza);
    }

    @Test
    public void shouldBeAbleToSetPizzaFieldsWithBuilder() {
        //given
        Dough dough = Dough.SICILIAN;
        Size size = Size.SMALL;
        String sauce = "garlic";
        String topping1 = "ham";
        String topping2 = "mushroom";

        //when
        Pizza pizza = Pizza.builder()
                .dough(dough)
                .size(size)
                .sauce(sauce)
                .toppings(topping1)
                .toppings(topping2)
                .build();

        //then
        assertEquals(dough, pizza.getDough());
        assertEquals(sauce, pizza.getSauce());
        assertEquals(size, pizza.getSize());
        assertTrue(pizza.getToppings().contains(topping1));
        assertTrue(pizza.getToppings().contains(topping2));
    }

}