package lotto.model.validator;

import lotto.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberRangeValidatorTest {

    @Test
    @DisplayName("리스트 숫자 요소 범위 예외 발생 테스트")
    void testOutOfRangeListThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                NumberRangeValidator.validateNumberRange(numbers));

        assertEquals(Exception.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("리스트 숫자 요소 범위 정상 동작 테스트")
    void testInRangeListNoException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 44);

        NumberRangeValidator.validateNumberRange(numbers);
    }

    @Test
    @DisplayName("단일 숫자 범위 예외 발생 테스트")
    void testOutOfRangeSingleNumberThrowsException() {
        int outOfRangeNumber = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                NumberRangeValidator.validateNumberRange(outOfRangeNumber));

        assertEquals(Exception.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("단일 숫자 범위 정상 동작 테스트")
    void testInRangeSingleNumberNoException() {
        int inRangeNumber = 30;

        NumberRangeValidator.validateNumberRange(inRangeNumber);
    }
}
