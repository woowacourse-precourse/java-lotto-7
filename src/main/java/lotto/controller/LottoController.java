package lotto.controller;

import static lotto.model.LottoPrizeCalculator.*;
import static lotto.validation.PurchaseAmountValidator.*;
import static lotto.validation.WinningNumberValidator.parseValidatedBonusNumber;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import java.util.Map;
import lotto.model.LottoPrizeCalculator;
import lotto.model.LottoTickets;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.validation.WinningNumberValidator;

public class LottoController {

    public void run() {
        LottoPrizeCalculator calculator = LottoPrizeCalculator.getInstance();
        int ticketCount = calculateTicketCount();
        printPurchaseLottoCount(ticketCount);

        LottoTickets lottoTickets = new LottoTickets(ticketCount);
        WinningLotto winningLotto = generateWinningLotto();

        Map<Prize, Integer> lottoResult = calculator.calculate(lottoTickets, winningLotto);
        double profitRatio = calculator.calculateProfitRatio(ticketCount);

        printResultStatistics(lottoResult, profitRatio);
    }

    private int calculateTicketCount() {
        String purchaseAmount = requestPurchaseAmount();
        return parseTicketCountWithValidation(purchaseAmount);
    }

    private String requestPurchaseAmount() {
        printPurchaseAmountInputMessage();
        return userInput();
    }

    private int parseTicketCountWithValidation(String purchaseAmount) {
        try {
            return parseValidatedTicketCount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return calculateTicketCount();
        }
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumberWithValidation(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> requestWinningNumbers() {
        printWinningNumberInputMessage();
        return parseWinningNumbersWithValidation(userInput());
    }

    private List<Integer> parseWinningNumbersWithValidation(String winningNumberInput) {
        try {
            return WinningNumberValidator.parseValidatedWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private int requestBonusNumberWithValidation(List<Integer> winningNumbers) {
        printBonusNumberInputMessage();
        return parseBonusNumberWithValidation(userInput(), winningNumbers);
    }

    private int parseBonusNumberWithValidation(String bonusNumberInput, List<Integer> winningNumbers) {
        try {
            return parseValidatedBonusNumber(bonusNumberInput, winningNumbers);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return requestBonusNumberWithValidation(winningNumbers);
        }
    }

    private void printResultStatistics(Map<Prize, Integer> lottoResult, double profitRatio) {
        printWinningStatisticsMessage();
        printResult(lottoResult);
        printProfitRatio(profitRatio);
    }
}
