package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_PURCHASE_COUNT = "%d개를 구매했습니다.";
    private static final String MESSAGE_USER_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_RESULTS_HEADER = "당첨 통계";
    private static final String MESSAGE_RESULTS_SEPARATOR = "---";
    private static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.%n";

    private static final String[] RANK_DESCRIPTIONS = {
            "3개 일치 (5,000원)",
            "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "6개 일치 (2,000,000,000원)"
    };

    public static void purchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
    }

    public static void purchaseCount(int count) {
        System.out.printf((MESSAGE_PURCHASE_COUNT) + "%n", count);
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void userNumber() {
        System.out.println(MESSAGE_USER_NUMBER);
    }

    public static void printResults(Map<Integer, Integer> rankResults) {
        System.out.println(MESSAGE_RESULTS_HEADER);
        System.out.println(MESSAGE_RESULTS_SEPARATOR);

        for (int i = 5; i >= 1; i--) {
            int count = rankResults.getOrDefault(i - 1, 0);
            System.out.printf("%s - %d개%n", RANK_DESCRIPTIONS[5 - i], count);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(MESSAGE_PROFIT_RATE, profitRate);
    }
}
