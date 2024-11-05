package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호가_1이상_45이하가_아니면_IllegalArgumentException_예외가_발생한다(int bonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberValidator.validateRange(bonusNumber));
    }

    @Test
    void 로또_번호의_개수가_6개가_아니면_IllegalArgumentException_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberValidator.validateNumbersRequired(numbers));

    }

    private static Stream<Arguments> generateInvalidateLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 45, 46)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "generateInvalidateLotto")
    void 로또_번호가_1이상_45이하가_아니면_IllegalArgumentException_예외가_발생한다(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberValidator.validateRange(numbers));
    }

    @Test
    void 중복된_숫자가_있으면_IllegalArgumentException_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberValidator.validateDuplicateNumber(numbers));

    }
}
