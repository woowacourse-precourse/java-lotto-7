package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.MatchResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        LottoGame lottoGame = handleTotalCostInput();
        printPurchasedTickets(lottoGame);
        handleWinningNumbersInput(lottoGame);
        handleBonusNumberInput(lottoGame);
        printAllMatches(lottoGame);
        handleProfitRate(lottoGame);
    }

    private LottoGame handleTotalCostInput() {
        outputView.printInputTotalCost();
        try {
            int ticketCount = inputView.inputToParsed();
            outputView.printSpace();
            LottoGame lottoGame = new LottoGame(ticketCount);
            outputView.printSpace();
            return lottoGame;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return handleTotalCostInput();
        }
    }

    private void printPurchasedTickets(LottoGame lottoGame) {
        outputView.printTicketCount(lottoGame.getLottoCount());
        outputView.printBoughtTicketNumbers(lottoGame);
        outputView.printSpace();
    }

    private void handleWinningNumbersInput(LottoGame lottoGame) {
        outputView.printInputWinningNumbers();
        try {
            Lotto winningLotto = inputView.setWinningNumber();
            outputView.printSpace();
            lottoGame.setWinningLotto(winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            handleWinningNumbersInput(lottoGame);
        }
    }

    private void handleBonusNumberInput(LottoGame lottoGame) {
        outputView.printInputBonusNumber();
        try {
            int bonusNumber = inputView.inputToParsed();
            lottoGame.setBonusNumber(bonusNumber);
            outputView.printWinningStatAnnouncement();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            handleBonusNumberInput(lottoGame);
        }
    }

    private void printAllMatches(LottoGame lottoGame) {
        Map<MatchResult, Integer> matchResults = lottoGame.getMatchResults();
        outputView.printMatchThree(matchResults.get(MatchResult.THREE_MATCH));
        outputView.printMatchFour(matchResults.get(MatchResult.FOUR_MATCH));
        outputView.printMatchFive(matchResults.get(MatchResult.FIVE_MATCH_AND_BONUS));
        outputView.printMatchFiveAndBonus(matchResults.get(MatchResult.FIVE_MATCH_AND_BONUS));
        outputView.printMatchSix(matchResults.get(MatchResult.SIX_MATCH));
    }

    private void handleProfitRate(LottoGame lottoGame) {
        double profitRate = lottoGame.calculateProfitRate();
        outputView.printRateOfReturn(profitRate);
    }
}
