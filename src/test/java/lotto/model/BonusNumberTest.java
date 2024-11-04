package lotto.model;

import lotto.model.lotto.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import view.exception.LottoException;
import view.validation.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호는 정수가 입력되어야 한다")
    @ValueSource(strings = {"aa", ",,"})
    @NullAndEmptySource
    public void 보너스번호_형식_테스트(String bonusNumber) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호는 1~45 사이의 숫자이어야 한다")
    @ValueSource(ints = {-1, 46})
    public void 보너스번호_범위_테스트(int bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(LottoException.class);
    }
}
