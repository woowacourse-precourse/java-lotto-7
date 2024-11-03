package lotto.view.output;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.winnerRank.WinnerRank;

public class Sorter {
    public static List<WinnerRank> sortDescending(List<WinnerRank> winnerRanks) {
        return winnerRanks.stream()
                .sorted(Comparator.comparing(WinnerRank::getRank).reversed())
                .collect(Collectors.toList());
    }

    public static List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
