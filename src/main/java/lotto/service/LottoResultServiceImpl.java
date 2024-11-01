package lotto.service;

import java.util.List;
import lotto.domain.WinningLotto;
import lotto.utils.parser.Parser;
import lotto.utils.validator.Validator;

public class LottoResultServiceImpl implements LottoResultService {
    private final Validator<String> winningNumbersValidator;
    private final Validator<String> bonusNumberValidator;
    private final Parser<List<Integer>> stringToIntListParser;
    private final Parser<Integer> stringToIntParser;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private WinningLotto winningLotto;

    public LottoResultServiceImpl(Validator<String> winningNumbersValidator
            , Validator<String> bonusNumberValidator
            , Parser<List<Integer>>  stringToIntListParser
            , Parser<Integer> stringToIntParser) {
        this.winningNumbersValidator = winningNumbersValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.stringToIntListParser = stringToIntListParser;
        this.stringToIntParser = stringToIntParser;

    }


    @Override
    public void receiveWinningLottoNumbers(String rawWinningNumbers) {
        winningNumbersValidator.validate(rawWinningNumbers);
        winningNumbers= stringToIntListParser.parse(rawWinningNumbers);
    }

    @Override
    public void receiveBonusNumber(String rawBonusNumber) {
        bonusNumberValidator.validate(rawBonusNumber);
        bonusNumber = stringToIntParser.parse(rawBonusNumber);

    }

    private void buildWinningLotto(){
        winningLotto =   WinningLotto.create(winningNumbers,bonusNumber);
    }
}
