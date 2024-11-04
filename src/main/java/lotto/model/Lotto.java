package lotto.model;

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
        this.numbers = newNumbers.stream().sorted().toList();
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

    public static List<Lotto> createLottos(List<List<Integer>> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> new Lotto(numbers.get(i)))
                .toList();
    }

    public int getSize() {
        return LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    public static int getMaxNumber() {
        return MAX;
    }

    public static int getMinNumber() {
        return MIN;
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }


}
