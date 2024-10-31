package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoValidatorTest {

    @DisplayName("로또 번호 개수가 6개가 아닐 때 예외 발생")
    @Test
    void validateLottoNumberCount_WhenCountIsNotSix_ShouldThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidator.validateLottoNumberCount(List.of(1, 2, 3, 4, 5)))
                .withMessage(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidator.validateLottoNumberCount(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessage(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
    }

    @DisplayName("로또 번호 개수가 정확히 6개일 때 예외 발생하지 않음")
    @Test
    void validateLottoNumberCount_WhenCountIsSix_ShouldNotThrowException() {
        assertThatNoException().isThrownBy(() -> LottoValidator.validateLottoNumberCount(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 범위를 벗어날 때 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "0,1,2,3,4,5",    // 0이 범위에서 벗어남
            "1,2,3,4,5,46"    // 46이 범위에서 벗어남
    })
    void validateLottoNumberRange_WhenNumberOutOfRange_ShouldThrowException(String num1, String num2, String num3,
                                                                            String num4, String num5, String num6) {
        List<Integer> numbers = List.of(Integer.parseInt(num1), Integer.parseInt(num2), Integer.parseInt(num3),
                Integer.parseInt(num4), Integer.parseInt(num5), Integer.parseInt(num6));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidator.validateLottoNumberRange(numbers))
                .withMessage(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID.getMessage());
    }

    @DisplayName("로또 번호가 범위 내에 있을 때 예외 발생하지 않음")
    @Test
    void validateLottoNumberRange_WhenAllNumbersInRange_ShouldNotThrowException() {
        assertThatNoException().isThrownBy(() -> LottoValidator.validateLottoNumberRange(List.of(1, 2, 3, 4, 5, 45)));
    }

    @DisplayName("로또 번호에 중복이 있을 때 예외 발생")
    @Test
    void validateNoDuplicates_WhenDuplicatesExist_ShouldThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidator.validateNoDuplicates(List.of(1, 2, 3, 4, 5, 5)))
                .withMessage(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
    }

    @DisplayName("로또 번호에 중복이 없을 때 예외 발생하지 않음")
    @Test
    void validateNoDuplicates_WhenNoDuplicates_ShouldNotThrowException() {
        assertThatNoException().isThrownBy(() -> LottoValidator.validateNoDuplicates(List.of(1, 2, 3, 4, 5, 6)));
    }

}
