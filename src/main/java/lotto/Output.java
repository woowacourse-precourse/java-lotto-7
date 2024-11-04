package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printPurchaseAmountRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberRequestMessage(int count) {
        printBlankLine();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberRequestMessage() {
        printBlankLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberRequestMessage() {
        printBlankLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printRunResultMessage() {
        printBlankLine();
        System.out.println("당첨 통계");
    }

    public static void printLine() {
        System.out.println("---");
    }

    public static void printLottoRankResult(Map<LottoWinningRanks, Integer> rankCounts) {
        createRankMessages().forEach((rank, message) -> {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", message, count);
        });
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", rateOfReturn);
    }

    private static Map<LottoWinningRanks, String> createRankMessages() {
        Map<LottoWinningRanks, String> messages = new LinkedHashMap<>();
        messages.put(LottoWinningRanks.FIFTH, "3개 일치 (5,000원)");
        messages.put(LottoWinningRanks.FOURTH, "4개 일치 (50,000원)");
        messages.put(LottoWinningRanks.THIRD, "5개 일치 (1,500,000원)");
        messages.put(LottoWinningRanks.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        messages.put(LottoWinningRanks.FIRST, "6개 일치 (2,000,000,000원)");
        return messages;
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
