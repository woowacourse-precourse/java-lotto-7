package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈를 반환 한다.")
    void setTest1() {
        //given
        final int size = 3;

        //should
        assertThat(numbers).hasSize(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 요소를 확인 한다.")
    void setTest2(final int number) {
        //should
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("요소가 포함 미포함 경우를 함께 테스트 한다.")
    void setTest3(final int number, final boolean result) {
        //should
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
