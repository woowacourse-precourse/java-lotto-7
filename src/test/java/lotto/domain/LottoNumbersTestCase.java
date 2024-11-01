package lotto.domain;

import java.util.List;
import lotto.global.common.Rank;

public enum LottoNumbersTestCase {
    FIRST(Rank.FIRST, List.of(1, 2, 3, 4, 5, 6), 44),
    SECOND(Rank.SECOND, List.of(1, 2, 3, 4, 5, 8), 7),
    THIRD(Rank.THIRD, List.of(1, 2, 3, 4, 5, 8), 44),
    FOURTH(Rank.FOURTH, List.of(1, 2, 3, 4, 9, 8), 44),
    FIFTH(Rank.FIFTH, List.of(1, 2, 3, 10, 9, 8), 44),
    NONE(Rank.NONE, List.of(1, 2, 11, 10, 9, 8), 44);

    public final Rank rank;
    public final List<Integer> numbers;
    public final int bonus;

    LottoNumbersTestCase(Rank rank, List<Integer> numbers, int bonus) {
        this.rank = rank;
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
