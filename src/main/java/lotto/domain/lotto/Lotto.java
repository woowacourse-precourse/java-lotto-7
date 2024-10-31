package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class Lotto {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateLotto(numbers);
    }

    //todo: 중복, (1,2,)
    private List<Integer> validateLotto(List<Integer> inputNumbers) {
        return ValidatorBuilder.from(inputNumbers)
                .validateGroup(numbers -> numbers.size() != LOTTO_SIZE, Exception.INVALID_LOTTO_SIZE)
                .validateGroup(numbers -> numbers.stream()
                                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER),
                        Exception.INVALID_LOTTO_NUMBER)
                .gets();
    }

    public static Lotto from(String numbers) {
        return new Lotto(parseNumbers(numbers));
    }

    private static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    // TODO: 추가 기능 구현
}
