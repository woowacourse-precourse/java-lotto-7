package study;

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

    @Test
    @DisplayName("set에는 중복된 값을 저장할 수 없다.")
    void set은_중복_저장_x() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @DisplayName("input 여러 개 테스트")
    @ValueSource(ints = {1, 2, 3})
    void 값_존재_확인(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("input 에 따라 expected 값이 다르게 나오는 여러 개 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void 여러개_값_존재_확인(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }

}
