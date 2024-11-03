package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_COUNT);
        }
        boolean allInRange = numbers.stream().
                allMatch(n -> n >= LottoConstant.LOTTO_NUMBER_MIN && n <= LottoConstant.LOTTO_NUMBER_MAX);
        if (!allInRange) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_VALID_RANGE);
        }
        HashSet<Integer> checkNumbersCount = new HashSet<>(numbers);
        if (checkNumbersCount.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionConstant.DUPLICATE_NUMBER);
        }
    }

    public Stream<Integer> streamNumbers() {
        return numbers.stream();
    }

    public void lottoNumbersPrint() {
        String result = "[" +
                this.numbers.stream().map(String::valueOf).collect(Collectors.joining(", "))
                + "]";
        System.out.println(result);
    }
}
