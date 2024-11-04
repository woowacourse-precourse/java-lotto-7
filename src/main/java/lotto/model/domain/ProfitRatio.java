package lotto.model.domain;

public class ProfitRatio {
    private double ratio;

    public ProfitRatio(int prize, int purchaseAmount) {
        ratio = calculatePercent(prize, purchaseAmount);
    }

    private double calculatePercent(int prize, int purchaseAmount) {
        double percent = ((double) prize / (double) purchaseAmount) * 100;
        return Math.round(percent * 10) / 10.0;
    }

    public double get() {
        return ratio;
    }

    public String getFormatted() {
        return String.format("%,.1f", ratio) + "%";
    }

}
