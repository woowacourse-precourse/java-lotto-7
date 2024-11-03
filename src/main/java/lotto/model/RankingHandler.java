package lotto.model;

import lotto.constants.Ranking;

import java.util.Map;

public class RankingHandler {

    public void printResults(Customer customer) {
        Map<Ranking, Integer> results = customer.getLottoResults();
        for (Ranking ranking : Ranking.values()) {
            if (ranking.isWinning()) {
                int count = results.get(ranking);
                resultOutput(ranking, count);
            }
        }
    }

    private void resultOutput(Ranking ranking, int count) {
        System.out.printf("%d개 일치 (%s원) - %d개%n", ranking.getCount(), ranking.getStrWinnings(), count);
    }


}
