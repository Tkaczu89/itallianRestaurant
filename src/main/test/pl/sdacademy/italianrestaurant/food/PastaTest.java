package pl.sdacademy.italianrestaurant.food;

import org.junit.Test;

import static org.junit.Assert.*;

public class PastaTest {

    @Test
    public void shouldProvideBuilder() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();

        assertNotNull(builder);
    }

    @Test
    public void shouldReturnBuilderAfterPastaTypeSetup() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();
        //when
        Pasta.PastaBuilder builderAfterPastaType = builder.pastaType(PastaType.PIPE);
        //then
        assertNotNull(builderAfterPastaType);

    }

    @Test
    public void shouldReturnBuilderAfterSauceSetup() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();
        //when
        Pasta.PastaBuilder builderAfterSauce = builder.sauce("tomato");
        //then
        assertNotNull(builderAfterSauce);

    }

    @Test
    public void shouldReturnBuilderAfterSpicesSetup() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();
        //when
        Pasta.PastaBuilder builderAfterSpices = builder.spices("garlic");
        //then
        assertNotNull(builderAfterSpices);

    }

    @Test
    public void shouldReturnBuilderAfterParmezanSetup() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();
        //when
        Pasta.PastaBuilder builderAfterParmezan = builder.parmezan(true);
        //then
        assertNotNull(builderAfterParmezan);

    }

    @Test
    public void shouldReturnPastaOnBuild() {
        //given
        Pasta.PastaBuilder builder = Pasta.builder();
        //when
        Pasta pasta = builder.build();
        //then
        assertNotNull(pasta);
    }

    @Test
    public void shouldBeAbleToSetPastaFieldsWithBuilder() {
        //given
        PastaType pastaType = PastaType.PIPE;
        String sauce = "tomato";
        String spices = "garlic";
        String spices2 = "salt";
        boolean parmezan = true;

        //when
        Pasta pasta = Pasta.builder()
                .pastaType(pastaType)
                .sauce(sauce)
                .spices(spices)
                .spices(spices2)
                .parmezan(parmezan)
                .build();

        //then
        assertEquals(pastaType, pasta.getPastaType());
        assertEquals(sauce, pasta.getSauce());
        assertTrue(pasta.getSpices().contains(spices));
        assertTrue(pasta.getSpices().contains(spices2));
        assertEquals(parmezan, pasta.isParmezan());


    }
}