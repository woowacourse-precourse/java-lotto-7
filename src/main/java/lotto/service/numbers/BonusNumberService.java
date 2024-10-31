package lotto.service.numbers;


import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.validator.BonusNumberValidator;

public class BonusNumberService {
    public BonusNumber generateBonusNumber(String bonusNumber, Lotto winningLotto) {
        int convertedBonusNumber = Parser.parsingBonusNumber(bonusNumber);
        BonusNumberValidator.validateProcess(convertedBonusNumber, winningLotto);
        return new BonusNumber(convertedBonusNumber);
    }
}
