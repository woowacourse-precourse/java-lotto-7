package lotto.model;

public record Money (int amount) {

    public int getLottoTicket() {
        return amount / 1000;
    }

    public PrizeRate calculatePrizeRate(Result result) {
        long prize = result.calculatePrize();
        return new PrizeRate((double) prize / amount * 100);
    }
}
