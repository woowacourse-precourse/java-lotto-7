package lotto.model;

public record PrizeRate(double prizeRate) {

    public String getPrizeRate() {
        return String.format("%.1f", prizeRate) + "%";
    }
}
