package lotto.presentation.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.dto.LottoStatisticsDto;

public class OutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printIssuedLottos(List<Lotto> issuedLottos) {
        System.out.println(issuedLottos.size() + "개를 구매했습니다.");
        issuedLottos.forEach(this::printIssuedLotto);
    }

    public void printLottoRateOfProfit(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println("당첨 통계\n___");
        printLottoDrawResults(lottoStatisticsDto.lottoRanks());
        System.out.println("총 수익률은 " + lottoStatisticsDto.lottoRateOfProfit() + "%입니다.");
    }

    private void printIssuedLotto(Lotto issuedLotto) {
        List<String> toStringLottoNumber = issuedLotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber))
                .toList();
        System.out.println("[" + String.join(", ", toStringLottoNumber) + "]");
    }

    private void printLottoDrawResults(List<LottoRank> lottoRanks) {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(currentRank -> printSingleRankResult(lottoRanks, currentRank));
    }

    private void printSingleRankResult(List<LottoRank> lottoRanks, LottoRank currentRank) {
        long lottoHitCount = countHitLotto(lottoRanks, currentRank);
        System.out.println(generateLottoRankResult(currentRank, lottoHitCount));
    }

    private long countHitLotto(List<LottoRank> lottoRanks, LottoRank currentRank) {
        return lottoRanks.stream()
                .filter(myLottoRank -> myLottoRank == currentRank)
                .count();
    }

    private String generateLottoRankResult(LottoRank rank, long count) {
        if (rank.isBonusHit()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getHitCount(),
                    String.format("%,d", rank.getPrize()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", rank.getHitCount(), String.format("%,d", rank.getPrize()), count);
    }
}
