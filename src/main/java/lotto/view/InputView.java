package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.io.InputValidation;

public class InputView {

    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();

        InputValidation.validateNullOrEmpty(purchaseAmount);
        InputValidation.validateContainBlank(purchaseAmount);
        InputValidation.validateNumeric(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningLottoNumbers() {
        String winningNumbers = Console.readLine();

        InputValidation.validateNullOrEmpty(winningNumbers);
        InputValidation.validateContainBlank(winningNumbers);
        InputValidation.validateDelimiter(winningNumbers);

        String[] split = winningNumbers.split(WINNING_LOTTO_NUMBERS_DELIMITER);

        List<Integer> winningLottoNumbers = new ArrayList<>();

        for (String number : split) {
            int parseNumber = Integer.parseInt(number);
            winningLottoNumbers.add(parseNumber);
        }

        return winningLottoNumbers;
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();

        InputValidation.validateNullOrEmpty(bonusNumber);
        InputValidation.validateContainBlank(bonusNumber);
        InputValidation.validateNumeric(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
