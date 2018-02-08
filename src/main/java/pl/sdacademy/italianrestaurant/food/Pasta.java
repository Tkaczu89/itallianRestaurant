package pl.sdacademy.italianrestaurant.food;

import java.util.HashSet;
import java.util.Set;

public class Pasta implements Food {

    private final PastaType pastaType;
    private final String sauce;
    private final Set<String> spices;
    private final boolean parmezan;


    private Pasta(PastaBuilder pastaBuilder) {
        pastaType = pastaBuilder.pastaType;
        sauce = pastaBuilder.sauce;
        spices = pastaBuilder.spices;
        parmezan = pastaBuilder.parmezan;
    }


    public PastaType getPastaType() {
        return pastaType;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getSpices() {
        return spices;
    }

    public boolean isParmezan() {
        return parmezan;
    }

    @Override
    public String toString() {
        return "Pasta{" +
                "pastaType=" + pastaType +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + spices +
                ", parmezan=" + parmezan +
                '}';
    }

    public static PastaBuilder builder() {
        return new PastaBuilder();
    }

    public static class PastaBuilder {
        private PastaType pastaType;
        private String sauce;
        private Set<String> spices;
        private boolean parmezan;

        public PastaBuilder() {
            spices = new HashSet<String>();
        }

        public PastaBuilder pastaType(PastaType pastaType) {
            this.pastaType = pastaType;
            return this;
        }

        public PastaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PastaBuilder spices(String spices) {
            this.spices.add(spices);
            return this;
        }
        public PastaBuilder parmezan(boolean parmezan){
            this.parmezan = parmezan;
            return this;
        }

        public Pasta build() {
            return new Pasta(this);
        }


    }

}
