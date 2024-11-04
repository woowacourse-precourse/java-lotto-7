package lotto.config;

import lotto.domain.LottoFactory;
import lotto.domain.LottoMarket;
import lotto.parser.Parser;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoRankDeterminer;
import lotto.service.LottoStatisticsCalculator;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Config {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();
    private final Parser parser = new Parser();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
    private final LottoMarket lottoMarket = new LottoMarket(lottoFactory);
    private final LottoRankDeterminer lottoRankDeterminer = new LottoRankDeterminer();
    private final LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator();

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public Parser getParser() {
        return parser;
    }

    public LottoMarket getLottoMarket() {
        return lottoMarket;
    }

    public LottoRankDeterminer getLottoRankDeterminer() {
        return lottoRankDeterminer;
    }

    public LottoStatisticsCalculator getLottoStatisticsCalculator() {
        return lottoStatisticsCalculator;
    }
}
