package lotto;

import java.util.List;

public class Output {
    private final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String COUNT = "개를 구매했습니다.";
    private final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String WINNING_STATISTICS = "당첨 통계\n---\n";
    private final String UNIT = "개\n";
    private final String TOTAL_RATE_OF_RETURN_FRONT = "총 수익률은 ";
    private final String TOTAL_RATE_OF_RETURN_BACK = "%입니다.";

    public void purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public void winningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    public void bonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public void lottoCountAndNumbers(LottoGenerator lottoGenerator) {
        StringBuilder lottoInfo = new StringBuilder();
        lottoInfo.append(lottoGenerator.getCount())
                        .append(COUNT).append("\n");
        for (Lotto lotto : lottoGenerator.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            lottoInfo.append("[").append(numbers.getFirst());
            for (int i = 1; i < numbers.size(); i++) {
                lottoInfo.append(", ").append(numbers.get(i));
            }
            lottoInfo.append("]").append("\n");
        }
        System.out.println(lottoInfo);
    }

    public void winningStatistics(WinningCounter winningCounter) {
        StringBuilder statistics = new StringBuilder(WINNING_STATISTICS);
        for (Winning winning : Winning.values()) {
            statistics.append(winning.getMatchString())
                    .append(winningCounter.getWinningCount(winning))
                    .append(UNIT);
        }
        statistics.append(TOTAL_RATE_OF_RETURN_FRONT)
                .append(Statistics.calculateRateOfReturn(InputValidator.getPurchaseAmount(), winningCounter.calculateProfitAmount()))
                .append(TOTAL_RATE_OF_RETURN_BACK);
        System.out.print(statistics);
    }
}
