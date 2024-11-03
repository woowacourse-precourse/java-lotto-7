package lotto.io;

import lotto.domain.PrizeTier;

import java.util.List;
import java.util.Map;

public class OutputWriter {
    public static void message(String message) {
        System.out.println(message);
    }

    public static void issuedNumbers(List<List<Integer>> issuedNumbers) {
        for (List<Integer> issuedNumber : issuedNumbers) {
            System.out.println(issuedNumber);
        }
    }

    public static void lottoCalculateResults(Map<PrizeTier, Integer> results) {
        for (int i = PrizeTier.values().length - 1; i >= 0; i--) {
            PrizeTier tier = PrizeTier.values()[i];
            int count = results.get(tier);

            String output = String.format("%d개 일치 (%,d원) - %d개",
                    tier.getMatchCount(),
                    tier.getPrize(),
                    count);

            // matchCount가 5일 때 보너스 번호의 일치 여부를 확인하고 출력
            if (tier.getMatchCount() == 5) {
                if (tier.isBonusMatch()) {
                    output = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                            tier.getMatchCount(),
                            tier.getPrize(),
                            count);
                }
            }
            System.out.println(output);
        }
    }

    public static void profitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static void addBlankLine() {
        System.out.println();
    }

}
