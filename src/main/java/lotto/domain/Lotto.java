package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_LENGTH_ERROR_MESSAGE =
            ERROR_MESSAGE + "로또 번호는 %d개여야 합니다.";
    private static final String SEPARATOR = ",";

    private final Set<LottoNumber> numbers;

    private Lotto(List<LottoNumber> lotto) {
        this.numbers = new HashSet<>(lotto);
        validateLotto();
    }


    private void validateLotto() {
        if (this.numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(LOTTO_LENGTH_ERROR_MESSAGE, LOTTO_SIZE));
        }
    }

    public static Lotto createFromNumbers(List<Integer> numbers) {
        return of(numbers.toArray(new Integer[0]));
    }

    public static Lotto createFromString(String text) {
        String[] numbers = text.split(SEPARATOR);
        return of(toIntegers(numbers));
    }

    private static Integer[] toIntegers(String[] strings) {
        return Arrays.stream(strings)
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    public static Lotto of(Integer... numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto::isContains)
                .count();
    }

    public boolean isContains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public String sortNumbers() {
        return numbers.stream()
                .map(LottoNumber::toInt)
                .sorted()
                .toList()
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
