package lotto.util.io;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Result;

import java.util.List;
import java.util.Map;

public class Writer {

    public static void writeIssuedLottos(List<Lotto> lottos) {
        System.out.printf("%n%d개를 구매했습니다%n", lottos.size());

        lottos.forEach((lotto) -> {
            String joinedLotto = String.join(
                    ", ",
                    lotto.getImmutableNumbers().stream().sorted().map(String::valueOf).toList()
            );
            System.out.println("[" + joinedLotto + "]");
        });
        System.out.println();
    }

    public static void writeResult(Result result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Prize prize : Prize.values()) {
            if (prize == Prize.FAIL)
                continue;

            String matchMessage = constructMessageFrom(prize);
            int count = getCount(result.getImmutablePrizeCount(), prize);

            System.out.printf(matchMessage + " - %d개%n", count);
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.", result.getReturnRate() * 100);
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    private static String constructMessageFrom(Prize prize) {
        if (prize.isBonusMatch()) {
            return String.format("%d개 일치, 보너스볼 일치 (%,d원)", prize.getMatchCount(), prize.getMoney());
        }

        return String.format("%d개 일치 (%,d원)", prize.getMatchCount(), prize.getMoney());
    }

    private static int getCount(Map<Prize, Integer> prizeCount, Prize prize) {
        if (prizeCount.get(prize) == null) {
            return 0;
        }

        return prizeCount.get(prize);
    }
}
