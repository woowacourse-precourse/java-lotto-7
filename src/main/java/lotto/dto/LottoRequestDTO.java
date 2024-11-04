package lotto.dto;

import java.util.List;

public class LottoRequestDTO {
    private int purchaseAmount; // 로또 구입 금액
    private List<Integer> winningNumbers; // 당첨 번호
    private int bonusNumber; // 보너스 번호

    public LottoRequestDTO(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // Getters
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}