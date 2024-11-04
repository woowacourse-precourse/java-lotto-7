package lotto.controller;

import static lotto.model.LotteryDrawer.validateBonusNumber;
import static lotto.model.LotteryDrawer.validateWinningNumbers;
import static lotto.model.Lotto.LOTTO_PRICE;
import static lotto.view.InputView.validateEmptyString;

import java.util.ArrayList;
import java.util.Arrays;
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
        Set<Integer> winningNumbers;
        while (true) {
            try {
                String winningNumberInput = inputView.getWinningNumberFromUser();
                validateEmptyString(winningNumberInput);
                winningNumbers = parseWinningNumberInput(winningNumberInput);
                validateWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printInvalidInputErrorMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private Set<Integer> parseWinningNumberInput(String winningNumberInput) {
        Set<Integer> winningNumbers;
        List<String> winningNumberTokens = Arrays.stream(winningNumberInput.split(",")).map(String::trim).toList();
        try {
            winningNumbers = winningNumberTokens.stream().map(Integer::parseInt).collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형태입니다.");
        }
        if (winningNumbers.size() != winningNumberTokens.size()) {
            throw new IllegalArgumentException("당첨 번호로 중복된 숫자는 허용하지 않습니다.");
        }
        return winningNumbers;
    }

    private int setBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                String input = inputView.getBonusNumberFromUser();
                validateEmptyString(input);
                bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                break; // validInput 대신 true일 때 break로 종료
            } catch (NumberFormatException e) {
                outputView.printInvalidInputErrorMessage("유효하지 않은 숫자 형태입니다.");
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
