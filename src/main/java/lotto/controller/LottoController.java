package lotto.controller;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PublishLotteries;
import lotto.model.Purchase;
import lotto.model.WinningHistory;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class LottoController {
    private Purchase purchase;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private PublishLotteries publishLotteries;
    private WinningHistory winningHistory;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        buy();
        assign();
        showResult();
    }

    private void buy() {
        inputPurchaseAmount();
        publishLotto();
        printPublishedLotto();
    }

    private void assign() {
        assignWinningNumbers();
        assignBonusNumber();
    }

    private void showResult() {
        printWinningStatistics();
    }

    private void inputPurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                purchase = new Purchase(amount);
                break;
            } catch (InvalidPurchaseAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void publishLotto() {
        publishLotteries = new PublishLotteries(purchase.getPurchaseCount());
    }

    private void printPublishedLotto() {
        outputView.printPublishedLotteries(publishLotteries.get());
    }

    private void assignWinningNumbers() {
        while (true) {
            try {
                List<Integer> input = inputView.getWinningNumbers();
                winningNumbers = new WinningNumbers(input);
                break;
            } catch (InvalidWinningNumbersException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void assignBonusNumber() {
        while (true) {
            try {
                int number = inputView.getBonusNumber();
                bonusNumber = new BonusNumber(number);
                break;
            } catch (InvalidBonusNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Rank, Integer> getCalculateWinnings() {
        List<Integer> winningNumbersToCompare = winningNumbers.get();
        List<Lotto> publishedLotteries = publishLotteries.get();
        int bonus = bonusNumber.get();
        Map<Rank, Integer> winningCountOfEachRanks;

        winningHistory = new WinningHistory(winningNumbersToCompare, publishedLotteries, bonus);
        winningCountOfEachRanks = winningHistory.getWinningCountOfEachRank();

        return winningCountOfEachRanks;
    }

    private double getCalculateTotalRateOfReturn() {
        int totalPrize = winningHistory.getTotalPrize();
        int purchasePrice = purchase.getPurchasePrice();
        double rateOfReturn = (double) totalPrize / purchasePrice * 100;

        return Math.round(rateOfReturn * 10) / 10.0;
    }

    private void printCalculatedWinnings() {
        Map<Rank, Integer> winningCountOfEachRanks = getCalculateWinnings();
        outputView.printWinnings(winningCountOfEachRanks);
    }

    private void printCalculatedRateOfReturn() {
        double rateOfReturn = getCalculateTotalRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void printWinningStatistics() {
        printCalculatedWinnings();
        printCalculatedRateOfReturn();
    }
}
