package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CommonValidatorTest {

    @Test
    void 입력값이_공백일_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.validateNotBlank(" ", "입력값은 공백일 수 없습니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 공백일 수 없습니다.");
    }

    @Test
    void 입력값이_공백이_아닐_경우_예외가_발생하지_않아야_한다() {
        assertDoesNotThrow(() ->
                CommonValidator.validateNotBlank("유효한 입력값", "입력값은 공백일 수 없습니다.")
        );
    }

    @Test
    void 유효한_숫자_문자열을_Long으로_변환할_수_있다() {
        Long result = CommonValidator.parseLong("12345", "잘못된 숫자 형식입니다.");
        assertEquals(12345L, result);
    }

    @Test
    void 유효하지_않은_숫자_문자열을_Long으로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.parseLong("abc", "잘못된 숫자 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다.");
    }

    @Test
    void 공백_문자열을_Long으로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.parseLong(" ", "잘못된 숫자 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다.");
    }

    @Test
    void 유효한_문자열을_Integer로_변환할_수_있다() {
        Integer result = CommonValidator.parseInteger("123", "잘못된 정수 형식입니다.");
        assertEquals(123, result);
    }

    @Test
    void 유효하지_않은_문자열을_Integer로_변환하면_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.parseInteger("abc", "잘못된 정수 형식입니다.")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 정수 형식입니다.");
    }

    @Test
    void 숫자_목록의_크기가_기대한_크기가_아닐_경우_예외가_발생해야_한다() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThatThrownBy(() ->
                CommonValidator.validateSize(numbers, 6)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 숫자_목록에_중복이_있는_경우_예외가_발생해야_한다() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);
        assertThatThrownBy(() ->
                CommonValidator.validateNoDuplicates(numbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    void 숫자_목록에_범위를_벗어난_숫자가_있을_경우_예외가_발생해야_한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 50);
        assertThatThrownBy(() ->
                CommonValidator.validateNumberRange(numbers, 1, 45)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 금액이_양수가_아닐_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.validatePositiveAmount(-100L)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수여야 합니다.");
    }

    @Test
    void 금액이_지정된_단위의_배수가_아닌_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                CommonValidator.validateMultipleOf(1500L, 1000)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }
}
