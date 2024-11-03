package lotto.model.lottoInfo;

import java.util.List;

public class LottoGame {
    private WinningNumber winningNumbers;
    private BonusNumber bonusNumber;
    private final LottoPrice price;
    private final PriceData priceByRank;

    public LottoGame(LottoPrice price, PriceData priceByRank) {
        this.price = price;
        this.priceByRank = priceByRank;
    }

    public void enterWinningNumber(List<Integer> integers) {
        this.winningNumbers = new WinningNumber(integers);
    }

    public Integer getPrice() {
        return price.getPrice();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getWinningNumbers();
    }
}
