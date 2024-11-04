package lotto;

import lotto.model.Lotteries;
import lotto.model.Yield;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class YieldTest {
    @DisplayName("수익률이 정상적으로 계산되는지 확인한다.")
    @Test
    void 수익률이_정상적으로_계산되는지_확인한다() {
        assertSimpleTest(() -> {
            Yield yield = new Yield(8000);
            yield.addReward(5000);
            assertThat(yield.calculateRatio()).isEqualTo(62.5);
        });
    }
}
