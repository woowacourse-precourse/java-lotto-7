package lotto.model;

import lotto.util.InputValidator;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class LottoBonusNumber {

    private Integer bonusNumber;
    private Lotto lotto;
    private final InputValidator inputValidator;


    public LottoBonusNumber(String bonusNumber, Lotto lotto, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.lotto = lotto;
        this.bonusNumber = getValidBonusNumber(bonusNumber);

    }

    public Integer getLottoBonusNumber() {
        return bonusNumber;
    }

    public Integer getValidBonusNumber(String bonusNumbers) {
        String trimmedLottoNumbers = bonusNumbers.trim();
        inputValidator.checkIfEmpty(trimmedLottoNumbers);

        inputValidator.validateOnlyDigit(bonusNumbers);

        Integer parsedBonusNumber = parseInt(bonusNumbers);

        inputValidator.checkValidRange(parsedBonusNumber);
        inputValidator.checkDuplicate(parsedBonusNumber, lotto);

        return parsedBonusNumber;
    }


    private int parseInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new InputErrorException(ErrorType.NEED_INTEGER);
        }
    }
}
