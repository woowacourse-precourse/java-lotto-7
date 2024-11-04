package lotto;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputFormatter {
    public String lotto(Lotto lotto) {
        String purchaseLotto =
                lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return String.format("[" + purchaseLotto + "]");
    }

    public String result(Map<WinningStandard, Integer> winningResult, WinningStandard place) {
        int count = winningResult.get(place);
        String bonus = "";
        if(place.isMatchingBonusNumber()) {
            bonus = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%s원) - %d개", place.getMatchingNumber(), bonus, place.getPrizeForPrint(), count);
    }

    public String earningsRate(double earningsRate) {
        return String.format("총 수익률은 %.2f%%입니다", earningsRate);
    }
}
