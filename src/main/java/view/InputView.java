package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static view.message.ExceptionMessage.BANK_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.COMMA_SEPARATED_NUMBERS_REGEX;
import static view.message.ExceptionMessage.POSITIVE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.POSITIVE_NUMBER_REGEX;
import static view.message.ExceptionMessage.FORMAT_EXCEPTION_MESSAGE;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static BigDecimal readPurchaseAmount() {
        String purchaseAmount = readLine();
        validateBlank(purchaseAmount);
        validatePositiveNumber(purchaseAmount);
        return new BigDecimal(purchaseAmount);
    }

    public static List<Integer> readLottoNumbers() {
        String lottoNumbers = readLine();
        validateBlank(lottoNumbers);
        validateLottoNumbersFormat(lottoNumbers);
        return Arrays.stream(lottoNumbers.split(","))
                     .map(Integer::parseInt)
                     .toList();
    }

    public static int readBonusNumber() {
        String bonusNumber = readLine();
        validateBlank(bonusNumber);
        validatePositiveNumber(bonusNumber);
        return parseInt(bonusNumber);
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BANK_EXCEPTION_MESSAGE);
        }
    }

    private static void validatePositiveNumber(String input) {
        if (!input.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validateLottoNumbersFormat(String lottoNumbers) {
        if (!lottoNumbers.matches(COMMA_SEPARATED_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
