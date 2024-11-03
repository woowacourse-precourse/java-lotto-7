package lotto.dto;

public class InputDto {
    private String purchaseAmountStr;
    private String winningNumStr;
    private String bonusNumber;

    public InputDto(String purchaseAmountStr, String winningNumStr, String bonusNumber) {
        this.purchaseAmountStr = purchaseAmountStr;
        this.winningNumStr = winningNumStr;
        this.bonusNumber = bonusNumber;
    }

    public String getPurchaseAmountStr() {
        return purchaseAmountStr;
    }

    public String getWinningNumStr() {
        return winningNumStr;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public boolean validateDto() {
        return (
                purchaseAmountStr != null && !purchaseAmountStr.isEmpty() &&
                winningNumStr != null && !winningNumStr.isEmpty() &&
                bonusNumber != null && !bonusNumber.isEmpty()
        );
    }
}
