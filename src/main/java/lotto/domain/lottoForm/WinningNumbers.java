package lotto.domain.lottoForm;

import lotto.domain.number.BonusNumber;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.Number;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.NON_INTEGER_LOTTO;

public class WinningNumbers extends LottoForm {
    private final String SPLIT_DELIMITER = ",";
//    private final List<Integer> numbers;
    private final List<Number> numbers2;

    public WinningNumbers(String input) {
        List<Integer> rawNumbers = convertToIntegers(input);
//        this.numbers = validateAndSort(rawNumbers);
        this.numbers2 = validateAndSort(rawNumbers).stream()
                .map(Number::new)
                .toList();
    }

    private List<Integer> convertToIntegers(String input) {
        List<String> inputs = Arrays.asList(input.split(SPLIT_DELIMITER));
        try {
            return inputs.stream().map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_LOTTO.getMessage());
        }
    }

    public void validateDuplicate(BonusNumber bonusNumber) {
        numbers2.stream()
                .filter(number2 -> number2.isSame(bonusNumber))
                .findAny()
                .ifPresent(foundNumber -> {
                    throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
                });

//        if (numbers.contains(number)) {
//            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
//        }
    }

    public boolean contains(LottoNumber number) {
        return numbers2.stream()
                .anyMatch(number2 -> number2.isSame(number));
    };
}
