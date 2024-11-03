package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ErrorCode;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoGenerator {
    private final Supplier<List<Integer>> randomNumbers;
    private final Integer price;
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer TOTAL_COUNT = 6;

    public LottoGenerator(String price) {
        this(price, () -> Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, TOTAL_COUNT));
    }

    public LottoGenerator(String price, Supplier<List<Integer>> randomNumbers) {
        validatePrice(price);
        this.price = Integer.parseInt(price);
        this.randomNumbers = randomNumbers;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = randomNumbers.get();
        return new Lotto(numbers);
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int count = price / 1000;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private void validatePrice(String input) throws IllegalArgumentException {
        validatePriceNumeric(input);
        validatePriceDivisible(input);
    }

    private void validatePriceNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.PRICE_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validatePriceDivisible(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new NumberFormatException(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
        }
    }

}
