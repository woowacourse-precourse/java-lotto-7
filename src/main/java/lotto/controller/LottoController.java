package lotto.controller;

import static lotto.model.LottoPrizeCalculator.*;
import static lotto.validation.PurchaseAmountValidator.*;
import static lotto.validation.WinningNumberValidator.parseValidatedBonusNumber;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import java.util.Map;
import lotto.model.LottoTickets;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.validation.WinningNumberValidator;


public class LottoController {

    public void run() {
        int ticketCount = calculateTicketCount();
        printPurchaseLottoCount(ticketCount);

        LottoTickets lottoTickets = new LottoTickets(ticketCount);
        WinningLotto winningLotto = generateWinningLotto();

        Map<Prize, Integer> lottoResult = calculate(lottoTickets, winningLotto);
        double profitRatio = calculateProfitRatio(ticketCount, getTotalAmount());

        printResultStatistics(lottoResult, profitRatio);
    }

    private int calculateTicketCount() {
        String purchaseAmount = requestPurchaseAmount();
        return parseValidatedTicketCount(purchaseAmount);
    }

    private String requestPurchaseAmount() {
        printPurchaseAmountInputMessage();
        try {
            return userInput();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningNumber = requestWinningNumber();
        int bonusNumber = requestBonusNumber(winningNumber);
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> requestWinningNumber() {
        printWinningNumberInputMessage();
        try {
            String winningNumber = userInput();
            return WinningNumberValidator.parseValidatedWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return requestWinningNumber();
        }
    }

    private int requestBonusNumber(List<Integer> winningNumber) {
        printBonusNumberInputMessage();
        try {
            String bonusNumber = userInput();
            return parseValidatedBonusNumber(bonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return requestBonusNumber(winningNumber);
        }
    }

    private void printResultStatistics(Map<Prize, Integer> lottoResult, double profitRatio) {
        printWinningStatisticsMessage();
        printResult(lottoResult);
        printProfitRatio(profitRatio);
    }

}
