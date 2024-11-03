package lotto.view.output;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.lotto.winningResult.rank.Rank;

public class Sorter {
    public static List<Rank> sortDescending(List<Rank> ranks) {
        return ranks.stream()
                .sorted(Comparator.comparing(Rank::getRank).reversed())
                .collect(Collectors.toList());
    }

    public static List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
