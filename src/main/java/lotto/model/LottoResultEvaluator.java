package lotto.model;

import java.util.List;
import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;

public class LottoResultEvaluator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int threeMatchesCount = 0;
    private int fourMatchesCount = 0;
    private int fiveMatchesCount = 0;
    private int fiveWithBonusCount = 0;
    private int sixMatchesCount = 0;

    public LottoResultEvaluator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult evaluate(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            MatchInfo matchInfo = countMatches(numbers);
            count(matchInfo);
        }
        double totalYield = calculateTotalYield(lottoTickets);
        return new WinningResult(
                threeMatchesCount,
                fourMatchesCount,
                fiveMatchesCount,
                fiveWithBonusCount,
                sixMatchesCount,
                totalYield
        );
    }

    private double calculateTotalYield(List<Lotto> lottoTickets) {
        double purchaseAmount = lottoTickets.size() * 1_000;
        double winningAmount = calculateWinningAmount();
        return (winningAmount / purchaseAmount) * 100;
    }

    private int calculateWinningAmount() {
        int amount = 0;
        amount += threeMatchesCount * 5_000;
        amount += fourMatchesCount * 50_000;
        amount += fiveMatchesCount * 1_500_000;
        amount += fiveWithBonusCount * 30_000_000;
        amount += sixMatchesCount * 2_000_000_000;
        return amount;
    }

    private void count(MatchInfo matchInfo) {
        if (matchInfo.matchesCount() == 3) {
            threeMatchesCount++;
            return;
        }
        if (matchInfo.matchesCount() == 4) {
            fourMatchesCount++;
            return;
        }
        if (matchInfo.matchesCount() == 5 && matchInfo.isBonusNumberMatch()) {
            fiveWithBonusCount++;
            return;
        }
        if (matchInfo.matchesCount() == 5) {
            fiveMatchesCount++;
            return;
        }
        if (matchInfo.matchesCount() == 6) {
            sixMatchesCount++;
        }
    }

    private MatchInfo countMatches(List<Integer> numbers) {
        int matchesCount = 0;
        for (Integer number : numbers) {
            if (isMatch(number)) {
                matchesCount++;
            }
        }

        if (matchesCount == 5) {
            return new MatchInfo(matchesCount, numbers.contains(bonusNumber));
        }
        return new MatchInfo(matchesCount, false);
    }

    private boolean isMatch(Integer number) {
        for (Integer winningNumber : winningNumbers) {
            if (number.equals(winningNumber)) {
                return true;
            }
        }
        return false;
    }
}
