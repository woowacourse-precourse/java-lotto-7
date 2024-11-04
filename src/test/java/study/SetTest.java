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

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // 중복 요소 추가 시도
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 사용하여 Set의 크기를 확인하는 테스트")
    @Test
    void set_사이즈_측정_테스트() {
        assertThat(numbers.size()).isEqualTo(3); // 중복된 1은 한 번만 저장됨
    }

    @DisplayName("Set의 contains() 메소드를 사용하여 특정 값이 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 특정_값이_존재하는지_테스트(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 사용하여 특정 값이 존재하지 않는 경우를 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void 특정_값이_존재하지_않는지_테스트(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
