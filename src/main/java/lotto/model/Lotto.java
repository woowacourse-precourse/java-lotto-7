package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.ErrorMessage;

public class Lotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> newNumbers = numbers.stream().toList();
        validateSize(newNumbers);
        validateNumbersRange(newNumbers);
        validateDuplicateNumbers(newNumbers);
        this.numbers = newNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_SIX.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> validateNumberRange(number));
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctNumbersSize = numbers.stream().distinct().count();
        if (distinctNumbersSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DISTINCT.getMessage());
        }
    }

    public static List<Lotto> createLottos(final int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE)))
                .toList();
    }

    public int getSize() {
        return LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
