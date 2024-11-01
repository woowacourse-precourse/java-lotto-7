package lotto.common.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsWrapperTest {
    @Test
    @DisplayName("RandomsWrapper.getInt는 1~45내 숫자를 반환한다")
    void getIntShouldReturnIntInRange() {
        int MIN_RANGE = 1;
        int MAX_RANGE = 45;

        for (int i = 0; i < 1000; i++) {
            int number = RandomsWrapper.getInt();
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE)
                .isLessThanOrEqualTo(MAX_RANGE);
        }
    }
}
