package hw1;

public class House {
    private final String addy;

    private final int milkDelivered;


    public House(String addy, int milkDelivered){
        this.addy = addy;
        this.milkDelivered = milkDelivered;
    }

    public String getAddy() {
        return addy;
    }

    public int getMilkDelivered() {
        return milkDelivered;
    }

    @Override
    public String toString() {
        return "House{" +
                "addy='" + addy + '\'' +
                ", milkDelivered=" + milkDelivered +
                '}';
    }
}
