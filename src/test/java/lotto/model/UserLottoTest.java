package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottoTest {
    private UserLotto userLotto;

    @BeforeEach
    void SetUp() {
        userLotto = new UserLotto();
    }

    @Test
    void 사용자_입력이_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> userLotto.setNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 입력이 비어있습니다.");

        assertThatThrownBy(() -> userLotto.setBonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 입력이 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,s", "1,2,3,4,5,-", "1,2,3,4,5,6.5" })
    void 정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> userLotto.setNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호를 숫자로 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "46", "-1" })
    void 보너스_번호가_범위를_넘으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> userLotto.setBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 1~45사이 정수로 입력해 주세요.");
    }
}
