package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_Money_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String PRIZE_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String[] MATCH_NUMBERS = {"3", "4", "5", "5.5", "6"};
    private static final String[] MATCH_PREFIX_MESSAGE = {
            "3개 일치 (5,000원)",
            "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "6개 일치 (2,000,000,000원)"
    };
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.\n";

    private OutputView() {
    }

    public static void printInputPurchaseMoneyMessage() {
        System.out.println(PURCHASE_Money_MESSAGE);
    }

    public static void printInputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printPrizeStatistics(Map<String, Integer> matchCounts) {
        System.out.println(PRIZE_STATISTICS_HEADER);
        for (int i = 0; i < MATCH_NUMBERS.length; i++) {
            System.out.printf("%s - %d개%n", MATCH_PREFIX_MESSAGE[i], matchCounts.get(MATCH_NUMBERS[i]));
        }
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
