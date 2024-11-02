package lotto.controller;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PublishLotteries;
import lotto.model.Purchase;
import lotto.model.TotalRateOfReturn;
import lotto.model.WinningHistory;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

import static lotto.exception.ErrorMessage.ALREADY_EXIST_IN_WINNING_NUMBERS;

public class LottoController {
    private Purchase purchase;
    private WinningNumber winningNumber;
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
        printFinalStatistics();
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
                String input = inputView.getWinningNumber();
                winningNumber = new WinningNumber(input);
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
                checkBonusNumberDuplicate(number);
                bonusNumber = new BonusNumber(number);
                break;
            } catch (InvalidBonusNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkBonusNumberDuplicate(int number) {
        if (winningNumber.get().contains(number)) {
            throw new InvalidBonusNumberException(ALREADY_EXIST_IN_WINNING_NUMBERS.getMessage());
        }
    }

    private Map<Rank, Integer> getWinningHistories() {
        Map<Rank, Integer> winningCountOfEachRanks;
        List<Integer> winningNumbersToCompare = winningNumber.get();
        List<Lotto> publishedLotteries = publishLotteries.get();
        int bonus = bonusNumber.get();

        winningHistory = new WinningHistory(winningNumbersToCompare, publishedLotteries, bonus);
        winningCountOfEachRanks = winningHistory.getWinningCountOfEachRank();

        return winningCountOfEachRanks;
    }

    private double getTotalRateOfReturn() {
        int totalPrize = winningHistory.getTotalPrize();
        int purchasePrice = purchase.getPurchasePrice();
        TotalRateOfReturn totalRateOfReturn = new TotalRateOfReturn(totalPrize, purchasePrice);

        return totalRateOfReturn.get();
    }

    private void printWinningHistories() {
        Map<Rank, Integer> winningCountOfEachRanks = getWinningHistories();
        outputView.printWinnings(winningCountOfEachRanks);
    }

    private void printTotalRateOfReturn() {
        double rateOfReturn = getTotalRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void printFinalStatistics() {
        printWinningHistories();
        printTotalRateOfReturn();
    }
}
