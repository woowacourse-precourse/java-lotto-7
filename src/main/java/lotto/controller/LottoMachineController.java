package lotto.controller;

import static lotto.view.InputView.getBonusNumber;
import static lotto.view.InputView.getPurchaseAmount;
import static lotto.view.InputView.getWinningNumbers;

import java.util.List;
import java.util.Map;
import lotto.factory.LottoTicketFactory;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.StatisticsCalculator;
import lotto.view.OutputView;

public class LottoMachineController {

    public void run() {
        int purchaseAmount = getValidatedPurchaseAmount();

        List<Lotto> lottoTickets = purchaseLottoTickets(purchaseAmount);
        OutputView.printPurchasedLottoTickets(lottoTickets);

        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningNumbers);

        Map<Rank, Integer> winningStatistics = calculateWinningStatistics(lottoTickets, winningNumbers, bonusNumber);
        OutputView.printWinningStatistics(winningStatistics);

        double profitRate = calculateTotalWinningProfitRate(winningStatistics, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private int getValidatedPurchaseAmount() {
        try {
            return getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedPurchaseAmount();
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedWinningNumbers();
        }
    }

    private int getValidatedBonusNumber(List<Integer> winningNumbers) {
        try {
            return getBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedBonusNumber(winningNumbers);
        }
    }

    private List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        try {
            return LottoTicketFactory.generateLottoTickets(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottoTickets(purchaseAmount);
        }
    }

    private Map<Rank, Integer> calculateWinningStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        return StatisticsCalculator.calculateWinningStatistics(lottoTickets, winningNumbers, bonusNumber);
    }

    private double calculateTotalWinningProfitRate(Map<Rank, Integer> winningStatistics, int purchaseAmount) {
        return StatisticsCalculator.calculateTotalWinningProfitRate(winningStatistics, purchaseAmount);
    }

}
