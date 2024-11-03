package lotto.presentation.view;

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
        for (LottoRank currentRank : LottoRank.values()) {
            long lottoHitCount = lottoRanks.stream()
                    .filter(myLottoRank -> myLottoRank == currentRank)
                    .count();
            if (currentRank.isBonusHit()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n",
                        currentRank.getHitCount(), currentRank.getPrize(), lottoHitCount);
            } else {
                System.out.printf("%d개 일치 (%d원) - %d개%n",
                        currentRank.getHitCount(), currentRank.getPrize(), lottoHitCount);
            }
        }
    }

    private void printIssuedLotto(Lotto issuedLotto) {
        List<String> toStringLottoNumber = issuedLotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber))
                .toList();
        System.out.println("[" + String.join(", ", toStringLottoNumber) + "]");
    }
}
