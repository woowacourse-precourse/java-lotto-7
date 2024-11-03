package lotto.Service;

public class MarginService {
    private double costPrice;
    private double sellingPrice;
    private final int DecimalPlaces = 2;
    private double value;

    public void calculateProfitMargin() {
        if (sellingPrice == 0) {
            value = 0;
        }
        value = (sellingPrice - costPrice) / sellingPrice * 100;
    }

    public double round() {
        double scale = Math.pow(10, DecimalPlaces);
        return Math.round(value * scale) / scale;
    }

    public void setCostPrice(int payment) {
        costPrice = payment;
    }

    public void setSellingPrice(int money) {
        sellingPrice = money;
    }

    public void displayResult() {
        System.out.printf("총 수익률은 : %.2f%%입니다.\n", round());
    }
}
