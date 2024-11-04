package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningBonusNumberValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", " ", "1,2,3,4,5,46", "0,1,2,3,4,5", "1,2,3,4,5,q", "1,2,3,4,5,5"})
    @DisplayName("당첨 번호 입력 검증 확인하기")
    public void 당첨_번호_실패_테스트(String winningNumber) {
        assertThatThrownBy(() -> WinningBonusNumberValidation.getValidatedWinningNumbers(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "6", "0", "46"})
    @DisplayName("보너스 번호 입력 검증 확인하기")
    public void 보너스_번호_실패_테스트(String winningBonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> WinningBonusNumberValidation.getValidatedBonusNumber(lotto, winningBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}