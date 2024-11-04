package lotto.domain.service;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.util.Statistics;
import lotto.domain.util.parser.StringParser;

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
        assert instance == null : "Already initialized";
        instance = new LottoService(delimitedNumberParser, bonusNumberParser, moneyParser);
    }

    public Lotteries purchaseLotteries(String input) {
        return Lotteries.of(moneyParser.parse(input));
    }

    public Lotto setWinningNumber(String input) {
        return new Lotto(delimitedNumberParser.parse(input));
    }

    public Integer setBonusNumber(String input) {
        return bonusNumberParser.parse(input);
    }

    public Statistics calculateProfit(Lotteries lotteries, Lotto winningLotto, Integer bonusNumber) {
        return Statistics.of(lotteries, winningLotto, bonusNumber);
    }
}
