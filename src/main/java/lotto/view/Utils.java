package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.WinningRank;

public class Utils {
    public static List<WinningRank> sortDescending(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .sorted(Comparator.comparing(WinningRank::getRank).reversed())
                .collect(Collectors.toList());
    }
}
