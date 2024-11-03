package lotto.service;

import lotto.constant.LottoConfiguration;
import lotto.utility.CommonInputValidator;

public class InputValidationService {

    public void validatePurchasePrice(String rawPurchasePrice) {
        CommonInputValidator.isBlank(rawPurchasePrice);
        CommonInputValidator.isNonNumeric(rawPurchasePrice);
        CommonInputValidator.isOutOfParseRange(rawPurchasePrice);
    }

    public void validateWinningNumber(String rawWinningNumber) {
        CommonInputValidator.isBlank(rawWinningNumber);
        CommonInputValidator.hasBlankElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        CommonInputValidator.existNonNumericElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        CommonInputValidator.existOutOfParseRangeElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
    }

    public void validateBonusNumber(String rawBonusNumber) {
        CommonInputValidator.isBlank(rawBonusNumber);
        CommonInputValidator.isNonNumeric(rawBonusNumber);
        CommonInputValidator.isOutOfParseRange(rawBonusNumber);
    }
}
