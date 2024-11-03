package lotto;

import static lotto.ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.LottoMachine.MAX_LOTTO_NUMBER_RANGE;
import static lotto.LottoMachine.MIN_LOTTO_NUMBER_RANGE;
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
    private final Map<Rank, Integer> winningRecord = new HashMap<>();

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        WinningNumbers winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        lottoes.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNumber))
                .forEach(this::saveRankOnRecord);
        Output.printWinningStatistics(winningRecord);
        int totalWinningAmount = calculateTotalWinningAmount();
        Output.printReturnRate(purchaseAmount.calculateReturnRate(totalWinningAmount));
    }

    private static PurchaseAmount getPurchaseAmount() {
        try {
            int purchaseAmount = parseInt(inputPurchaseAmount());
            return PurchaseAmount.of(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private static WinningNumbers getWinningNumbers() {
        try {
            List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers());
            return WinningNumbers.of(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static int getBonusNumber(final WinningNumbers winningNumbers) {
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

    private List<Lotto> purchaseLottoes(final PurchaseAmount purchaseAmount) {
        return LottoMachine.purchaseLottoes(purchaseAmount);
    }

    private int calculateTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : Rank.values()) {
            int winningRankCount = winningRecord.getOrDefault(rank, 0);
            totalWinningAmount += winningRankCount * rank.getWinningAmount();
        }
        return totalWinningAmount;
    }

    private static void validateBonusNumberNotInWinningNumbers(final WinningNumbers winningNumbers,
                                                               final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateLottoNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}