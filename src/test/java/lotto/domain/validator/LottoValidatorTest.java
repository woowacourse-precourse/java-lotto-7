package lotto.domain.validator;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new LottoValidator();
    }

    @Test
    @DisplayName("정상적인 입력값은 검증을 통과한다")
    void validateShouldPassWithValidInput() {
        String input = "1";

        assertThatCode(() -> validator.validate(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("공백과 정수 검증하여 예외를 발생시킨다")
    void LottoValidatorShouldBeValidOnBlankAndNumber() {
        String input_blank = " ";
        String input_String = "abc";

        assertThatThrownBy(() -> validator.validate(input_blank))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(BLANK_NOT_ALLOWED.toString());
        assertThatThrownBy(() -> validator.validate(input_String))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_WHOLE_NUMBER.toString());
    }

    @Test
    @DisplayName("로또 번호 길이 검증하여 예외를 발생시킨다")
    void LottoValidatorShouldBeValidOnLength() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertThatThrownBy(() -> validator.validate(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 중복 검증하여 예외를 발생시킨다")
    void LottoValidatorShouldBeValidOnDuplicate() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        assertThatThrownBy(() -> validator.validate(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어났을 경우 예외를 발생시킨다")
    void LottoValidatorShouldBeValidOnRange() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 65));

        assertThatThrownBy(() -> validator.validate(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}