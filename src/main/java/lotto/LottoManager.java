package lotto;

import static lotto.ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS;
import static lotto.ErrorMessage.INVALID_WINNING_NUMBERS_COUNT;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.ErrorMessage.NOT_UNIQUE_WINNING_NUMBER;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_EXCEED_LIMIT;
import static lotto.ErrorMessage.NOT_ENOUGH_PURCHASE_AMOUNT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE;
import static lotto.view.Input.inputBonusNumber;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Input.inputWinningNumbers;
import static lotto.InputParser.parseInt;
import static lotto.InputParser.parseWinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.Output;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final int PERCENTAGE_FACTOR = 100;
    private static final int MIN_LOTTO_NUMBERS_RANGE = 1;
    private static final int MAX_LOTTO_NUMBERS_RANGE = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;
    private final Map<Rank, Integer> winningRecord = new HashMap<>();

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        lottoes.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNumber))
                .forEach(this::saveRankOnRecord);
        Output.printWinningStatistics(winningRecord);
        double returnRate = (double) calculateTotalWinningAmount() * PERCENTAGE_FACTOR / purchaseAmount;
        Output.printReturnRate(returnRate);
    }

    private static int getPurchaseAmount() {
        try {
            int purchaseAmount = parseInt(inputPurchaseAmount());
            validatePurchaseAmountEnough(purchaseAmount);
            validatePurchaseAmountMultipleLottoPrice(purchaseAmount);
            validatePurchaseAmountExceedLimit(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private static List<Integer> getWinningNumbers() {
        try {
            List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers());
            validateWinningNumbersCount(winningNumbers);
            validateWinningNumbersRange(winningNumbers);
            validateUniqueWinningNumber(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static int getBonusNumber(final List<Integer> winningNumbers) {
        try {
            int bonusNumber = parseInt(inputBonusNumber());
            validateLottoNumberRange(bonusNumber);
            validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private void saveRankOnRecord(final Rank rank) {
        int rankCount = winningRecord.getOrDefault(rank, 0);
        winningRecord.put(rank, ++rankCount);
    }

    private List<Lotto> purchaseLottoes(final int purchaseAmount) {
        int totalLottoCount = purchaseAmount / LOTTO_PRICE;
        return LottoMachine.issueLottoes(totalLottoCount);
    }

    private int calculateTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : Rank.values()) {
            int winningRankCount = winningRecord.getOrDefault(rank, 0);
            totalWinningAmount += winningRankCount * rank.getWinningAmount();
        }
        return totalWinningAmount;
    }

    private static void validatePurchaseAmountEnough(final int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validatePurchaseAmountMultipleLottoPrice(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_LOTTO_PRICE.getMessage());
        }
    }

    private static void validatePurchaseAmountExceedLimit(final int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_EXCEED_LIMIT.getMessage());
        }
    }

    private static void validateUniqueWinningNumber(final List<Integer> winningNumbers) {
        long distinctCount = winningNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(NOT_UNIQUE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateWinningNumbersRange(final List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            validateLottoNumberRange(number);
        }
    }

    private static void validateWinningNumbersCount(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(final List<Integer> winningNumbers,
                                                               final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateLottoNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBERS_RANGE || number > MAX_LOTTO_NUMBERS_RANGE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}