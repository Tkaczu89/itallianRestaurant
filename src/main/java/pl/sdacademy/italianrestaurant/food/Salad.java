package pl.sdacademy.italianrestaurant.food;


public class Salad implements Food {

    private final SaladType saladType;
    private final boolean isItCarrot;
    private final boolean isItTomato;
    private final boolean isItVegetarian;
    private final KindOfCheese kindOfCheese;
    private final KindOfMeat kindOfMeat;


    private Salad(Salad.SaladBuilder saladBuilder) {
        saladType = saladBuilder.saladType;
        isItCarrot = saladBuilder.isItCarrot;
        isItTomato = saladBuilder.isItTomato;
        isItVegetarian = saladBuilder.isItVegetarian;
        kindOfCheese = saladBuilder.kindOfCheese;
        kindOfMeat = saladBuilder.kindOfMeat;
    }


    public SaladType getSaladType() {
        return saladType;
    }

    public boolean isItCarrot() {
        return isItCarrot;
    }

    public boolean isItTomato() {
        return isItTomato;
    }

    public boolean isItVegetarian() {
        return isItVegetarian;
    }

    public KindOfCheese getKindOfCheese() {
        return kindOfCheese;
    }

    public KindOfMeat getKindOfMeat() {
        return kindOfMeat;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "saladType=" + saladType +
                ", isItCarrot=" + isItCarrot +
                ", isItTomato=" + isItTomato +
                ", isItVegetarian=" + isItVegetarian +
                ", kindOfCheese=" + kindOfCheese +
                ", kindOfMeat=" + kindOfMeat +
                '}';
    }

    public static Salad.SaladBuilder builder() {
        return new Salad.SaladBuilder();
    }

    public static class SaladBuilder {
        private SaladType saladType;
        private boolean isItCarrot;
        private boolean isItTomato;
        private boolean isItVegetarian;
        private KindOfCheese kindOfCheese;
        private KindOfMeat kindOfMeat;


        private SaladBuilder() {
        }

        public SaladBuilder SaladType(SaladType saladType) {
            this.saladType = saladType;
            return this;
        }

        public SaladBuilder isItCarrot(boolean isItCarrot) {
            this.isItCarrot = isItCarrot;
            return this;
        }

        public SaladBuilder isItTomato(boolean isItTomato) {
            this.isItTomato = isItTomato;
            return this;
        }

        public SaladBuilder isItVegetarian(boolean isItVegetarian) {
            this.isItVegetarian = isItVegetarian;
            return this;
        }

        public SaladBuilder kindOfCheese(KindOfCheese kindOfCheese) {
            this.kindOfCheese = kindOfCheese;
            return this;
        }

        public SaladBuilder kindOfMeat(KindOfMeat kindOfMeat) {
            this.kindOfMeat = kindOfMeat;
            return this;
        }

        public Salad build() {
            return new Salad(this);
        }


    }

}


