package lotto;

import static lotto.exception.Exception.LOTTO_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.Exception.MINIMUM_LOTTO_COUNT_REQUIRED;

import java.util.List;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private LottoSeller() {
    }

    /**
     * 주어진 금액으로 로또를 판매한다.
     * 금액 검증 후 로또 생성 및 반환이 이루어질 예정이다.
     *
     * @param amount 판매할 로또의 총 금액
     * @throws IllegalArgumentException 금액이 유효하지 않은 경우
     */
    public static List<Lotto> sell(int amount) {
        vaildate(amount);
        return List.of();
    }

    private static void vaildate(int amount) {
        validateAtLeastOneLotto(amount);
        validateAmountDivisibility(amount);
    }

    private static void validateAtLeastOneLotto(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_COUNT_REQUIRED.getMessage());
        }
    }

    private static void validateAmountDivisibility(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }
}
