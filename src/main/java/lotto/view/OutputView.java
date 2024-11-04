package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.WinningResult;

public class OutputView {
    private static final String REQUEST_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String RESULT_MESSAGE_MESSAGE = "당첨 통계";
    private static final String RESULT_DIVIDER_MESSAGE = "---";
    private static final String RESULT_FORMAT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String RESULT_BONUS_FORMAT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RESULT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void requestBudget() {
        System.out.println(REQUEST_BUDGET_MESSAGE);
    }

    public static void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PURCHASED_LOTTO_TICKET_MESSAGE);

        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void requestWinningLotto() {
        System.out.println();
        System.out.println(REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public static void requestBonusNumber() {
        System.out.println();
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public static void printResultMessage(Map<WinningResult, Integer> result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE_MESSAGE);
        System.out.println(RESULT_DIVIDER_MESSAGE);
        printWinningResult(result);
        printProfit(result);
    }

    public static void printWinningResult(Map<WinningResult, Integer> result) {
        for (WinningResult key : WinningResult.values()) {
            if (key == WinningResult.NONE) {
                continue;
            }
            int value = result.getOrDefault(key, 0);
            if (key.isBonusMatch()) {
                System.out.printf(RESULT_BONUS_FORMAT_MESSAGE + "%n", key.getNormalCount(), key.getReward(), value);
                continue;
            }
            System.out.printf(RESULT_FORMAT_MESSAGE + "%n", key.getNormalCount(), key.getReward(), value);
        }
    }

    private static void printProfit(Map<WinningResult, Integer> result) {
        var totalPurchase = result.keySet().stream()
                .mapToInt(winningResult -> result.get(winningResult) * Lotto.LOTTO_PRICE)
                .sum();

        var totalReward = result.keySet()
                .stream()
                .filter(winningResult -> result.get(winningResult) > 0)
                .mapToInt(winningResult -> winningResult.getReward() * result.get(winningResult))
                .sum();

        System.out.printf(RESULT_PROFIT_MESSAGE + "%n", (double) totalReward / totalPurchase * 100);
    }

    public static void printError(String message) {
        System.out.println(message);
        System.out.println();
    }
}
