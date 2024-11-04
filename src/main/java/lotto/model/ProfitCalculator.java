package lotto.model;

public class ProfitCalculator {

    public double calculateProfit(int winPrice, int totalPrice) {
        return (double) winPrice / totalPrice * 100;
    }
}
