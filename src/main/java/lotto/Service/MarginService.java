package lotto.Service;

import lotto.View.OutputView;

public class MarginService {
    private double costPrice;
    private double sellingPrice;
    private final int DecimalPlaces = 2;
    private double value;

    public void calculateProfitMargin() {
        value = (sellingPrice / costPrice) * 100;
        if (sellingPrice == 0) {
            value = 0;
        }
    }

    public double round() {
        double scale = Math.pow(10, DecimalPlaces);
        if (value == 0) {
            return 0;
        }
        return Math.round(value * scale) / scale;
    }

    public void setCostPrice(int payment) {
        costPrice = payment;
    }

    public void setSellingPrice(int money) {
        sellingPrice = money;
    }

    public void displayResult() {
        OutputView.displayRounds(round());
    }
}
