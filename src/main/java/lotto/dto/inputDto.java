package lotto.dto;

public class inputDto {
    private String purchaseAmountStr;
    private String winningNumStr;
    private String bonusNumber;

    public inputDto(String purchaseAmountStr, String winningNumStr, String bonusNumber) {
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
}
