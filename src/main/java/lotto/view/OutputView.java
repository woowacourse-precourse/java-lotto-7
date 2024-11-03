package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String winningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private static final String lottoCountMessage = "%d개를 구매했습니다.\n";
    private static final String prizeStatisticsHeader = "당첨 통계\n---";
    private static final String[] matchNumbers = {"3", "4", "5", "5.5", "6"};
    private static final String[] matchPrefixMessage = {
            "3개 일치 (5,000원)",
            "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "6개 일치 (2,000,000,000원)"
    };
    private static final String rateOfReturnMessage = "총 수익률은 %s%%입니다.\n";

    private OutputView() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(purchaseAmountMessage);
    }

    public static void printInputWinningNumbers() {
        System.out.println(winningNumbersMessage);
    }

    public static void printInputBonusNumber() {
        System.out.println(bonusNumberMessage);
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.printf(lottoCountMessage, lottoCount);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printPrizeStatistics(Map<String, Integer> matchCounts) {
        System.out.println(prizeStatisticsHeader);
        for (int i = 0; i < matchNumbers.length; i++) {
            System.out.printf("%s - %d개%n", matchPrefixMessage[i], matchCounts.get(matchNumbers[i]));
        }
    }

    public static void printRateOfReturn(String rateOfReturn) {
        System.out.printf(rateOfReturnMessage, rateOfReturn);
    }
}
