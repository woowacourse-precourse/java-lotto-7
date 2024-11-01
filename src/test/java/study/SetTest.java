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

    @Test
    @DisplayName("Set의 size 메서드를 통해 Set의 크기를 확인한다.")
    void shouldGetSizeOfSet() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains 메서드를 통해 값이 존재하는지 확인하다.")
    @ValueSource(ints = {1, 2, 3})
    void shouldReturnTrueIfSetContainsValue(int testNumber) {
        assertThat(numbers.contains(testNumber)).isTrue();
        org.junit.jupiter.api.Assertions.assertTrue(numbers.contains(testNumber));
    }

    @ParameterizedTest
    @DisplayName("Set의 contains 메서드를 통해 값이 존재하는지 확인하다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void shouldReturnTrueOrFalseIfSetContainsValueOrNot(int testNumber, boolean expected) {
        assertThat(numbers.contains(testNumber)).isEqualTo(expected);
    }
}
