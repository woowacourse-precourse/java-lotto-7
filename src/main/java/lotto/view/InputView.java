package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.InputErrorCode.INVALID_LOTTO_NUMBER_PATTERN;
import static lotto.exception.InputErrorCode.LOTTO_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.exception.LottoException;

public class InputView {

    private static final Pattern validLottoPurchaseAmountPattern = Pattern.compile("^[1-9][0-9]*000$");
    private static final Pattern validWonLottoNumbersPattern = Pattern.compile(
            "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$");

    public static int inputLottoPurchaseAmount() {
        String userInput = readLine();
        validateLottoPurchaseAmount(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validateLottoPurchaseAmount(String userInput) {
        if (!validLottoPurchaseAmountPattern.matcher(userInput).matches()) {
            throw new LottoException(LOTTO_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000);
        }
    }

    public static Lotto wonLottoNumbers() {
        String userInput = readLine();
        validateWonLottoNumbers(userInput);

        return new Lotto(parseWonLottoNumbers(userInput));
    }

    private static List<Integer> parseWonLottoNumbers(String userInput) {
        return Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
    }

    private static void validateWonLottoNumbers(String userInput) {
        if (!validWonLottoNumbersPattern.matcher(userInput).matches()) {
            throw new LottoException(INVALID_LOTTO_NUMBER_PATTERN);
        }
    }

    public static BonusNumber inputBonusNumber() {
        return new BonusNumber(readLine());
    }
}
