package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private final int totalPurchase;
    private int bonusNumber;

    public LottoService(int totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public List<List<Integer>> generateLottoTickets() {
        int totalQuantity = this.totalPurchase / LottoConstants.TICKET_PRICE;
        System.out.printf("\n%d개를 구매했습니다.\n", totalQuantity);
        return getTotalRandomNumbers(totalQuantity);
    }

    private List<List<Integer>> getTotalRandomNumbers(int totalQuantity) {
        List<List<Integer>> totalRandomNumbers = new ArrayList<>();
        for (int i = 0; i < totalQuantity; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER, LottoConstants.PICK_COUNT));
            Collections.sort(randomNumbers);
            System.out.println(randomNumbers);
            totalRandomNumbers.add(randomNumbers);
        }
        return totalRandomNumbers;
    }

    public Lotto getValidatedLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int getValidatedBonusNumber(Lotto lotto, int bonusNumber) {
        lotto.validateAddedNumber(bonusNumber);
        return bonusNumber;
    }

    public void updateLottoResults(List<List<Integer>> totalRandomNumbers, List<Integer> winningNumbers) {
        System.out.println("\n당첨 통계\n---");
        calculateMatchingResults(totalRandomNumbers, winningNumbers);
        printResults();
        printTotalYield();
    }

    private void calculateMatchingResults(List<List<Integer>> totalRandomNumbers, List<Integer> winningNumbers) {
        for (List<Integer> randomNumbers : totalRandomNumbers) {
            int commonCount = countCommonElements(randomNumbers, winningNumbers);
            boolean bonusMatch = isBonusMatched(commonCount, randomNumbers, winningNumbers);
            incrementMatchingResult(commonCount, bonusMatch);
        }
    }

    private int countCommonElements(List<Integer> randomNumbers, List<Integer> winningNumbers) {
        List<Integer> copiedRandomNumbers = new ArrayList<>(randomNumbers);
        copiedRandomNumbers.retainAll(winningNumbers);
        return copiedRandomNumbers.size();
    }

    private boolean isBonusMatched(int commonCount, List<Integer> randomNumbers, List<Integer> winningNumbers) {
        return (commonCount == LottoConstants.BONUS_MATCH_CONDITION) && isBonusNumberMatched(randomNumbers, winningNumbers);
    }

    private boolean isBonusNumberMatched(List<Integer> randomNumbers, List<Integer> winningNumbers) {
        List<Integer> copiedRandomNumbers = new ArrayList<>(randomNumbers);
        copiedRandomNumbers.removeAll(winningNumbers);
        return copiedRandomNumbers.contains(this.bonusNumber);
    }

    private void incrementMatchingResult(int commonCount, boolean bonusMatch) {
        if (commonCount == LottoConstants.BONUS_MATCH_CONDITION) {
            handleFiveMatch(bonusMatch);
            return;
        }
        handleRegularMatch(commonCount);
    }

    private void printResults() {
        for (LottoResult result : LottoResult.values()) {
            System.out.printf("%s - %d개%n", result.toString(), result.getWinCount());
        }
    }

    private void printTotalYield() {
        int totalPrize = calculateTotalPrize();
        System.out.printf("총 수익률은 %.1f%%입니다.%n", getYield(totalPrize, this.totalPurchase));
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (LottoResult result : LottoResult.values()) {
            totalPrize += result.getPrize() * result.getWinCount();
        }
        return totalPrize;
    }

    private void handleFiveMatch(boolean bonusMatch) {
        for (LottoResult result : LottoResult.values()) {
            if (result.getMatchCount() == LottoConstants.BONUS_MATCH_CONDITION && result.isBonusMatch() == bonusMatch) {
                result.incrementWinCount();
            }
        }
    }

    private void handleRegularMatch(int commonCount) {
        for (LottoResult result : LottoResult.values()) {
            if (result.getMatchCount() == commonCount) {
                result.incrementWinCount();
            }
        }
    }

    private double getYield(int totalPrize, int totalPurchase) {
        double yield = ((double) totalPrize / totalPurchase) * 100;
        return Math.round(yield * 10) / 10.0;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
