package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Set_크기_테스트")
    void Set_크기_테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    /*@Test
    @DisplayName("Set의_값을_확인하는_테스트")
    void Set의_값을_확인하는_테스트() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }*/

    @DisplayName("Set의_값을_확인하는_테스트_1")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void Set의_값을_확인하는_테스트(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의_값을_확인하는_테스트_2")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void Set의_값을_확인하는_테스트_2(int input, boolean excepted) {
        boolean actualValue = numbers.contains(input);
        assertEquals(excepted, actualValue);
    }
}
