package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static final int PRICE = 1_000;
    public static final int LIMIT_PRICE = 100_000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;

    private LottoGenerator() {}

    public static int howManyLottos(int amount) {
        validate(amount);
        return amount / PRICE;
    }

    public static List<Lotto> getLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return new Lotto(numbers);
    }

    private static void validate(int account) {
        if (account < PRICE || account > LIMIT_PRICE) {
            throw new IllegalArgumentException(Error.AMOUNT_RANGE_ERROR.message());
        }

        if (account % PRICE != 0) {
            throw new IllegalArgumentException(Error.AMOUNT_UNIT_ERROR.message());
        }
    }
}