package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public class LottoPurchaseInfo {

    private final BigDecimal purchaseAmount;
    private final Lotto numbers;
    private final int bonusNumber;

    private LottoPurchaseInfo(BigDecimal purchaseAmount, Lotto numbers, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoPurchaseInfo of(String totalPurchase, String numbers, String number) {
        BigDecimal purchaseAmount = new BigDecimal(totalPurchase);
        Lotto lottoNumbers = new Lotto(
                Arrays.stream(numbers.split(","))
                      .map(Integer::parseInt)
                      .toList()
        );
        int bonusNumber = Integer.parseInt(number);

        return new LottoPurchaseInfo(purchaseAmount, lottoNumbers, bonusNumber);
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
