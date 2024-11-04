package lotto;

import java.util.List;

public class ResultCalculator {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> lottos;

    public ResultCalculator(WinningNumbers winningNumbers, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
    }

    public Statistics calculate() {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

            if (matchCount == Rank.FIRST.getMatchCount()) {
                first++;
                continue;
            }
            if (matchCount == Rank.SECOND.getMatchCount() && bonusMatch) {
                second++;
                continue;
            }
            if (matchCount == Rank.THIRD.getMatchCount()) {
                third++;
                continue;
            }
            if (matchCount == Rank.FOURTH.getMatchCount()) {
                fourth++;
                continue;
            }
            if (matchCount == Rank.FIFTH.getMatchCount()) {
                fifth++;
                continue;
            }
            // No action needed for none
        }

        return new Statistics(first, second, third, fourth, fifth, lottos.size() * LottoGenerator.LOTTO_PRICE);
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
