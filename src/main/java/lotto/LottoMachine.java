package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private static final int AMOUNT_UNIT = 1000;
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_MAX_RANGE = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 구매 금액이 1000단위여야 합니다.";

    public List<Lotto> issueLottos(int amount) {
        validateAmount(amount);

        int lottoCnt = amount / AMOUNT_UNIT;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_UNIT != 0) throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBER_COUNT));
    }
}
