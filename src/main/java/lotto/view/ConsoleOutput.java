package lotto.view;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.configuration.Prize;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.Lotto;

public class ConsoleOutput {

    public void printProfitStatistics(ProfitStatisticsDto input) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        // 모든 Prize 등수를 출력하기 위해 기본 Map 생성
        Map<Prize, Integer> completePrizeMap = Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> input.getPrizeCountMap().getOrDefault(prize, 0)));

        Arrays.stream(Prize.values())
                .sorted(Comparator.comparingInt(Prize::getPrizeMoney))
                .forEach(prize -> {
                    if (prize == Prize.NONE) {
                        return;
                    }
                    String outMessage = format("%d개 일치 (%,d원) - %d개", prize.getMatchCount(),
                            prize.getPrizeMoney(), completePrizeMap.get(prize));
                    if (prize == Prize.SECOND) {
                        outMessage = format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                                prize.getMatchCount(), prize.getPrizeMoney(), completePrizeMap.get(prize));
                    }
                    System.out.println(outMessage);
                });
        System.out.println(format("총 수익률은 %.1f%%입니다.", input.getProfitRate()));
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(format("%d개를 구매했습니다.", lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().stream().sorted().toList()));
    }
}
