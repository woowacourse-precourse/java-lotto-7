package lotto.service;

import lotto.constant.LottoConfiguration;
import lotto.utility.CommonInputProcessor;
import lotto.utility.CommonInputValidator;

public class InputValidationService {

    public void validatePurchasePrice(String rawPurchasePrice) {
        rawPurchasePrice = CommonInputProcessor.removeSpace(rawPurchasePrice);
        CommonInputValidator.isBlank(rawPurchasePrice);
        CommonInputValidator.isNonNumeric(rawPurchasePrice);
        CommonInputValidator.isOutOfParseRange(rawPurchasePrice);
    }

    public void validateWinningNumber(String rawWinningNumber) {
        rawWinningNumber = CommonInputProcessor.removeSpace(rawWinningNumber);
        CommonInputValidator.isBlank(rawWinningNumber);
        CommonInputValidator.hasBlankElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        CommonInputValidator.existNonNumericElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
        CommonInputValidator.existOutOfParseRangeElement(rawWinningNumber, LottoConfiguration.WINNING_NUMBER_DELIMITER);
    }

    public void validateBonusNumber(String rawBonusNumber) {
        rawBonusNumber = CommonInputProcessor.removeSpace(rawBonusNumber);
        CommonInputValidator.isBlank(rawBonusNumber);
        CommonInputValidator.isNonNumeric(rawBonusNumber);
        CommonInputValidator.isOutOfParseRange(rawBonusNumber);
    }
}
