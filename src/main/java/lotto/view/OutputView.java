package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_STATUS_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RANK_FORM = "%d개 일치%s (%s원) - %d개";
    private static final String PRICE_FORM = "%,d";
    private static final String BONUS_NUMBER_FORM = ", 보너스 볼 일치";

    public void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf((PURCHASE_MESSAGE) + "%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public void printResult(Map<Ranking,Long> rankResults) {
        System.out.println();
        System.out.println(RESULT_STATUS_MESSAGE);
        System.out.println(LINE);
        StringJoiner output = new StringJoiner("\n");
        formatResult(rankResults, output);
        System.out.println(output);
    }

    private void formatResult(Map<Ranking, Long> rankResults, StringJoiner output) {
        rankResults.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Ranking.UNRANKED))
                .sorted(Comparator.comparingLong(o -> o.getKey().getPrice()))
                .forEach(entry -> {
                    Integer collectCount = entry.getKey().getCollectCount();
                    String price = formatPrice(entry.getKey().getPrice());
                    String bonusNumber = formatBonusNumber(entry.getKey());
                    Long count = entry.getValue();
                    output.add(String.format(RANK_FORM, collectCount,bonusNumber, price, count));
                });
    }

    public void printProfitRate(Double rate) {
        System.out.printf((RATE_OF_RETURN_MESSAGE) + "%n", rate);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    private String formatBonusNumber(Ranking rank) {
        if(rank.isRequireBonusNumber()) {
            return BONUS_NUMBER_FORM;
        }
        return "";
    }

    private String formatPrice(Long price) {
        return String.format(PRICE_FORM, price);
    }
}
