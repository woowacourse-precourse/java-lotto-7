package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PrizeFormatterTest {
    @Test
    void 포맷팅_테스트() {
        assertSimpleTest(() -> {
            assertThat(PrizeFormatter.formatPrize(2000000000)).isEqualTo("2,000,000,000");
        });
    }

}