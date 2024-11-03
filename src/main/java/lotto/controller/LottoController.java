package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGameInfo;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.service.LottoCalculator;
import lotto.service.LottoGenerator;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void startGame() {
        LottoGameInfo gameInfo = getGameInfo();
        List<Lotto> lottoTickets = generateLottoTickets(gameInfo.getLottotickets());
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        LottoResult lottoResult = calculateRank(lottoTickets, winningNumbers, bonusNumber);
        printLottoResult(lottoResult, gameInfo.getPurchaseAmount());
    }

    private LottoGameInfo getGameInfo() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGameInfo gameInfo = new LottoGameInfo();
        gameInfo.setPurchaseAmount(purchaseAmount);
        gameInfo.setLottotickets(purchaseAmount);
        return gameInfo;
    }

    private List<Lotto> generateLottoTickets (int lottoTicketsCount) {
        OutputView.countLotto(lottoTicketsCount);
        List<Lotto> lottoTickets = LottoGenerator.generateLottoTickets(lottoTicketsCount);
        for (Lotto lotto : lottoTickets) {
            OutputView.lottoPrint(lotto);
        }
        return lottoTickets;
    }

    private List<Integer> getWinningNumbers  () {
        return InputView.getWinningNumbers();
    }

    private int getBonusNumber (List<Integer> winningNumbers) {
        return InputView.getBonusNumber(winningNumbers);
    }

    private LottoResult calculateRank (List<Lotto> userLotto, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : userLotto) {
            LottoRank rank = LottoCalculator.calculateRank(lotto, winningNumbers, bonusNumber);
            if (rank != LottoRank.LOSING) {
                lottoResult.incrementRankCount(rank);
            }
        }
        return lottoResult;
    }

    private void printLottoResult(LottoResult lottoResult, int purchaseAmount) {
        int totalPrizeAmount = lottoResult.getTotalPrizeAmount();
        OutputView.lottoResult(lottoResult, totalPrizeAmount, purchaseAmount);
    }
}
