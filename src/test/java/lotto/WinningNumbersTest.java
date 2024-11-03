package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningNumbersTest {

    @Test
    void 당첨_번호의_개수가_맞다면_예외가_발생하지_않는다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new WinningNumbers(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨_번호의_개수가_맞지_않으면_예외가_발생한다(String value) {
        List<Integer> numbers = Arrays.stream(value.split(","))
            .map(Integer::parseInt)
            .toList();

        assertThatThrownBy(() -> new WinningNumbers(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
