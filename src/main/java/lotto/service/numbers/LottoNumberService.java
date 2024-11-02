package lotto.service.numbers;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.utils.parser.Parser;

public class LottoNumberService {

    public WinningNumber generateWinningNumberSet(String bonusNumber, Lotto winningLotto) {
        BonusNumber convertedBonusNumber = generateBonusNumber(bonusNumber);
        return new WinningNumber(winningLotto, convertedBonusNumber);
    }

    public Lotto generateWinningLotto(String winningNumbers) {
        List<Integer> convertedWinningNumbers = Parser.parsingNumbers(winningNumbers);
        return new Lotto(convertedWinningNumbers);
    }

    private BonusNumber generateBonusNumber(String bonusNumber) {
        int convertedBonusNumber = Parser.parsingBonusNumber(bonusNumber);
        return new BonusNumber(convertedBonusNumber);
    }
}