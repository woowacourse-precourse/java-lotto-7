package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // 중복된 요소는 추가되지 않음
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메서드를 사용해 크기를 확인하는 테스트")
    void 해시맵_사이즈_확인() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메서드를 사용해 값이 존재하는지 확인")
    void set_contains_값_확인하는_테스트(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    @DisplayName("Set의 contains() 값의 존재 여부에 따라 true 또는 false를 반환하는지 테스트")
    void contains_값의_존재_여부_boolean_반환(int value, boolean expected) {
        // when
        boolean result = numbers.contains(value);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
