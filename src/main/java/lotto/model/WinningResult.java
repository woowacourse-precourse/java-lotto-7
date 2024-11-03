package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import lotto.constant.WinningType;

public class WinningResult {

    public static final String NULL_WINNING_TYPES_EXCEPTION_MESSAGE = "null인 winningTypes는 허용하지 않습니다.";

    private final EnumMap<WinningType, Integer> countPerWinningType;

    public WinningResult(List<WinningType> winningTypes) {
        validateNull(winningTypes);

        countPerWinningType = new EnumMap<>(WinningType.class);
        List<WinningType> allWinningType = List.of(WinningType.values());
        allWinningType.forEach(type -> countPerWinningType.put(type, 0));

        winningTypes.forEach(type -> countPerWinningType.put(type, countPerWinningType.get(type) + 1));
    }

    private void validateNull(List<WinningType> winningTypes) {
        if (Objects.isNull(winningTypes)) {
            throw new IllegalArgumentException(NULL_WINNING_TYPES_EXCEPTION_MESSAGE);
        }
    }

    public EnumMap<WinningType, Integer> getCountPerWinningType() {
        return countPerWinningType.clone();
    }
}
