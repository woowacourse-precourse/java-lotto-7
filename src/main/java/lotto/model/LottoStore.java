package lotto.model;

import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_BELOW_MINIMUM;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_MUST_BE_NUMBER;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos purchaseLottos(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);

        long purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        int numberOfLottos = getNumberOfLottos(purchaseAmount);
        List<Lotto> lottos = generateLottosByCount(numberOfLottos);

        return new Lottos(numberOfLottos, lottos);
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        checkIsNumber(purchaseAmountInput);
        long purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        checkMinimumAmount(purchaseAmount);
        checkUnit(purchaseAmount);
    }

    private long parsePurchaseAmount(String purchaseAmountInput) {
        return Long.parseLong(purchaseAmountInput);
    }

    private static void checkIsNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        }
    }

    private static void checkMinimumAmount(long purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_BELOW_MINIMUM.getMessage());
        }
    }

    private static void checkUnit(long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    private int getNumberOfLottos(long purchaseAmount) {
        return (int) (purchaseAmount / LOTTO_PRICE);
    }

    private List<Lotto> generateLottosByCount(long numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    public Lotto generateRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT));
    }
}
