package lotto.view.output;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.winningResult.WinningRank;

public class Utils {
    public static List<WinningRank> sortDescending(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .sorted(Comparator.comparing(WinningRank::getRank).reversed())
                .collect(Collectors.toList());
    }

    public static List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
