package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("Set의 크기를 확인하는 테스트")
    @Test
    void size() {
        assertEquals(3, numbers.size());
    }

    @DisplayName("Set의 contains 메소드를 활용한 값 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_param(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains 메소드를 활용한 값 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void contains_param_false(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }
}
