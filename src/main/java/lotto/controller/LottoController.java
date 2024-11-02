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
    LottoMachine lottoMachine = new LottoMachine();

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
                BigDecimal purchasePrice;

                purchasePrice = InputView.inputPurchasePrice();
                tickets = lottoMachine.createLottoTicket(purchasePrice);
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
                int bonus_number;

                bonus_number = InputView.inputBonusNumber(winningNumberData);
                return bonus_number;
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
            int oneRank = winningNumber.getWinningRank(oneLotto);
            for (Rank rank : Rank.values()) {
                if (rank.getRank() == oneRank) {
                    winningResult.add(rank);
                }
            }
        }
        return winningResult;
    }
}