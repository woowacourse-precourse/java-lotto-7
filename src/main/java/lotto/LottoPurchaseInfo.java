package lotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoPurchaseInfo {

    private final BigDecimal purchaseAmount;
    private final Lotto numbers;
    private final int bonusNumber;

    private LottoPurchaseInfo(BigDecimal purchaseAmount, Lotto numbers, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoPurchaseInfo of(BigDecimal totalPurchase, List<Integer> lottoNumbers, int bonusNumber) {
        return new LottoPurchaseInfo(totalPurchase, new Lotto(lottoNumbers), bonusNumber);
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
