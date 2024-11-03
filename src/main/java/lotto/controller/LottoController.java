package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;
import lotto.model.InputParser;
import lotto.model.LottoGenerator;
import lotto.model.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void executeLottoWorkflow() {
        InputParser inputParser = new InputParser();
        int purchaseAmount = getPurchaseAmount(inputParser);

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        List<Lotto> generatedlottoList = lottoGenerator.getLottoList();

        outputView.displayLottoList(purchaseAmount, generatedlottoList);

        Lotto winningNumbers = getWinningNumbers(inputParser);
        System.out.println();
        int bonusNumber = getBonusNumber(winningNumbers, inputParser);

        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateRankResults(generatedlottoList, winningNumbers, bonusNumber);

        Map<RankType, RankResult> statistics = winningStatistics.getStatistics();
        String earningRate = winningStatistics.calculateEarningRate(purchaseAmount);

        outputView.displayWinningStatistics(statistics, earningRate);

        inputView.close();
        outputView.close();
    }

    public int getPurchaseAmount(InputParser inputParser) {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                return inputParser.parsePurchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumbers(InputParser inputParser) {
        while (true) {
            try {
                String winningNumbers = inputView.readWinningNumbers();
                return inputParser.parseWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(Lotto winningNumbers, InputParser inputParser) {
        while (true) {
            try {
                String bonusNumber = inputView.readBonusNumber();
                return inputParser.parseBonusNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
