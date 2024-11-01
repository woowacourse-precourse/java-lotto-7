package lotto.Domain;

import lotto.Constants.Error;
import lotto.Lotto;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private int remainingAmount;
    private int bonusNumber;
    private Lotto playerLotto;

    public LottoMachine(int purchaseAmount, int bonusNumber, Lotto playerLotto) {
        this.purchaseAmount = purchaseAmount;
        this.remainingAmount = purchaseAmount % 1000;
        this.bonusNumber = bonusNumber;
        this.playerLotto = playerLotto;
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LottoMachine.LOTTO_PRICE) {
            throw new IllegalArgumentException(lotto.Constants.Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
        }
        if (amount % LottoMachine.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
        }
    }
}
