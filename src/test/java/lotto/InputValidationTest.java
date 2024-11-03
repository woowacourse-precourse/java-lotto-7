package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.io.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidationTest {
    @DisplayName("로또 구입은 1000원 단위로 구입하지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입은_1000원_단위로_구입하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validatePrice("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers("1,2,3,4,5,55"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 잘못되면 예외가 발생한다.")
    @Test
    void 당첨_번호_입력이_잘못되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateBonusNumber("46", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateBonusNumber("6", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
