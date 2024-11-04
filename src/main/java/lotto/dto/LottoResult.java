package lotto.dto;

public class LottoResult {
    private final int purchaseAmount;
    private final String lottoNumbers;

    public LottoResult(int purchaseAmount, String lottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumbers = lottoNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getLottoNumbers() {
        return lottoNumbers;
    }
}
