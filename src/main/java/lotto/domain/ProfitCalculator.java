package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ProfitCalculator {

    public static Map<Ranking, Integer> getWinningInfo(Lottos lottos, WinningBonus winningBonus) {
        Map<Ranking, Integer> winningInfo = generateWinningInfo();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = matchLottoAndWinning(lotto, winningBonus);
            boolean containsBonusNumber = checkBonusNumber(lotto, winningBonus, matchingCount);
            Ranking ranking = Ranking.findRanking(matchingCount, containsBonusNumber);
            winningInfo.replace(ranking, winningInfo.get(winningInfo) + 1);
        }
        return winningInfo;
    }

    private static Map<Ranking, Integer> generateWinningInfo() {
        Map<Ranking, Integer> winningInfo = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(ranking -> winningInfo.put(ranking, 0));
        return winningInfo;
    }

    private static int matchLottoAndWinning(Lotto lotto, WinningBonus winningBonus) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningBonus.getWinningNumbers();
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean checkBonusNumber(Lotto lotto, WinningBonus winningBonus, int matchingCount) {
        if (matchingCount != 5) {
            return false;
        }
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningBonus.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

    public static int getWinningAmount(Map<Ranking, Integer> winningInfo) {
        return winningInfo.entrySet().stream()
                .mapToInt(entry -> (int) entry.getKey().getWinningPrice() * entry.getValue())
                .sum();
    }

    public static float getLottoProfit(int winningAmount, int money) {
        float lottoProfit = (float) (winningAmount - money) / money * 100 + 100;
        return Math.round(lottoProfit * 100) / 100.0f;
    }

}
