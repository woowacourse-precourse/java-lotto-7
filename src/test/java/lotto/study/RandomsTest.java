package lotto.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsTest {
    @Test
    @DisplayName("pickNumberInRange는 지정된 범위 내의 난수를 생성한다")
    void pickNumberInRangeShouldGenerateNumberWithinRange() {
        int MIN_RANGE = -10;
        int MAX_RANGE = 10;
        for (int i = 0; i < 100; i++) {
            int number = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE)
                .isLessThanOrEqualTo(MAX_RANGE);
        }
    }

    @Test
    @DisplayName("pickNumberInRange는 최솟값과 최댓값을 포함한다")
    void pickNumberInRangeShouldIncludeMaxOrMinNumber() {
        int MIN_RANGE = 0;
        int MAX_RANGE = 1;
        for (int i = 0; i < 10; i++) {
            int number = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE)
                .isLessThanOrEqualTo(MAX_RANGE);
        }
    }

    @Test
    @DisplayName("pickNumberInRange는 최솟값과 최댓값을 같아도 작동한다")
    void pickNumberInRangeShouldWorkEqualMaxAndMinNumber() {
        int MIN_RANGE = 0;
        int MAX_RANGE = 0;
        int number = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        assertThat(number).isEqualTo(0);
    }

    @Test
    @DisplayName("pickNumberInRange는 범위 지정이 잘못되면 예외가 발생한다")
    void pickNumberInRangeShouldExcpetWrongRange() {
        int MIN_RANGE = 100;
        int MAX_RANGE = 0;
        assertThatThrownBy(() -> Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
