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
    @DisplayName("set의 크기는 3이어야한다.")
    void checkSetSize() {
        // when, then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("set에 1,2,3이 존재해야한다.")
    void setContains() {
        // when, then
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set에 1,2,3이 존재해야한다 - Parameterized test 사용")
    void setContainsUsingParameterizedTest(int value) {
        // when, then
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("set에 1,2,3은 존재하고, 4,5는 존재하지 않아야 한다.")
    void setContainsUsingCsvSource(int input, boolean expected) {
        // when, then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("교집합이 있는 경우 retainAll로 교집합 구하기")
    void testRetainAllWhenIntersected() {
        // given
        HashSet<Integer> anotherNumbers1 = new HashSet<>(Set.of(1, 2));

        // when
        boolean isRetained = numbers.retainAll(anotherNumbers1);

        // then
        assertThat(isRetained).isTrue();
        assertThat(numbers).containsExactly(1, 2);
    }

    @Test
    @DisplayName("교집합이 없는 경우 retainAll로 교집합 구하기")
    void retainAllWhenNotIntersected() {
        // given
        HashSet<Integer> anotherNumbers = new HashSet<>(Set.of(4));

        // when
        boolean isRetained = numbers.retainAll(anotherNumbers);

        // then
        assertThat(isRetained).isTrue();
        assertThat(numbers).isEmpty();
    }

}
