package lotto.controller;

import lotto.config.Config;
import lotto.domain.Lotto;
import lotto.domain.LottoMarket;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.parser.Parser;
import lotto.service.LottoRankDeterminer;
import lotto.service.LottoStatisticsCalculator;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final Parser parser;
    private final LottoMarket lottoMarket;
    private final LottoRankDeterminer lottoRankDeterminer;
    private final LottoStatisticsCalculator lottoStatisticsCalculator;

    public LottoController(Config config) {
        this.inputView = config.getInputView();
        this.outputView = config.getOutputView();
        this.inputValidator = config.getInputValidator();
        this.parser = config.getParser();
        this.lottoMarket = config.getLottoMarket();
        this.lottoRankDeterminer = config.getLottoRankDeterminer();
        this.lottoStatisticsCalculator = config.getLottoStatisticsCalculator();
    }

    public void run() {
        String buyingAmount;
        long amount;
        List<Lotto> lottos;
        while (true) {
            try {
                buyingAmount = inputView.getInputAmount();
                inputValidator.validateInputAmount(buyingAmount);
                amount = parser.parseStringToLong(buyingAmount);
                lottos = lottoMarket.sellLottos(amount);
                outputView.printBuyingLottoCount(amount);
                outputView.printLottos(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String inputWinnerNumbers;
        List<Integer> winnerNumbers;
        while (true) {
            try {
                inputWinnerNumbers = inputView.getInputWinnerNumbers();
                inputValidator.validateInputNumbers(inputWinnerNumbers);
                winnerNumbers = parser.parseInputToNumbers(inputWinnerNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Lotto winnerLotto = new Lotto(winnerNumbers);

        String bonusNumber;
        int bonusNum;
        while (true) {
            try {
                bonusNumber = inputView.getInputBonusNumber();
                inputValidator.validateInputBonusNumber(winnerNumbers, bonusNumber);
                bonusNum = parser.parseStringToInt(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        Map<Lotto, LottoRank> lottoRankResults = lottoRankDeterminer.determineLottoRanks(lottos, winnerLotto, bonusNum);
        LottoResult lottoResult = lottoStatisticsCalculator.calculateStatistic(lottoRankResults, amount);

        outputView.printLottoResults(lottoResult);
    }
}

