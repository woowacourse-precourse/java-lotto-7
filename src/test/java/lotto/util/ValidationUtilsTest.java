package lotto.util;

import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {
    @Test
    void 입력값이_공백일_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                ValidationUtils.validateNotBlank(" ", "입력값은 공백일 수 없습니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 공백일 수 없습니다.");
    }

    @Test
    void 입력값이_공백이_아닐_경우_예외가_발생하지_않아야_한다() {
        assertDoesNotThrow(() ->
                ValidationUtils.validateNotBlank("유효한 입력값", "입력값은 공백일 수 없습니다.")
        );
    }

    @Test
    void 유효한_숫자_문자열을_정수로_변환할_수_있다() {
        Long result = ValidationUtils.parseLong("12345", "잘못된 숫자 형식입니다.");
        assertEquals(12345L, result);
    }

    @Test
    void 유효하지_않은_숫자_문자열을_정수로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                ValidationUtils.parseLong("abc", "잘못된 숫자 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다.");
    }

    @Test
    void 공백_문자열을_정수로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                ValidationUtils.parseLong(" ", "잘못된 숫자 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다.");
    }

    @Test
    void 유효한_문자열을_정수로_변환할_수_있다() {
        Integer result = ValidationUtils.parseInteger("123", "잘못된 정수 형식입니다.");
        assertEquals(123, result);
    }

    @Test
    void 유효하지_않은_문자열을_정수로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                ValidationUtils.parseInteger("abc", "잘못된 정수 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 정수 형식입니다.");
    }
}