package lotto;

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

    public void printLottoResult(Lottos lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> results = lottoResult.calculate(lottos, winningLotto);
        double prizeRate = lottoResult.calculatePrizeRate(lottos.getLottos().size());

        printStatHeader();
        printRankStat(results);
        printPrizeRate(prizeRate);

    }

    private void printStatHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printRankStat(Map<Rank, Integer> results) {
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.printf("%s (%,d원) - %d개%n",
                        rank.getDescription(),
                        rank.getPrize(),
                        results.get(rank)));
    }

    private void printPrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", prizeRate);
    }
}
