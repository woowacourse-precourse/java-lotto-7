package lotto.domain.service;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.exception.BonusNumberFormatException;
import lotto.domain.exception.DelimitedNumberFormatException;
import lotto.domain.exception.MoneyFormatException;
import lotto.domain.util.Statistics;
import lotto.domain.util.parser.StringParser;
import lotto.global.exception.ExceptionHandler;

public class LottoService {

    private final StringParser<List<Integer>> delimitedNumberParser;
    private final StringParser<Integer> bonusNumberParser;
    private final StringParser<Integer> moneyParser;

    private static LottoService instance;

    private LottoService(StringParser<List<Integer>> delimitedNumberParser,
                         StringParser<Integer> bonusNumberParser,
                         StringParser<Integer> moneyParser) {
        this.delimitedNumberParser = delimitedNumberParser;
        this.bonusNumberParser = bonusNumberParser;
        this.moneyParser = moneyParser;
    }

    public static LottoService getInstance() {
        assert instance != null : "LottoService has not been initialized";
        return instance;
    }

    public static void init(StringParser<List<Integer>> delimitedNumberParser,
                            StringParser<Integer> bonusNumberParser,
                            StringParser<Integer> moneyParser) {
        if (instance != null) return;
        instance = new LottoService(delimitedNumberParser, bonusNumberParser, moneyParser);
    }

    public Lotteries purchaseLotteries(String input) {
        try {
            return Lotteries.of(moneyParser.parse(input));
        } catch (MoneyFormatException e) {
            throw new IllegalArgumentException(ExceptionHandler.createErrorMessage(e.getMessage()), e);
        }
    }

    public Lotto setWinningNumber(String input) {
        try {
            return new Lotto(delimitedNumberParser.parse(input));
        } catch (DelimitedNumberFormatException e) {
            throw new IllegalArgumentException(ExceptionHandler.createErrorMessage(e.getMessage()), e);
        }
    }

    public Integer setBonusNumber(List<Integer> numbers, String input) {
        try {
            Integer parsed = bonusNumberParser.parse(input);
            if (numbers.contains(parsed)) {
                throw BonusNumberFormatException.duplicateNumber();
            }
            return parsed;
        } catch (BonusNumberFormatException e) {
            throw new IllegalArgumentException(ExceptionHandler.createErrorMessage(e.getMessage()), e);
        }
    }

    public Statistics calculateProfit(Lotteries lotteries, Lotto winningLotto, Integer bonusNumber) {
        return Statistics.of(lotteries, winningLotto, bonusNumber);
    }
}
