package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.constants.PrizeType;

public class OutputView {
    private static final String LOTTO_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String PRIZE_FORMAT = "%s%s - %d개\n";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.";
    
    public void showPurchaseAmount(int chance) {
        System.out.printf(LOTTO_FORMAT, chance);
    }

    public void printLotto(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printStatistics(int[] results, int moneySpent) {
        int totalPrize = 0;
        showResultMessage();
        for (PrizeType prizeType : PrizeType.values()) {
            int count = results[prizeType.ordinal()];
            int prizeAmount = prizeType.getPrizeMoney();
            totalPrize += count * prizeAmount;
            System.out.printf(PRIZE_FORMAT, prizeType.getMatching(), prizeType.getPrize(), count);
        }
    }

    public void printStatistics(int[] results) {
        showResultMessage();
        Arrays.stream(PrizeType.values())
                .forEach(prizeType -> {
                    int count = results[prizeType.ordinal()];
                    System.out.printf(PRIZE_FORMAT, prizeType.getMatching(), prizeType.getPrize(), count);
                });
    }

    public void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_FORMAT, earningRate);
    }

    public void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}