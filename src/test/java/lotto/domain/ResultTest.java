package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.constant.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    @DisplayName("등수를 정확히 증가")
    void checkRankExactly() {
        result.addPrize(Prize.FIRST);
        result.addPrize(Prize.FIRST);
        result.addPrize(Prize.SECOND);

        assertThat(result.getPrizeResult().get(Prize.FIRST)).isEqualTo(2);
        assertThat(result.getPrizeResult().get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.getPrizeResult().get(Prize.THIRD)).isEqualTo(0);
    }

    @Test
    @DisplayName("등수에 따라 총 수익을 정확히 계산")
    void checkPrizeExactly() {
        result.addPrize(Prize.FIRST);
        result.addPrize(Prize.SECOND);

        long totalPrize = result.getTotalPrize();
        long expectedPrize = Prize.FIRST.getMoney() + Prize.SECOND.getMoney();

        assertThat(totalPrize).isEqualTo(expectedPrize);
    }
}