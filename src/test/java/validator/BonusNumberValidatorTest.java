package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {

    @Test
    @DisplayName("보너스 번호가 1 이상 45 이하의 범위일 때 예외가 발생하지 않는다.")
    void 보너스_번호가_허용된_범위_내에_있어_예외가_발생하지_않는다() {
        // given
        int validBonusNumber = 15;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatCode(() -> BonusNumberValidator.validateBonusNumber(validBonusNumber, lottoNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 0 이하일 때 예외가 발생한다.")
    void 보너스_번호가_허용된_범위_미만이어서_예외가_발생한다() {
        // given
        int invalidBonusNumber = 0;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(invalidBonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45 초과일 때 예외가 발생한다.")
    void 보너스_번호가_허용된_범위를_초과해서_예외가_발생한다() {
        // given
        int invalidBonusNumber = 46;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(invalidBonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
