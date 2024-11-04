package lotto.Service;

import lotto.View.OutputView;

public class MarginService {
    private double costPrice;
    private double sellingPrice;
    private final int DecimalPlaces = 2;
    private double value;

    public void calculateProfitMargin() {
        value = (sellingPrice / costPrice) * 100;
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
        OutputView.displayRounds(round());
    }
}
