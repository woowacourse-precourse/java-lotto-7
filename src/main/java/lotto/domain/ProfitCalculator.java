package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ProfitCalculator {

    public Map<Ranking, Integer> getWinningInfo(Lottos lottos, WinningBonus winningBonus) {
        Map<Ranking, Integer> winningInfo = generateWinningInfo();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = matchLottoAndWinning(lotto, winningBonus);
            boolean containsBonusNumber = checkBonusNumber(lotto, winningBonus, matchingCount);
        }
    }

    private Map<Ranking, Integer> generateWinningInfo() {
        Map<Ranking, Integer> winningInfo = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(ranking -> winningInfo.put(ranking, 0));
        return winningInfo;
    }

    private int matchLottoAndWinning(Lotto lotto, WinningBonus winningBonus) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningBonus.getWinningNumbers();
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean checkBonusNumber(Lotto lotto, WinningBonus winningBonus, int matchingCount) {
        if (matchingCount != 5) {
            return false;
        }
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningBonus.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

}