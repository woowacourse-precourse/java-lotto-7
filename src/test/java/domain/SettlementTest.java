package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SettlementTest {

    @Test
    void 로또_수익률_반환_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Settlement settlement = new Settlement(Buyer.buyLotto(3000), List.of(8, 21, 23, 41, 42, 43), 11);
                    assertThat(settlement.getProfitRate()).isEqualTo(66666666.7);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 로또_상세_내역_반환_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Settlement settlement = new Settlement(Buyer.buyLotto(3000), List.of(8, 21, 23, 41, 42, 43), 11);
                    assertThat(settlement.getWinningDetails().get(Rank.FIRST_PLACE)).isEqualTo(1);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

}