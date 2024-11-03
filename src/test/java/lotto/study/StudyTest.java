package lotto.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {

    @DisplayName("sort(null) 학습 테스트")
    @Test
    void test1() {
        List<Integer> numbers = Arrays.asList(2, 4, 6 ,5, 3, 1);

        numbers.sort(null);

        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
