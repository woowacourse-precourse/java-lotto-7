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
        // given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size_메소드를_활용해_Set의_크기를_확인")
    void size_메소드를_활용해_Set의_크기를_확인() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains_메소드와 ParameterizedTest와_ValueSource를_활용해_값이_존재하는지_확인")
    void contains_메소드를_활용해_값이_존재하는지_확인(int input) {
        // when
        boolean isNumberExist = numbers.contains(input);

        // then
        assertThat(isNumberExist).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("contains_메소드와_ParameterizedTest와_CsvSource를_활용해_값이_존재하는지_확인")
    void contains_메소드와_ParameterizedTest와_CsvSource를_활용해_값이_존재하는지_확인(int input, boolean isContain) {
        // when
        boolean isNumberExit = numbers.contains(input);

        // then
        assertThat(isNumberExit).isEqualTo(isContain);
    }

}