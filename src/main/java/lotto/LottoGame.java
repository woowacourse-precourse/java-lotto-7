package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private int totalPrize = 0; // 총 당첨 금액
    private Map<MatchResult, Integer> matchResults = new EnumMap<>(MatchResult.class); // 각 결과의 당첨 횟수 저장

    private List<Lotto> tickets;

    private WinningNumbers winningNumbers;

    LottoGame(List<Lotto> tickets, WinningNumbers winningNumbers) {

        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
    }

    public Map<MatchResult, Integer> getMatchResults() {
        return matchResults; // 각 결과의 당첨 횟수를 반환
    }

    public void calculateResults() {
        for(Lotto ticket : tickets) {
            int matchCount = ticket.countMatchingNumbers(winningNumbers.getWinningNumbers());
            boolean bonusMatch = ticket.containsBonusNumber(winningNumbers.getBonusNumber());

            MatchResult result = MatchResult.valueOf(matchCount, bonusMatch);

            if (result != null) {
                totalPrize += result.getPrize(); // 상금 합산
                matchResults.put(result, matchResults.getOrDefault(result, 0) + 1); // 결과 횟수 증가
            }
        }

    }

    public void printResults(double totalPurchase) {
        System.out.println("당첨 통계\n---");

        for (MatchResult result : MatchResult.values()) {
            int count = matchResults.getOrDefault(result, 0);
            String prizeFormatted = String.format("%,d원", result.getPrize()); // 천 단위 구분 기호 추가
            System.out.printf("%d개 일치%s (%s) - %d개\n",
                    result.getMatchCount(),
                    result.isBonusMatch() ? ", 보너스 볼 일치" : "",
                    prizeFormatted,
                    count);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateYield(totalPurchase));
    }

    public double calculateYield(double totalPurchase) {
        return (totalPrize / totalPurchase) * 100;
    }
}
