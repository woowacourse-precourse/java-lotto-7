package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class WinningNumberCheckService {
    public static LottoResult checkWinningNumber(Lotto randomLotto, Lotto winningNumber, int bonusNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        long matchCount = randomLotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean hasBonus = randomLotto.getNumbers().stream().anyMatch(number -> number == bonusNumber);
        return new LottoResult(matchCount, hasBonus);
    }

    public static Map<String, Integer> calculateStatistics(List<LottoResult> lottoResult) {
        Map<String, Integer> statistics = lottoResult.stream()
                .collect(Collectors.groupingBy(result ->{
                    if (result.getMatchCount() == 3) return "3개";
                    if (result.getMatchCount() == 4) return "4개";
                    if (result.getMatchCount() == 5 && result.getHasBonus()) return "5개+보너스";
                    if (result.getMatchCount() == 5) return "5개";
                    if (result.getMatchCount() == 6) return "6개";
                    return "기타";
                }, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        statistics.putIfAbsent("3개", 0);
        statistics.putIfAbsent("4개", 0);
        statistics.putIfAbsent("5개", 0);
        statistics.putIfAbsent("5개+보너스", 0);
        statistics.putIfAbsent("6개", 0);

        return statistics;
    }
}
