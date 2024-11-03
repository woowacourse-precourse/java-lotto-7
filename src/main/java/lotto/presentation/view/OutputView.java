package lotto.presentation.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.dto.LottoStatisticsDto;

public class OutputView {
    public void printIssuedLottos(List<Lotto> issuedLottos) {
        System.out.println(issuedLottos.size() + "개를 구매했습니다.");
        for (Lotto issuedLotto : issuedLottos) {
            printIssuedLotto(issuedLotto);
        }
    }

    public void printLottoRateOfProfit(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println("당첨 통계\n___");
        printLottoDrawResults(lottoStatisticsDto.lottoRanks());
        System.out.println("총 수익률은 " + lottoStatisticsDto.lottoRateOfProfit() + "%입니다.");
    }

    private void printLottoDrawResults(List<LottoRank> lottoRanks) {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(currentRank -> {
                    long lottoHitCount = countHitLotto(lottoRanks, currentRank);
                    System.out.println(printLottoRankResult(currentRank, lottoHitCount));
                });
    }

    private long countHitLotto(List<LottoRank> lottoRanks, LottoRank currentRank) {
        return lottoRanks.stream()
                .filter(myLottoRank -> myLottoRank == currentRank)
                .count();
    }

    private String printLottoRankResult(LottoRank rank, long count) {
        String formattedPrize = String.format("%,d", rank.getPrize());
        if (rank.isBonusHit()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getHitCount(), formattedPrize, count);
        }
        return String.format("%d개 일치 (%s원) - %d개", rank.getHitCount(), formattedPrize, count);
    }

    private void printIssuedLotto(Lotto issuedLotto) {
        List<String> toStringLottoNumber = issuedLotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber))
                .toList();
        System.out.println("[" + String.join(", ", toStringLottoNumber) + "]");
    }
}
