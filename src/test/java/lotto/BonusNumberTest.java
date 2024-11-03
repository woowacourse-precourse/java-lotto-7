package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호 테스트")
class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"십", "abc", "a", " "})
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void 실패_보너스번호입력_숫자가_아님(String input) {
        assertThatThrownBy(() -> BonusNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "50", "-70", "120"})
    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다.")
    void 실패_보너스번호입력_범위초과(String input) {
        assertThatThrownBy(() -> BonusNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("올바른 보너스 번호가 입력되면 객체가 생성된다.")
    void 성공_보너스번호입력_유효한파라미터() {
        // given
        String input = "17";

        // when & then
        assertThatCode(() -> BonusNumber.from(input))
                .doesNotThrowAnyException();
    }
}
