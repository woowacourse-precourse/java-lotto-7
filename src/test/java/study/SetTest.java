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
    @DisplayName("Set의 크기 확인")
    public void checkSetSize() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("값 contain 확인")
    public void checkValueContain(int value) {
        assertThat(numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
    @DisplayName("값 contain 확인 - true, false 같이 확인")
    public void checkValueContain2(int value, boolean result) {
        assertThat(numbers.contains(value))
                .isEqualTo(result);
    }
}
