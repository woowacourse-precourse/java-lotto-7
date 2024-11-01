package lotto.service.numbers;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.validator.BonusNumberValidator;

public class LottoNumberService {

    public Lotto generateWinningLotto(String winningNumbers) {
        List<Integer> convertedWinningNumbers = Parser.parsingNumbers(winningNumbers);
        return new Lotto(convertedWinningNumbers);
    }

    public BonusNumber generateBonusNumber(String bonusNumber, Lotto winningLotto) {
        int convertedBonusNumber = Parser.parsingBonusNumber(bonusNumber);
        BonusNumberValidator.validateProcess(convertedBonusNumber, winningLotto);
        return new BonusNumber(convertedBonusNumber);
    }
}