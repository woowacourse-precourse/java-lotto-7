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

    /**
     * 요구사항 1
     */
    @Test
    @DisplayName("Set의 크기 확인")
    void Set의_크기_확인() {
        assertThat(numbers).size().isEqualTo(3);
    }

    /**
     * 요구사항 2
     */
    @ParameterizedTest
    @DisplayName("Set에 값이 들어갔는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void Set에_값이_들어갔는지_확인(int input) {
        assertTrue(numbers.contains(input));
    }

    /**
     * 요구사항 3
     */
    @ParameterizedTest
    @DisplayName("Set에 값이 들어갔는지 확인 - false 포함")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void Set에_값이_들어갔는지_확인_false포함(Integer input, Boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
