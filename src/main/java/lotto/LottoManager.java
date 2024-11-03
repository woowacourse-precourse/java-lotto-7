package lotto;

import static lotto.ErrorMessage.PURCHASE_AMOUNT_EXCEED_LIMIT;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_ENOUGH;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_LOTT_PRICE;
import static lotto.Input.inputBonusNumber;
import static lotto.Input.inputPurchaseAmount;
import static lotto.Input.inputWinningNumber;
import static lotto.InputParser.parseInt;
import static lotto.InputParser.parseWinningNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final int PERCENTAGE_FACTOR = 100;
    private final Map<Rank, Integer> winningRecord = new HashMap<>();

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoes = purchaseLottoes(purchaseAmount);
        Output.printPurchaseMessage(lottoes.size());
        lottoes.forEach(Output::printLotto);
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        lottoes.stream()
                .map(lotto -> lotto.checkRank(winningNumber, bonusNumber))
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
            return getPurchaseAmount();
        }
    }

    private static void validatePurchaseAmountEnough(final int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            System.out.println(PURCHASE_AMOUNT_NOT_ENOUGH.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void validatePurchaseAmountMultipleLottoPrice(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            System.out.println(PURCHASE_AMOUNT_NOT_MULTIPLE_LOTT_PRICE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void validatePurchaseAmountExceedLimit(final int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            System.out.println(PURCHASE_AMOUNT_EXCEED_LIMIT.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getWinningNumber() {
        try {
            return parseWinningNumber(inputWinningNumber());
        } catch (IllegalArgumentException e) {
            return getWinningNumber();
        }
    }

    private static int getBonusNumber() {
        try {
            return parseInt(inputBonusNumber());
        } catch (IllegalArgumentException e) {
            return getBonusNumber();
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
}