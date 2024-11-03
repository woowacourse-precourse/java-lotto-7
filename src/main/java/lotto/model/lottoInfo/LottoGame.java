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

    public void enterBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Integer getPrice() {
        return price.getPrice();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getWinningNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
