package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> purchase(int amount) {
        validateAmount(amount);
        int count = calculateLottoCount(amount);
        return createLottos(count);
    }

    private void validateAmount(int amount) {
        validatePositive(amount);
        validateUnit(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원보다 커야 합니다.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
        );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}