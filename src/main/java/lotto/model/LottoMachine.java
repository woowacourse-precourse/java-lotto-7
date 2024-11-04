package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final String ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String ERROR_NOT_NEGATIVE_PURCHASE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다.";

    private static final int PURCHASE_AMOUNT_UNITS = 1000;
    private static final int LOOP_START_INDEX = 0;
    private static final int ZERO = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        validate(purchaseAmount);

        int count = purchaseAmount / PURCHASE_AMOUNT_UNITS;

        for (int i = LOOP_START_INDEX; i < count; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            lottos.add(lotto);
        }
        return lottos;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_NEGATIVE_PURCHASE_NUMBER);
        }
        if (purchaseAmount % PURCHASE_AMOUNT_UNITS != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
