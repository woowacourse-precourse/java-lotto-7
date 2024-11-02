package lotto.study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsTest {

    @Test
    @DisplayName("범위 내의 중복되지 않는 랜덤 숫자를 지정된 개수만큼 반환한다")
    void pickUniqueNumbersBasicTest() {
        // given
        int min = 1;
        int max = 45;
        int count = 6;

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);

        assertThat(numbers).hasSize(count);
        assertThat(numbers).allMatch(n -> n >= min && n <= max);
        assertThat(new HashSet<>(numbers)).hasSize(count); // 중복 검사
    }

    @Test
    @DisplayName("최소값과 최대값이 같으면 해당 숫자 하나만 반환한다")
    void pickUniqueNumbersWithSameMinMax() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(5, 5, 1);

        assertThat(numbers).containsExactly(5);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 10, 5",
        "1, 45, 6",
        "-10, 10, 8",
        "0, 99, 10"
    })
    @DisplayName("다양한 범위와 개수에 대해 정상 동작한다")
    void pickUniqueNumbersWithVariousRanges(int min, int max, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);

        assertThat(numbers).hasSize(count);
        assertThat(numbers).allMatch(n -> n >= min && n <= max);
        assertThat(new HashSet<>(numbers)).hasSize(count);
    }

    @Test
    @DisplayName("요청한 개수가 범위보다 크면 IllegalArgumentException이 발생한다")
    void throwsExceptionWhenCountExceedsRange() {
        int min = 1;
        int max = 3;
        int count = 5;

        assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(min, max, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최소값이 최대값보다 크면 IllegalArgumentException이 발생한다")
    void throwsExceptionWhenMinGreaterThanMax() {
        int min = 10;
        int max = 1;
        int count = 5;

        assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(min, max, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5})
    @DisplayName("요청한 개수가 음수이면 IllegalArgumentException이 발생한다")
    void throwsExceptionWhenCountIsZeroOrNegative(int count) {
        assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(1, 45, count))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
