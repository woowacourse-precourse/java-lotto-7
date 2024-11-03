package lotto.controller;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PublishLotteries;
import lotto.model.Purchase;
import lotto.model.TotalRateOfReturn;
import lotto.model.WinningDetails;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class LottoController {
    private Purchase purchase;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private PublishLotteries publishLotteries;
    private WinningDetails winningDetails;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        buy();
        create();
        calculateWinningDetails();
        showFinalStatistics();
    }

    private void buy() {
        inputPurchaseAmount();
        publishingLotto();
        printPublishedLotto();
    }

    private void create() {
        createWinningNumber();
        createBonusNumber();
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

    private void publishingLotto() {
        publishLotteries = new PublishLotteries(purchase.getPurchaseCount());
    }

    private void printPublishedLotto() {
        outputView.printPublishedLotteries(publishLotteries.get());
    }

    private void createWinningNumber() {
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

    private void createBonusNumber() {
        while (true) {
            try {
                int number = inputView.getBonusNumber();
                bonusNumber = new BonusNumber(number, winningNumber.get());
                break;
            } catch (InvalidBonusNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateWinningDetails() {
        List<Integer> winningNumberToCompare = winningNumber.get();
        List<Lotto> publishedLotteries = publishLotteries.get();
        int bonus = bonusNumber.get();

        winningDetails = new WinningDetails(winningNumberToCompare, publishedLotteries, bonus);
    }

    private double getTotalRateOfReturn() {
        int totalPrize = winningDetails.getTotalPrize();
        int purchasePrice = purchase.getPurchasePrice();
        TotalRateOfReturn totalRateOfReturn = new TotalRateOfReturn(totalPrize, purchasePrice);

        return totalRateOfReturn.get();
    }

    private void printWinningHistories() {
        Map<Rank, Integer> winningCountOfEachRanks = winningDetails.getWinningCountOfEachRank();
        outputView.printWinnings(winningCountOfEachRanks);
    }

    private void printTotalRateOfReturn() {
        double rateOfReturn = getTotalRateOfReturn();
        outputView.printTotalRateOfReturn(rateOfReturn);
    }

    private void showFinalStatistics() {
        printWinningHistories();
        printTotalRateOfReturn();
    }
}
