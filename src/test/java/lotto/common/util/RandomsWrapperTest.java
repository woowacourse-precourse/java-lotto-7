package lotto.common.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomsWrapperTest {

    @RepeatedTest(10)
    @DisplayName("1~45 내 중복되지 않는 무작위 숫자 6개를 반환한다")
    void getIntShouldReturnIntInRange() {
        int MIN_RANGE = 1;
        int MAX_RANGE = 45;
        long LENGTH = 6L;

        List<Integer> numbers = RandomsWrapper.getInt();
        Long size = numbers.stream().distinct().count();
        assertThat(size).isEqualTo(LENGTH);
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE)
                .isLessThanOrEqualTo(MAX_RANGE);
        }
    }
}
