package lotto;

import java.util.List;
import lotto.global.common.Rank;

public enum LottoNumbersTestCase {
    FIRST(Rank.FIRST, List.of(1, 2, 3, 4, 5, 6)),
    SECOND(Rank.SECOND, List.of(1, 2, 3, 4, 5, 7)),
    THIRD(Rank.THIRD, List.of(1, 2, 3, 4, 5, 8)),
    FOURTH(Rank.FOURTH, List.of(1, 2, 3, 4, 9, 8)),
    FIFTH(Rank.FIFTH, List.of(1, 2, 3, 10, 9, 8)),
    NONE(Rank.NONE, List.of(1, 2, 11, 10, 9, 8));

    public final Rank rank;
    public final List<Integer> numbers;

    LottoNumbersTestCase(Rank rank, List<Integer> numbers) {
        this.rank = rank;
        this.numbers = numbers;
    }
}
