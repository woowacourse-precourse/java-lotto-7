package lotto;

import java.util.List;

public class LottoGameRunner {

    private final LottoGame lottoGame;

    private LottoGameRunner(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoGameRunner from(LottoGame lottoGame) {
        return new LottoGameRunner(lottoGame);
    }

    public void run() {

        List<Integer> winningHistoty = lottoGame.getLottos().stream()
                .map(lotto -> {
                    int correctCount = 0;
                    for(Integer value : lotto.getNumbers()) {
                        if(lottoGame.getWinningNumbers().contains(value)) {
                            correctCount++;
                        }
                    }
                    if (correctCount == 5) {
                        if (lotto.contains(lottoGame.getBonusNumber())) {
                            correctCount = 7;
                        }
                    }
                    return  correctCount;
                })
                .toList();

        List<Integer> winningRanks = winningHistoty.stream()
                .map(wimCount -> {
                    if(wimCount == 6) {
                        return 1;
                    }

                    if(wimCount == 7) {
                        return 2;
                    }

                    if(wimCount == 5) {
                        return 3;
                    }

                    if(wimCount == 4) {
                        return 4;
                    }

                    if(wimCount == 3) {
                        return 5;
                    }

                    return 0;
                })
                .toList();

        Integer totalEarned = winningRanks.stream()
                .mapToInt(rank -> {
                    if(rank == 1) {
                        return 2000000000;
                    }

                    if(rank == 2) {
                        return 30000000;
                    }

                    if(rank == 3) {
                        return 1500000;
                    }

                    if(rank == 4) {
                        return 50000;
                    }

                    if(rank == 5) {
                        return 5000;
                    }

                    return 0;
                })
                .sum();

        double earnRate = ((double) totalEarned / lottoGame.getTotalPrice()) * 100;
        Double roundedEarnRate = Math.round(earnRate * 100) / 100.0;

        StringBuilder winStatsResult = new StringBuilder();
        int[] countPerWinningRank = new int[6];
        winningRanks
                .forEach(rank -> {
                    countPerWinningRank[rank]++;
                });

        winStatsResult
                .append("\n당첨 통계\n---\n")
                .append("3개 일치 (5,000원) - ").append(countPerWinningRank[5]).append("\n")
                .append("4개 일치 (50,000원) - ").append(countPerWinningRank[4]).append("\n")
                .append("5개 일치 (1,500,000원) - ").append(countPerWinningRank[3]).append("\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(countPerWinningRank[2]).append("\n")
                .append("6개 일치 (2,000,000,000원) - ").append(countPerWinningRank[1]).append("\n")
                .append("총 수익률은 ").append(roundedEarnRate).append("%입니다.");

        System.out.println(winStatsResult);
    }
}
