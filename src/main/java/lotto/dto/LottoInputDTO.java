package lotto.dto;

public class LottoInputDTO {
    private final int purchaseAmount;
    private final String[] winningNumbers;
    private final String bonusNumber;

    public LottoInputDTO(int purchaseAmount, String[] winningNumbers, String bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String[] getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
