package lotto.dto;

public class LottoDraw {
    private final int purchaseAmount;
    private final String lottoNumbers;

    public LottoDraw(int purchaseAmount, String lottoNumbers) {
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
