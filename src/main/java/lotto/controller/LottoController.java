package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseCalculator;
import lotto.domain.MatchStatistics;
import lotto.domain.WinningNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.util.RandomNumberGenerator;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoPurchaseCalculator lottoManager;
    private final MatchStatistics matchStatistics = new MatchStatistics();

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler,
                           RandomNumberGenerator randomNumberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoManager = new LottoPurchaseCalculator(randomNumberGenerator);
    }

    public void startLotto() {
        while (true) {
            try {
                outputHandler.showLottoPrice();
                String price = inputHandler.price();
                int lottoCount = lottoManager.getLottoCount(price);

                matchStatistics.setTotalSpent(Double.parseDouble(price));
                outputHandler.showLottoCount(lottoCount);

                List<Lotto> lottoNumbers = lottoManager.generateLottoNumbers(lottoCount);
                for (Lotto lotto : lottoNumbers) {
                    outputHandler.showLottoList(lotto.getNumbers());
                }

                outputHandler.showWinningNumbersMessage();
                String winningInput = inputHandler.winningNumbers();
                List<Integer> winNumbers = Arrays.stream(winningInput.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                outputHandler.showBonusNumberMessage();
                int bonusNumber = Integer.parseInt(inputHandler.bonusNumber());

                WinningNumber winningNumber = new WinningNumber(winNumbers, bonusNumber);
                matchStatistics.calculateMatches(lottoNumbers, winningNumber);

                outputHandler.showMatchResult(matchStatistics.getMatchResults(), matchStatistics.getProfitRate());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
