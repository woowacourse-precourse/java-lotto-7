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
        long purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = lottoMarket.sellLottos(purchaseAmount);

        displayLottos(purchaseAmount, lottos);
        displayLottoResults(lottos, purchaseAmount);
    }

    private void displayLottoResults(List<Lotto> lottos, long purchaseAmount) {
        Lotto winnerLotto = getWinnerLotto();
        int bonusNum = getBonusNumberAfterCompareToWinnerLotto(winnerLotto);
        LottoResult lottoResults = calculateLottoResult(lottos, winnerLotto, bonusNum, purchaseAmount);

        outputView.printLottoResults(lottoResults);
    }

    private void displayLottos(long purchaseAmount, List<Lotto> lottos) {
        outputView.printBuyingLottoCount(purchaseAmount);
        outputView.printLottos(lottos);
    }

    private LottoResult calculateLottoResult(List<Lotto> lottos, Lotto winnerLotto, int bonusNum, long amount) {
        Map<Lotto, LottoRank> lottoRankResults = lottoRankDeterminer.determineLottoRanks(lottos, winnerLotto, bonusNum);
        return lottoStatisticsCalculator.calculateStatistic(lottoRankResults, amount);
    }

    private long getPurchaseAmount() {
        String purchaseAmount;
        while (true) {
            try {
                purchaseAmount = inputView.getInputAmount();
                inputValidator.validateInputAmount(purchaseAmount);
                return parser.parseStringToLong(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinnerLotto() {
        while (true) {
            try {
                String inputWinnerNumbers = inputView.getInputWinnerNumbers();
                inputValidator.validateInputNumbers(inputWinnerNumbers);
                List<Integer> winnerNumbers = parser.parseInputToNumbers(inputWinnerNumbers);
                return new Lotto(winnerNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumberAfterCompareToWinnerLotto(Lotto winnerLotto) {
        while (true) {
            try {
                String bonusNumber = inputView.getInputBonusNumber();
                inputValidator.validateInputBonusNumber(winnerLotto.getNumbers(), bonusNumber);
                return parser.parseStringToInt(bonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

