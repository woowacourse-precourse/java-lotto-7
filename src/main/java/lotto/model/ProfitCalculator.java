package lotto.model;

public class ProfitCalculator {
    private final Integer amount;
    private final LottoResult lottoResult;

    public ProfitCalculator(int amount, LottoResult lottoResult) {
        this.amount = amount;
        this.lottoResult = lottoResult;
    }

}
