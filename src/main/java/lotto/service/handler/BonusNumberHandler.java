package lotto.service.handler;


import lotto.dto.WinningNumbersRequestDto;
import lotto.service.validator.BonusNumberValidator;

public class BonusNumberHandler {
    public static boolean handle(String bonusNumber, WinningNumbersRequestDto winningNumbersRequestDto) {
        return BonusNumberValidator.validateBlank(bonusNumber) && BonusNumberValidator.validateDataType(bonusNumber) && BonusNumberValidator.validateRange(bonusNumber) && BonusNumberValidator.validateDuplicate(bonusNumber, winningNumbersRequestDto);
    }
}
