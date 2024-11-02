package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.List;

import static lotto.validator.InputValidator.*;

public class BonusNumberValidator {
    List<String> winningNumbers;

    public BonusNumberValidator(WinningNumbersValidator winningNumbersValidator) {
        this.winningNumbers = winningNumbersValidator.getWinningNumbers();
    }

    public int convertTypeSetBounus() {
        return Integer.parseInt(winningNumbers.getLast());
    }

    private void processSetBonusNumber() {
        InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT),
                request -> {
                    if (inputBonusValidation(request)) {
                        winningNumbers.add(request);
                        return hasNoDuplicates(Input.BONUS_NUMBER_PROMPT, winningNumbers);
                    }
                    return false;
                });
    }

    private Boolean inputBonusValidation(String request) {
        final String viewMessage = Input.BONUS_NUMBER_PROMPT;

        return nonEmpty(viewMessage, request) &&
               isNumeric(viewMessage, request) &&
               isPositiveNumeric(viewMessage, request) &&
               isLottoNumberRange(request);
    }

    private Boolean isLottoNumberRange(String number) {
        if (Integer.parseInt(number) < LottoConstants.MIN_BALL || Integer.parseInt(number) > LottoConstants.MAX_BALL) {

            throw new RetryInputException(Input.BONUS_NUMBER_PROMPT,
                    ErrorMessages.IS_OUT_OF_LOTTO_NUMBER.getMessage());
        }

        return true;
    }
}
