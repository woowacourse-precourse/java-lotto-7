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

    @DisplayName("Set Collection 사용시 중복이 제거된 size가 반환된다")
    @Test
    void Set_Collection_사용시_중복이_제거된_size가_반환된다() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("contains 메소드는 값의 존재 여부를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_메소드는_값의_존재_여부를_반환한다(int input) {
        // when then
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("contains 메소드는 존재할 경우 true 없을 경우 false를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_메소드는_존재할_경우_true_없을_경우_false를_반환한다(int input, boolean expected) {
        // when then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
