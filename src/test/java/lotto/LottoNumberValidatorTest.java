package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import lotto.exception.InputNumberException;
import lotto.validator.LottoNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

    @DisplayName("로또 번호 입력이 비어있을 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력이_비어있을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.EMPTY_INPUT.getMessage());
    }

    @DisplayName("로또 번호 입력이 쉼표로 끝날 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력이_쉼표로_끝날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.ENDS_WITH_COMMA.getMessage());
    }

    @DisplayName("로또 번호 입력이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력이_정수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse("1,2,3,a,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_FORMAT.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_LENGTH.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.DUPLICATE_NUMBERS.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoNumberValidator.validateAndParse("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_RANGE.getMessage());
    }

    @DisplayName("유효한 당첨 번호가 입력될 경우 검증에 통과한다.")
    @Test
    void 유효한_당첨_번호가_입력될_경우_검증에_통과한다() {
        List<Integer> winningNumbers = LottoNumberValidator.validateAndParse("1,2,3,4,5,6");
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}