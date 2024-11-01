package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseCalculator;
import lotto.domain.WinningNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.util.RandomNumberGenerator;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoPurchaseCalculator lottoManager;

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
                outputHandler.showLottoCount(lottoCount);

                List<Lotto> lottoTickets = lottoManager.generateLottoNumbers(lottoCount);
                for (Lotto lotto : lottoTickets) {
                    outputHandler.showLottoList(lotto.getNumbers());
                }

                outputHandler.showWinningNumbersMessage();
                List<Integer> winNumbers = inputHandler.winningNumbersInput();
                int bonusNumber = inputHandler.bonusNumberInput();
                WinningNumber winningNumber = new WinningNumber(winNumbers, bonusNumber);


                for (Lotto lotto : lottoTickets) {
                    int matchCount = winningNumber.matchCount(lotto);
                    boolean bonusMatch = winningNumber.isBonusMatched(lotto);
                    outputHandler.showMatchResult(matchCount, bonusMatch);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
