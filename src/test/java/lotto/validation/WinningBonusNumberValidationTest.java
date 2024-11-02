package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.view.WinningBonusNumberView;
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
}