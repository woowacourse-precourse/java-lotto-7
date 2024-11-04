package lotto.controller;

import static lotto.model.LotteryDrawer.validateBonusNumber;
import static lotto.model.LotteryDrawer.validateWinningNumbers;
import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.view.InputView.validateEmptyString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LotteryDrawer;
import lotto.model.LotteryRank;
import lotto.model.Lotto;
import lotto.model.TicketIssuer;
import lotto.model.WinnerDrawer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryMachine {

    private static final int PERCENTAGE = 100;

    private final TicketIssuer lotteryIssuer;
    private final InputView inputView;
    private final OutputView outputView;
    private WinnerDrawer lotteryDrawer;

    public LotteryMachine(TicketIssuer lotteryIssuer, InputView inputView, OutputView outputView) {
        this.lotteryIssuer = lotteryIssuer;
        this.inputView = inputView;
        this.outputView = outputView;
        this.lotteryDrawer = null;
    }

    public void run() {
        List<Lotto> issuedLotto = purchaseLottery();
        outputView.printLotteryCount(lotteryIssuer.getTicketCount());
        outputView.printLotteryNumbers(issuedLotto);

        Set<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        lotteryDrawer = new LotteryDrawer(issuedLotto, winningNumbers, bonusNumber);
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = (Map<LotteryRank, Integer>) lotteryDrawer.getDrawResult();
        outputView.printDrawResult(drawResult);

        double returnRate = calculateRateReturn(drawResult, lotteryIssuer.getTicketCount() * LOTTO_PRICE);
        outputView.printReturnRate(returnRate);
    }

    private List<Lotto> purchaseLottery() {
        List<Lotto> issuedLotto = new ArrayList<>();
        boolean validInput = false;
        while (!validInput) {
            try {
                int purchaseAmount = parsePurchaseAmount(inputView.getPurchaseAmountFromUser());
                issuedLotto = lotteryIssuer.issue(purchaseAmount).stream()
                        .map(ticket -> (Lotto) ticket).toList();
                validInput = true;
            } catch (IllegalArgumentException e) {
                outputView.printInvalidInputErrorMessage(e.getMessage());
            }
        }
        return issuedLotto;
    }

    private int parsePurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount = 0;
        try {
            validateEmptyString(purchaseAmountInput);
            purchaseAmount = Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형태입니다.");
        }
        return purchaseAmount;
    }

    private Set<Integer> setWinningNumbers() {
        boolean validInput = false;
        Set<Integer> winningNumbers = new HashSet<>();
        while (!validInput) {
            try {
                winningNumbers = parseWinningNumberInput(inputView.getWinningNumberFromUser());
                validateWinningNumbers(winningNumbers);
                validInput = true;
            } catch (IllegalArgumentException e) {
                outputView.printInvalidInputErrorMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private Set<Integer> parseWinningNumberInput(String winningNumberInput) {
        Set<Integer> winningNumbers = Arrays.stream(winningNumberInput.split(","))
                .map(String::trim) // 각 요소의 공백 제거
                .map(Integer::parseInt) // 문자열을 Integer로 변환
                .collect(Collectors.toSet()); // Set으로 수집
        return winningNumbers;
    }

    private int setBonusNumber() {
        boolean validInput = false;
        int bonusNumber = 0;
        while (!validInput) {
            try {
                bonusNumber = Integer.parseInt(inputView.getBonusNumberFromUser());
                validateBonusNumber(bonusNumber);
                validInput = true;
            } catch (IllegalArgumentException e) {
                outputView.printInvalidInputErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private double calculateRateReturn(Map<LotteryRank, Integer> drawResult, int purchaseAmount) {
        int totalPrizeMoney = 0;
        for (Map.Entry<LotteryRank, Integer> entry : drawResult.entrySet()) {
            LotteryRank rank = entry.getKey();
            Integer winningCount = entry.getValue();
            totalPrizeMoney += rank.getMoney() * winningCount;
        }
        return (double) totalPrizeMoney / purchaseAmount * PERCENTAGE;
    }

}
