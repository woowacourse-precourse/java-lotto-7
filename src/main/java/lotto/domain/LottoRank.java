package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoRank {
    FIRST(6), SECOND(5), THIRD(5), FOURTH(4), FIFTH(3), NONE(-1);

    public final int matches;

    LottoRank(int matches) {
        this.matches = matches;
    }

    public static List<LottoRank> reverseValues() {
        return Arrays.stream(values())
                .sorted(Collections.reverseOrder())
                .toList();
    }
}
