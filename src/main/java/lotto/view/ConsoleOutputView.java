package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    public void printTotalIssuedLotto(List<Lotto> issuedLotto) {
        System.out.println(issuedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : issuedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result);
        }
    }

    public void printWinningStatus(List<LottoRank> lottoRanks, int lottoPrice) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.getAllRanks()) {
            System.out.println(getPrizeLine(lottoRanks, rank));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", getProfitRate(lottoRanks, lottoPrice));
    }

    private String getPrizeLine(List<LottoRank> lottoRanks, LottoRank rank) {
        StringBuilder result = new StringBuilder();
        result.append(rank.getMatchCount()).append("개 일치");
        if (rank.isBonusRequired()) {
            result.append(", 보너스 볼 일치");
        }
        result.append(" (").append(formatNumber(rank.getPrize())).append("원)");
        result.append(" - ").append(countRank(lottoRanks, rank)).append("개");
        return result.toString();
    }

    private double getProfitRate(List<LottoRank> lottoRanks, int lottoPrice) {
        double profit = 0;
        for (LottoRank lottoRank : lottoRanks) {
            profit += lottoRank.getPrize();
        }
        return profit / (lottoRanks.size() * lottoPrice) * 100;
    }

    private String formatNumber(int number) {
        return String.format("%,d", number);
    }

    private int countRank(List<LottoRank> lottoRanks, LottoRank rank) {
        return Collections.frequency(lottoRanks, rank);
    }
}
