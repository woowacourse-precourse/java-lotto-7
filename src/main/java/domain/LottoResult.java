package domain;

import lotto.Lotto;

import java.util.List;

public class LottoResult {
    private int purchaseAmount;        // 구매금액
    private int totalLottos;           // 구매한 로또의 총 개수
    private int winningLottoCount;     // 당첨 로또의 개수
    private int[] winningNumbers;      // 당첨 번호
    private int bonusNumber;           // 보너스 번호
    private List<Lotto> purchasedLottos; // 구매한 로또 번호 리스트

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getTotalLottos() {
        return totalLottos;
    }

    public void setTotalLottos(int totalLottos) {
        this.totalLottos = totalLottos;
    }

    public int getWinningLottoCount() {
        return winningLottoCount;
    }

    public void setWinningLottoCount(int winningLottoCount) {
        this.winningLottoCount = winningLottoCount;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(int[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void setPurchasedLottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }
}
