package lotto.util;


import lotto.constants.ErrorMessage;
import lotto.policy.RankingPolicy;

import static lotto.constants.AppConst.BONUS_MATCH_COUNT;

public abstract class Printer {

    public static void print(Object... messages) {
        for (Object message : messages) {
            if (message instanceof Exception e) {
                System.out.print(ErrorMessage.ERROR_PREFIX + e.getMessage());
                continue;
            }
            System.out.print(message);
        }
        breakLine();
    }

    public static void breakLine() {
        System.out.println();
    }

    public static void printResult(RankingPolicy policy, int count) {
        if (policy.getMatchCount() != BONUS_MATCH_COUNT) {
            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    policy.getMatchCount(),
                    String.format("%,d", policy.getPrize()),
                    count);
            return;
        }
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                String.format("%,d", policy.getPrize()),
                count);
    }
    public static void printBenefitResult (double value) {
        System.out.println("총 수익률은 " + String.format("%.1f", value) + "%입니다.");
    }
}
