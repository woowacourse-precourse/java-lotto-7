package lotto.service;

import java.util.List;
import lotto.domain.MatchResults;
import lotto.domain.WinningLotto;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottosDto;
import lotto.utils.parser.Parser;
import lotto.utils.validator.ComparisonValidator;
import lotto.utils.validator.InputValidator;

public class LottoResultServiceImpl implements LottoResultService {
    private final InputValidator<String> winningNumbersValidator;
    private final ComparisonValidator bonusNumberValidator;
    private final Parser<List<Integer>> stringToIntListParser;
    private final Parser<Integer> stringToIntParser;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private WinningLotto winningLotto;

    public LottoResultServiceImpl(InputValidator<String> winningNumbersValidator
            , ComparisonValidator bonusNumberValidator
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
        bonusNumberValidator.validateWithComparison(rawBonusNumber,winningNumbers);
        bonusNumber = stringToIntParser.parse(rawBonusNumber);

        buildWinningLotto();
    }

    @Override
    public FinalResultsDto getFinalResultsDto(LottosDto lottosDto) {
        MatchResults matchResults = MatchResults.createMatchResults(lottosDto, winningLotto);
       return matchResults.buildFinalResultsDto();
    }

    private void buildWinningLotto(){
        winningLotto =   WinningLotto.create(winningNumbers,bonusNumber);
    }

}
