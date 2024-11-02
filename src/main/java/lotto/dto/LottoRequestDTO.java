package lotto.dto;

public class LottoRequestDTO {
    private int purchaseAmount; // 로또 구입 금액
    private int[] winningNumbers; // 당첨 번호
    private int bonusNumber; // 보너스 번호

    public LottoRequestDTO(int purchaseAmount, int[] winningNumbers, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // Getters
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}