package lotto.dto;

public class LottoRequestDto {
    private final String purchaseAmount;
    private final String winningNumbers;
    private final String bonusNumber;

    public LottoRequestDto(String purchaseAmount, String winningNumbers, String bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public String getWinningNumbers() {
        return this.winningNumbers;
    }

    public String getBonusNumber() {
        return this.bonusNumber;
    }
}
