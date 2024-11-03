package lotto.domain;

public class Profit {
    private final LottoResult lottoResult;
    private final LottoCount lottoCount;

    public Profit(LottoResult lottoResult, LottoCount lottoCount) {
        this.lottoResult = lottoResult;
        this.lottoCount = lottoCount;
    }

    public double calculateTotalProfit() {
        return (getWinningPrize() / getPurchasedPrice()) * 100;
    }

    private double getPurchasedPrice() {
        return lottoCount.getCount() * 1000;
    }

    private double getWinningPrize() {
        return lottoResult.calculateWinningPrize();
    }
}
