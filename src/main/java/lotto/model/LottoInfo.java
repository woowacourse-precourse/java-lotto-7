package lotto.model;

public class LottoInfo {
    private WinningNumber winningNumbers;
    private BonusNumber bonusNumber;
    private final LottoPrice price;
    private final PriceData priceByRank;

    public LottoInfo(LottoPrice price, PriceData priceByRank) {
        this.price = price;
        this.priceByRank = priceByRank;
    }

    public Integer getPrice() {
        return price.getPrice();
    }

}
