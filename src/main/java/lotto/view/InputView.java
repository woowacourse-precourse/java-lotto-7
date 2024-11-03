package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int readPurchasePrice() {
        String purchasePrice = Console.readLine();
        if (!purchasePrice.matches(GameConfig.VALID_DIGIT_LENGTH_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.MAX_AMOUNT_ERROR);
        }

        if (!purchasePrice.matches(GameConfig.VALID_UNIT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT_ERROR);
        }
        return Integer.parseInt(purchasePrice);
    }

    public static List<Integer> readWinningNumbers() {
        String lottoNumbers = Console.readLine();
        if (!lottoNumbers.matches(GameConfig.VALID_LOTTO_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBERS_FORMAT_ERROR);
        }
        return Arrays.stream(lottoNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public static int readBonusNumber() {
        String bonusNumber = Console.readLine();
        if (!bonusNumber.matches(GameConfig.VALID_BONUS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT_ERROR);
        }
        return Integer.parseInt(bonusNumber);
    }

}
