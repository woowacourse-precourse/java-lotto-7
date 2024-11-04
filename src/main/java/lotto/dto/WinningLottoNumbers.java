package lotto.dto;

import static lotto.config.LottoRegularExpression.SEPARATOR;
import static lotto.validator.LottoWinningNumbersValidator.validateLottoWinningNumbers;

import java.util.Arrays;
import java.util.List;

public record WinningLottoNumbers(
        List<Integer> numbers
) {
    public static WinningLottoNumbers of(String inputWinningLottoNumbers) {
        validateLottoWinningNumbers(inputWinningLottoNumbers);
        return new WinningLottoNumbers(Arrays.stream(inputWinningLottoNumbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .toList());
    }
}
