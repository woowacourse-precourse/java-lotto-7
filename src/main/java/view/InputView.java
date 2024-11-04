package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static view.message.ExceptionMessage.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static BigDecimal readPurchaseAmount() {
        String purchaseAmount = readLine();
        validateBlank(purchaseAmount);
        validateNumber(purchaseAmount);
        return new BigDecimal(purchaseAmount);
    }

    public static List<Integer> readLottoNumbers() {
        String lottoNumbers = readLine();
        validateBlank(lottoNumbers);
        validateNumber(lottoNumbers);
        return Arrays.stream(lottoNumbers.split(","))
                     .map(Integer::parseInt)
                     .toList();
    }

    public static int readBonusNumber() {
        String bonusNumber = readLine();
        validateBlank(bonusNumber);
        validateNumber(bonusNumber);
        return parseInt(bonusNumber);
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BANK_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
