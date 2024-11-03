package lotto.util;

import static lotto.constant.GlobalConstant.COMMA_DELIMITER;
import static lotto.exception.LottoInputException.validateBonusNumberInput;
import static lotto.exception.LottoInputException.validateWinningNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoInputException;

public class LottoUtil {

    public static List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbers(input);

        return new ArrayList<>(
                Arrays.stream(input.split(COMMA_DELIMITER))
                        .map(Integer::parseInt)
                        .sorted()
                        .toList()
        );
    }

    public static int parseAndValidateBonusNumber(String input) {
        validateBonusNumberInput(input);
        int bonusNumber = convertStringToInt(input);
        LottoInputException.validateLottoNumbersRange(bonusNumber);
        return bonusNumber;
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

}
