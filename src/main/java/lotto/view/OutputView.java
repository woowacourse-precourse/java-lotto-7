package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutputView {
    public void printLottoNumbers(List<Lotto> generatedLottoNumbers) {
        for(Lotto generatedLottoNumber: generatedLottoNumbers) {
            List<Integer> sortedLottoNumbers = new ArrayList<>(generatedLottoNumber.getLottoNumbers());

            // 오름차순
            Collections.sort(sortedLottoNumbers);
            System.out.println(sortedLottoNumbers);
        }
    }

    public void printResults(Map<Ranking, Integer> results) {
        System.out.println("\n당첨 통계\n---");

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.FAIL) { // 당첨되지 않은 경우 출력하지 않으므로 무시
                continue;
            }

            int matchingCount = ranking.getMatchingCount();
            String bonus = getBonusText(ranking);
            String formattedPrizeAmount = decimalFormat.format(ranking.getPrizeAmount());

            System.out.println(matchingCount + "개 일치" + bonus
                    + " (" + formattedPrizeAmount + "원) - "
                    + results.getOrDefault(ranking, 0) + "개"
            );
        }
    }

    private String getBonusText(Ranking ranking) {
        if (ranking.hasBonus()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public void printProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        profitRate = Double.parseDouble(decimalFormat.format(profitRate));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
