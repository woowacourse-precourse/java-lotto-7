package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    @DisplayName("당첨 숫자 여섯 개 입력 체크")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5", "1,2,3,4,5,6,7" })
    void 여섯_개의_숫자를_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new LottoService().splitSixNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 보너스 숫자 입력 체크")
    @ParameterizedTest
    @ValueSource(strings = { "0", "46", "a" })
    void 올바른_보너스_숫자를_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new LottoService().getBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
