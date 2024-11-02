package lotto.domain;

public class RateOfReturn {

    private static final double PERCENTAGE = 100.0;

    private final LottoResult lottoResult;

    public RateOfReturn(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double getRateOfReturn() {
        return (lottoResult.calculateTotalPrize() / (double) lottoResult.getPurchasePrice() * PERCENTAGE);
    }
}
