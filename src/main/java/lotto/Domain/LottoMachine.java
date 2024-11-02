package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Messages.ErrorMessage;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_STOCK = 10000;
    private PurchaseAmount amount;

    private LottoMachine(PurchaseAmount purchaseAmount) {
        this.amount = purchaseAmount;
    }

    public static LottoMachine from(PurchaseAmount purchaseAmount) {
        validateAmount(purchaseAmount);

        return new LottoMachine(purchaseAmount);
    }

    private static void validateAmount(PurchaseAmount purchaseAmount) {
        int amount = purchaseAmount.getValue();
        checkMinimum(amount);
        checkDivisible(amount);
        checkLimit(amount);
    }

    private static void checkMinimum(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkLimit(int amount) {
        if (amount / LOTTO_PRICE > MAX_STOCK) {
            throw new IllegalArgumentException(ErrorMessage.MAX_OUT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private int calculateMaxLottos() {
        return amount.getValue() / LOTTO_PRICE;
    }

    private List<Lotto> generateLottos() {
        int maxLottos = calculateMaxLottos();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < maxLottos; i++) {
            lottos.add(Lotto.create());
        }

        return lottos;
    }

    public void buyLottos(){
        List<Lotto> lottos = generateLottos();
    }

}
