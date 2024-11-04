package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.numberPicker.NumberPicker;
import lotto.domain.validator.ParamsValidator;
import lotto.exception.lotto.LottoNumberCountInvalidException;
import lotto.exception.lotto.LottoNumberDuplicatedException;

final public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int PRICE = 1000;

    private final List<Number> numbers;

    private Lotto(final List<Number> numbers) {
        validateNumbersCount(numbers);
        validateNumbersNotDuplicated(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private static void validateNumbersCount(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoNumberCountInvalidException(LOTTO_NUMBER_COUNT);
        }
    }

    private static void validateNumbersNotDuplicated(List<Number> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoNumberDuplicatedException();
        }
    }

    private static boolean hasDuplicatedNumber(List<Number> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public static Lotto from(List<Integer> numbers) {
        ParamsValidator.validateParamsNotNull(Lotto.class, numbers);

        return new Lotto(Number.from(numbers));
    }

    public static List<Lotto> purchase(final Money money, final NumberPicker numberPicker) {
        ParamsValidator.validateParamsNotNull(Lotto.class, money, numberPicker);

        int purchaseAmount = calculatePurchaseAmount(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Number> numbers = Number.createUniqueNumbers(LOTTO_NUMBER_COUNT, numberPicker);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int calculatePurchaseAmount(Money money) {
        return money.getAmount() / PRICE;
    }

    public int getMatchCount(final Lotto otherLotto) {
        ParamsValidator.validateParamsNotNull(Lotto.class, otherLotto);

        return (int) this.numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public boolean contains(final Number number) {
        ParamsValidator.validateParamsNotNull(Lotto.class, number);

        return this.numbers.stream()
                .anyMatch(number::equals);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
