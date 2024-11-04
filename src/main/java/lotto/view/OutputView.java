package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoResult;

import java.util.*;

public class OutputView {
    public void printBoughtLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다.%n", lottos.size()));

        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            sb.append(numbers).append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());
        System.out.print(sb);
    }

    public void printLottoResult(LottoResult lottoResult) {
        printStatHeader();
        printRankStat(lottoResult.getLottoStat().getStats());
        printPrizeRate(lottoResult.getPrizeRate());
    }

    private void printStatHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printRankStat(Map<LottoRank, Integer> results) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .forEach(lottoRank -> System.out.printf("%s (%,d원) - %d개%n",
                        lottoRank.getDescription(),
                        lottoRank.getPrize(),
                        results.get(lottoRank)));
    }

    private void printPrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", prizeRate);
    }
}
