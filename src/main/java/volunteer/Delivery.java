package volunteer;

public class Delivery {

    private long deleveryNum = 0;
    private String deliveryAddress ="";
    private int numberOfParcels = 0;

    @Override
    public String toString() {
        return "Delivery{" +
                "deleveryNum=" + deleveryNum +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", numberOfParcels=" + numberOfParcels +
                '}';
    }

    public Delivery(){}

    public Delivery(long deleveryNum, String deliveryAddress, int numberOfParcels) {
        this.deleveryNum = deleveryNum;
        this.deliveryAddress = deliveryAddress;
        this.numberOfParcels = numberOfParcels;
    }

    public long getDeleveryNum() {
        return deleveryNum;
    }

    public void setDeleveryNum(long deleveryNum) {
        this.deleveryNum = deleveryNum;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getNumberOfParcels() {
        return numberOfParcels;
    }

    public void setNumberOfParcels(int numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }
}
