package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.common.ErrorMessage;
import lotto.helper.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private final int cost;
    private final int count;
    private final int divideUnit = 1000;

    public LottoFactory(String cost) {
        this.cost = parseOrThrow(cost);
        this.count = this.calculateCountOrThrow();
    }

    public List<Lotto> generate() {
        List<Lotto> lots = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lots.add(makeNewLotto());
        }
        return lots;
    }

    private Lotto makeNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private int parseOrThrow(String count) {
        try {
            InputValidator.validateNumeric(count);
            return Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.unknownError);
        }
    }

    private int calculateCountOrThrow() {
        if (this.cost % divideUnit != 0) {
            throw new IllegalArgumentException(ErrorMessage.cantDividedInto1000);
        }
        return this.cost / divideUnit;
    }
}
