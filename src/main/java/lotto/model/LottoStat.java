package lotto.model;

import java.util.List;

public record LottoStat(
    List<String> carNames,
    List<Integer> progresses
) {
    public static LottoStat map(
        List<String> carNames,
        List<Integer> progresses
    ) {
        return new LottoStat(
            carNames,
            progresses
        );
    }
}
