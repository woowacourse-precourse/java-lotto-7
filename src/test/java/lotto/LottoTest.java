package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoExceptionType;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력이 비었으면 예외가 발생한다")
    @ValueSource(strings = {"", " "})
    void exception_empty_input_winning_number(String winningNumber) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.EMPTY_INPUT_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("쉼표(,)로 구분한 숫자가 6개가 아니면 예외가 발생한다")
    void exception_wrong_format_winning_number() {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.WRONG_FORMAT_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아니면 예외가 발생한다")
    void exception_out_of_range_winning_number() {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.OUT_OF_RANGE_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("숫자가 중복되면 예외가 발생한다")
    void exception_duplicated_winning_number() {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.DUPLICATED_WINNING_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("쉼표(,) 사이에 숫자가 없으면 예외가 발생한다")
    @ValueSource(strings = {",", ",2,3,,9,15,22,45,"})
    void exception_empty_input_between_comma_winning_number(String winningNumber) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_INTEGER_WINNING_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력이 정수가 아니면 예외가 발생한다")
    @ValueSource(strings = {"1.0, 2.0, 3.0, 4.0, 5.0, 6.0", " 일,이,삼,사,오,육", "1,2,3,4,5,6번", "1 2 3 4 5 6"})
    void exception_not_integer_winning_number(String winningNumber) {
        assertThatThrownBy(() -> lottoService.checkAndConvertInputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_INTEGER_WINNING_NUMBER.getMessage());
    }
}
