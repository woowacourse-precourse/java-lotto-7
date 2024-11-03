package lotto.model;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.WinningType;

public class WinningResult {

    private final EnumMap<WinningType, Integer> countPerWinningType;

    public WinningResult(List<WinningType> winningTypes) {
        countPerWinningType = new EnumMap<>(WinningType.class);

        List<WinningType> allWinningType = List.of(WinningType.values());
        allWinningType.forEach(type -> countPerWinningType.put(type, 0));

        winningTypes.forEach(type -> countPerWinningType.put(type, countPerWinningType.get(type) + 1));
    }

    public EnumMap<WinningType, Integer> getCountPerWinningType() {
        return countPerWinningType.clone();
    }
}
