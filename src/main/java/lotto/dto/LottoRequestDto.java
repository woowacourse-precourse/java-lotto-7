package lotto.dto;

public class LottoRequestDto {
    private final String purchaseAmount;
    private final String lottoNumbers;
    private final String bonusNumber;

    public LottoRequestDto(String purchaseAmount, String lottoNumbers, String bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }
    public String getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public String getLottoNumbers() {
        return this.lottoNumbers;
    }

    public String getBonusNumber() {
        return this.bonusNumber;
    }
}
