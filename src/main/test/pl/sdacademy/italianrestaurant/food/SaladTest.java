package pl.sdacademy.italianrestaurant.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class SaladTest {

    @Test
    public void shouldProvideBuilder() {
        Salad.SaladBuilder builder = Salad.builder();

        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterSaladTypeSetup() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.SaladType(SaladType.ITALAIN);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterIsItCarrotSetup() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.isItCarrot(true);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterIsItTomato() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.isItTomato(false);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterIsItVegetarian() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.isItVegetarian(false);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterKindOfCheeseSetup() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.kindOfCheese(KindOfCheese.BLUE);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterKindOfMeatSetup() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        builder.kindOfMeat(KindOfMeat.LAMB);
        //then
        assertNotNull(builder);
    }

    @Test
    public void shouldReturnSaladOnBuild() {
        //given
        Salad.SaladBuilder builder = Salad.builder();
        //when
        Salad salad = builder.build();
        //then
        assertNotNull(salad);
    }

    @Test
    public void shouldBeAbleToSetSaladFieldsWithBuilder() {
        //given
        SaladType saladType = SaladType.ITALAIN;
        boolean isItCarrot = true;
        boolean isItTomato = false;
        boolean isItVegetarian = true;
        KindOfCheese kindOfCheese = KindOfCheese.BLUE;
        KindOfMeat kindOfMeat = KindOfMeat.LAMB;

        //when
        Salad salad = Salad.builder()
                .SaladType(saladType)
                .isItCarrot(isItCarrot)
                .isItTomato(isItTomato)
                .isItVegetarian(isItVegetarian)
                .kindOfCheese(kindOfCheese)
                .kindOfMeat(kindOfMeat)
                .build();


        //then
        assertEquals(saladType, salad.getSaladType());
        assertEquals(isItCarrot, salad.isItCarrot());
        assertEquals(isItTomato, salad.isItTomato());
        assertEquals(isItVegetarian, salad.isItVegetarian());
        assertEquals(kindOfCheese, salad.getKindOfCheese());
        assertEquals(kindOfMeat, salad.getKindOfMeat());

    }
}

