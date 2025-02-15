package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @DisplayName("입력이 비어 있으면 예외가 발생한다.")
    @Test
    void 입력이_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkNumber("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkUnit(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkUnit(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkSizeWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkDuplicateWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkRangeWinningNumbers(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.checkRangeBonusNumber(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
