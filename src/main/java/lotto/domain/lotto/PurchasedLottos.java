package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.constant.LottoConstant;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {

    private static final int INT_ZERO = 0;

    private final List<Lotto> purchaseLottos;

    private PurchasedLottos(final int count) {
        purchaseLottos = new ArrayList<>();
        generateLottos(count);
    }

    public static PurchasedLottos from(final int purchaseAmount) {
        return new PurchasedLottos(calculatePurchaseCount(purchaseAmount));
    }

    private void generateLottos(final int count) {
        for (int i = INT_ZERO; i < count; i++) {
            List<Integer> numbers = generateRandomNumber();
            purchaseLottos.add(Lotto.from(numbers));
        }
    }

    private static List<Integer> generateRandomNumber() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER,
                LottoConstant.MAX_LOTTO_NUMBER,
                LottoConstant.LOTTO_SIZE
        ));
    }

    private static int calculatePurchaseCount(int purchaseAmount) {
        Validator.validate(purchaseAmount);
        return purchaseAmount / LottoConstant.LOTTO_PRICE;
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchaseLottos);
    }

    private static class Validator {

        private static void validate(final int purchaseAmount) {
            validatePositiveAmount(purchaseAmount);
            validateDivisibleByPrice(purchaseAmount);
        }

        private static void validatePositiveAmount(final int purchaseAmount) {
            if (purchaseAmount <= INT_ZERO) {
                throw LottoException.from(ErrorMessage.REQUIRED_POSITIVE_NUMBER);
            }
        }

        private static void validateDivisibleByPrice(final int purchaseAmount) {
            if (purchaseAmount % LottoConstant.LOTTO_PRICE != INT_ZERO) {
                throw LottoException.from(ErrorMessage.INVALID_PURCHASE_AMOUNT);
            }
        }
    }
}