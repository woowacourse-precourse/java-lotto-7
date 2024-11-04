package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumber;
import lotto.model.WinningResult;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        List<Lotto> tickets = buyLotto();
        OutputView.printTickets(tickets);
        List<Integer> winningNumberData = getWinningNumber();
        int bonusNum = getBonusNumber(winningNumberData);
        WinningNumber winningNumber = new WinningNumber(winningNumberData, bonusNum);
        WinningResult winningResult = getWinningResult(tickets, winningNumber);
        OutputView.printWinningResults(winningResult);
        double profitRate = winningResult.calculateProfitRate(lottoMachine.getPurchaseAmount());
        OutputView.printProfitRate(profitRate);
    }

    private List<Lotto> buyLotto() {
        while (true) {
            try {
                List<Lotto> tickets;
                BigDecimal PurchaseAmount;

                PurchaseAmount = InputView.inputPurchaseAmount();
                tickets = lottoMachine.createLottoTicket(PurchaseAmount);
                return tickets;
            } catch (NumberFormatException e) {
                OutputView.errorPrint(e.getMessage());
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumberData;

                winningNumberData = InputView.inputWinningNumber();
                return winningNumberData;
            } catch (NumberFormatException e) {
                OutputView.errorPrint(e.getMessage());
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }

    // Bonus_number객체 만들기
    private int getBonusNumber(List<Integer> winningNumberData) {
        while (true) {
            try {
                int bonusNumber;

                bonusNumber = InputView.inputBonusNumber(winningNumberData);
                return bonusNumber;
            } catch (NumberFormatException e) {
                OutputView.errorPrint(e.getMessage());
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }

    private WinningResult getWinningResult(List<Lotto> tickets, WinningNumber winningNumber) {
        WinningResult winningResult = new WinningResult();

        for (Lotto oneLotto : tickets) {
            addWinningRankToResult(oneLotto, winningResult, winningNumber);
        }
        return winningResult;
    }

    private void addWinningRankToResult(Lotto oneLotto, WinningResult winningResult, WinningNumber winningNumber) {
        int currentLottoRank = winningNumber.getWinningRank(oneLotto);

        for (Rank rank : Rank.values()) {
            if (rank.getRank() == currentLottoRank) {
                winningResult.add(rank);
            }
        }
    }
}