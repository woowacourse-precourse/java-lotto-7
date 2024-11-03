package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Ranks;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsoleOutput implements Output {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("#,###");

    @Override
    public void outputError(Exception exception) {
        System.out.printf("%s %s", ERROR_PREFIX, exception.getMessage());
        System.out.println();
        goToNext();
    }

    @Override
    public void showLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
    }

    @Override
    public void goToNext() {
        System.out.println();
    }

    @Override
    public void showRanks(Ranks ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Rank> prizeRanks = ranks.getPrizeRanks();
        Map<Rank, Long> countByRank = groupingByCount(prizeRanks);

        for (Rank rank : sortPrintRanks()) {
            printRank(rank, countByRank.getOrDefault(rank, 0L));
        }
    }

    @Override
    public void showProfitPercentage(BigDecimal profitPercentage) {
        System.out.println("총 수익률은 " + profitPercentage + "%입니다.");
    }

    private Map<Rank, Long> groupingByCount(List<Rank> ranks) {
        return ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<Rank> sortPrintRanks() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isPrizeRank)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private void printRank(Rank rank, Long count) {
        String prizeAmount = AMOUNT_FORMATTER.format(rank.getPrizeAmount());

        System.out.printf("%d개 일치%s (%s원) - %d개",
                rank.getMatchingCount(), bonusPhrase(rank), prizeAmount, count);
        System.out.println();
    }

    private String bonusPhrase(Rank rank) {
        if (rank.shouldSuccessBonus()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

}
