package lotto.model.validator;

import lotto.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoValidatorTest {

    @Test
    @DisplayName("로또 번호 크기 예외 발생 테스트")
    void testInvalidSizeThrowsException() {
        List<Integer> invalidSizeLotto = List.of(1, 2, 3, 4, 5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                LottoValidator.validateLotto(invalidSizeLotto));

        assertEquals(Exception.INVALID_LOTTO_NUMBERS_SIZE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호 중복 예외 발생 테스트")
    void testDuplicateNumbersThrowsException() {
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                LottoValidator.validateLotto(duplicateLottoNumbers));

        assertEquals(Exception.DUPLICATE_WINNING_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호 유효성 검사 통과 테스트")
    void testValidLottoNumbersNoException() {
        List<Integer> validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        LottoValidator.validateLotto(validLottoNumbers);
    }

    @Test
    @DisplayName("로또 번호 범위 예외 발생 테스트")
    void testOutOfRangeNumberThrowsException() {
        List<Integer> outOfRangeLotto = List.of(1, 2, 3, 4, 5, 46);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                LottoValidator.validateLotto(outOfRangeLotto));

        assertEquals(Exception.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());
    }
}
