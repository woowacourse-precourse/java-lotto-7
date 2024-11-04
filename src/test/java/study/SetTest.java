package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 크기를 확인한다.")
    @Test
    void set_테스트_1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 1,2,3이 포함되어 있는 지 확인한다.")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    void set_테스트_2(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("Set에 1,2,3이 포함되어 있고, 4,5는 포함되어 있지 않은 지 확인한다.")
    @ParameterizedTest()
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void set_테스트_3(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }

}
