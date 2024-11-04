package lotto;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {

    private final Map<MatchCondition, Integer> prizeCounts = new LinkedHashMap<>();

    public Output() {
        initializePrizeCounts();
    }

    public static void outputTicketNumbers(List<LottoTicket> lottoTicketBundle) {
        System.out.println(lottoTicketBundle.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public void printMatchResult(MatchResult matchResult) {
        List<MatchCondition> matchConditions = matchResult.getMatchedConditions();

        for (MatchCondition matchCondition : matchConditions) {
            // 조건에 맞는 카운트 증가
            prizeCounts.put(matchCondition, prizeCounts.getOrDefault(matchCondition, 0) + 1);
        }

        // 당첨 통계 출력
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Map.Entry<MatchCondition, Integer> entry : prizeCounts.entrySet()) {
            MatchCondition condition = entry.getKey();
            Integer count = entry.getValue();
            System.out.printf("%s - %d개\n", condition.prizeDescription(), count);
        }
        System.out.printf("총 수익률은 %.2f%%입니다.\n", matchResult.getProfitRatio());
    }

    private List<MatchCondition> getSortedMatchConditions(List<MatchCondition> matchConditions) {
        return matchConditions.stream()
                .sorted(Comparator.comparing(MatchCondition::getPrizedAmount))
                .toList();
    }

    private void initializePrizeCounts() {
        List<MatchCondition> sortedMatchConditions = getSortedMatchConditions(TicketPrizeMatcher.matchConditions);

        // 상금 조건별 초기 카운트 설정
        for (MatchCondition condition : sortedMatchConditions) {
            prizeCounts.put(condition, 0);
        }
    }
}
