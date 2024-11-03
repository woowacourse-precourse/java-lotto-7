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
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    @DisplayName("테스트메서드 의도")
    void test() {
        assertThat (numbers.size()).isEqualTo(5);
    }


    @DisplayName("Parameterized Test")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "6:false"}, delimiter = ':')
    void test2(int number, boolean expected) {
        boolean actualValue = numbers.contains(number);
        assertEquals(expected, actualValue);
    }

}
