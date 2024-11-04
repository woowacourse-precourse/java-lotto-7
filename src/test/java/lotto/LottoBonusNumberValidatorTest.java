package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.InputNumberException;
import lotto.validator.LottoBonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberValidatorTest {

    @DisplayName("보너스 번호가 비어있을 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_비어있을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.EMPTY_INPUT.getMessage());
    }

    @DisplayName("보너스 번호가 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_정수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("abc", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_FORMAT.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("46", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.INVALID_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoBonusNumberValidator.validateAndParse("3", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputNumberException.DUPLICATE_NUMBER_WITH_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("유효한 보너스 번호가 입력될 경우 검증에 통과한다.")
    @Test
    void 유효한_보너스_번호가_입력될_경우_검증에_통과한다() {
        int validBonusNumber = LottoBonusNumberValidator.validateAndParse("7", List.of(1, 2, 3, 4, 5, 6));
        assertThat(validBonusNumber).isEqualTo(7);
    }
}