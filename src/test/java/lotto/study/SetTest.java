package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
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
    void Set의_사이즈를_반환한다() {

        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Set에_값이_존재하는지_알_수_있다(int provided) {

        assertThat(numbers).contains(provided);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=true", "4,5=false"}, delimiter = '=')
    void Set에_값의_유무를_알_수_있다(String provided, boolean expected) {
        List<Integer> integers = parseIntegers(provided);
        assertThat(numbers.containsAll(integers)).isEqualTo(expected);
    }

    private List<Integer> parseIntegers(String provided) {
        String[] split = provided.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
