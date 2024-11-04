package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.util.RandomNumberUtils.setAscendingNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberUtilsTest {
    @Test
    @DisplayName("6개의 임의의 수 오름차순 정렬")
    void 여섯개의_임의의_수_오름차순_정렬() {
        //given
        List<Integer> numbers = Arrays.asList(42, 13, 9, 4, 35, 11);

        //when
        setAscendingNumbers(numbers);

        //then
        assertThat(numbers).isEqualTo(Arrays.asList(4, 9, 11, 13, 35, 42));
        assertThat(numbers).containsExactly(4, 9, 11, 13, 35, 42);
    }
}