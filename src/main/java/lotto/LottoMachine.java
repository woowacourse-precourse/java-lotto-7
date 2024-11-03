package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    static final int AMOUNT_UNIT = 1000;

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
        if (amount % AMOUNT_UNIT != 0) throw new IllegalArgumentException("[ERROR] 구매 금액이 1000단위여야 합니다.");
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
