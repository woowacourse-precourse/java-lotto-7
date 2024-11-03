package lotto.view;

import lotto.domain.Rank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String DELIMITER = ", ";

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLotto(BigInteger numberOfLotto) {
        PromptMessage.printLottoCount(numberOfLotto);
    }

    public void printLottoNumbers(List<List<Integer>> numberCollections) {
        StringBuilder builder = new StringBuilder();
        for(List<Integer> numbers: numberCollections) {
            builder.append("[");
            List<String> tokens = numbers.stream().sorted().map(num -> Integer.toString(num)).toList();
            builder.append(String.join(DELIMITER, tokens)).append("]\n");
        }
        System.out.println(builder.append("\n"));
    }

    public void printResult(Map<Rank, BigInteger> counts, BigDecimal returnRate) {
        DecimalFormat df = new DecimalFormat("###,###");

        StringBuilder result = new StringBuilder("\n당첨 통계\n---\n");
        result.append(String.format("%d개 일치 (%s원) - %d개\n", Rank.FIFTH.numberMatched(), df.format(Rank.FIFTH.prize()), counts.get(Rank.FIFTH)));
        result.append(String.format("%d개 일치 (%s원) - %d개\n", Rank.FOURTH.numberMatched(), df.format(Rank.FOURTH.prize()), counts.get(Rank.FOURTH)));
        result.append(String.format("%d개 일치 (%s원) - %d개\n", Rank.THIRD.numberMatched(), df.format(Rank.THIRD.prize()), counts.get(Rank.THIRD)));
        result.append(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", Rank.SECOND.numberMatched(), df.format(Rank.SECOND.prize()), counts.get(Rank.SECOND)));
        result.append(String.format("%d개 일치 (%s원) - %d개\n", Rank.FIRST.numberMatched(), df.format(Rank.FIRST.prize()), counts.get(Rank.FIRST)));

        result.append(String.format("총 수익률은 %s%%입니다.\n", returnRate.setScale(1, RoundingMode.HALF_EVEN)));
        System.out.println(result);
    }
}
