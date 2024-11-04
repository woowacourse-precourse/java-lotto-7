package validator;

import static org.assertj.core.api.Assertions.assertThatCode;

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

        // when & then
        assertThatCode(() -> BonusNumberValidator.validateBonusNumber(validBonusNumber, lottoNumbers))
                .doesNotThrowAnyException();
    }
}
