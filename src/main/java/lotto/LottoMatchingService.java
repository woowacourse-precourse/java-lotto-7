package lotto;

import java.util.Map;

public class LottoMatchingService {
    private final LottoResult lottoResult;
    private final LottoRepository lottoRepository;

    public LottoMatchingService() {
        this.lottoRepository = LottoRepository.getInstance();
        this.lottoResult = new LottoResult();
    }

    public void checkLotto(WinningNumber winningNumber) {
        for (Lotto lotto : lottoRepository.findAll()) {
            int matchCount = lotto.getMatchCount(winningNumber.getNumbers());
            boolean hasBonus = lotto.containsBonus(winningNumber.getBonusNumber());
            Rank rank = Rank.calculateRank(matchCount, hasBonus);

            lottoResult.save(rank);
        }
    }

    public void printResults(int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        // 각 등수별 당첨 결과 출력
        for (Map.Entry<Rank, Integer> result : lottoResult.getLottoResult().entrySet()) {
            Rank rank = result.getKey();
            int count = result.getValue();

            if (rank == Rank.NONE) {
                continue;
            }

            System.out.printf("%s (%,d원) - %d개%n", rank.getMessage(), rank.getPrize(), count);
        }

        // 수익률 계산 및 출력
        double profitRate = calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private double calculateProfitRate(int purchaseAmount) {
        int totalPrize = lottoResult.getTotalPrize();
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;

        return (double) Math.round(profitRate * 10) / 10;
    }
}
