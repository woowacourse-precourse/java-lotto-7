package lotto.domain.lottoForm;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.NON_INTEGER_LOTTO;

public class WinningNumbers extends LottoForm {
    private static final String SPLIT_DELIMITER = ",";

    private WinningNumbers(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningNumbers from(String input) {
        List<Integer> rawNumbers = convertToIntegers(input);
        return new WinningNumbers(rawNumbers);
    }


    private static List<Integer> convertToIntegers(String input) {
        List<String> inputs = Arrays.asList(input.split(SPLIT_DELIMITER));
        try {
            return inputs.stream().map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_LOTTO.getMessage());
        }
    }

    public void validateDuplicate(LottoNumber bonusNumber) {
        numbers.stream()
                .filter(lottoNumber -> lottoNumber.isSame(bonusNumber))
                .findAny()
                .ifPresent(foundLottoNumber -> {
                    throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
                });
    }

    public boolean contains(LottoNumber number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSame(number));
    }
}
