package lotto.model;

import lotto.ui.InputView;

import java.util.List;

public class LottoGameInfo {
    private int purchaseAmount;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private int lottotickets;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getLottotickets() {
        return lottotickets;
    }

    public void setLottotickets(int amount) {
        this.lottotickets = amount / 1000;
    }


}
