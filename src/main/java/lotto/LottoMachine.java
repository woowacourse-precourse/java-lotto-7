package lotto;

import lotto.enums.LottoRank;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoRank, Long> winningStatistics;
    int totalPrize;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningStatistics = initializeWinningStatistics();
    }


    private Map<LottoRank, Long> initializeWinningStatistics() {
        Map<LottoRank, Long> initialStatistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            initialStatistics.put(rank, 0L);
        }
        return initialStatistics;
    }

    public void calculateWinningStatistics(List<Lotto> lottoBatch) {
        lottoBatch.stream()
                .map(lotto -> getLottoRank(lotto.getNumbers()))
                .filter(Objects::nonNull)
                .forEach(rank -> {
                    winningStatistics.put(rank, winningStatistics.get(rank) + 1);
                    totalPrize += rank.getPrize();
                });
    }

    private LottoRank getLottoRank(List<Integer> lottoNumbers) {
        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);

        return LottoRank.findByMatchCountAndBonus((int) matchCount, bonusMatch);
    }

    public void displayWinningStatistics() {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            String message = rank.getMessage(winningStatistics.get(rank).intValue());
            System.out.println(message);
        }
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
