package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호의 숫자 범위는 1~45이다.")
    @Test
    void 보너스_번호의_숫자_범위는_일에서_사십오_사이이다() {
        BonusNumber.from("1");
        BonusNumber.from("45");
    }

    @DisplayName("보너스 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_일_미만일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_사십오를_초과할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호에_문자가_입력될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("\t"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> BonusNumber.from("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호에 아무것도 입력되지 않는 경우 예외가 발생한다")
    @Test
    void 보너스_번호에_아무것도_입력되지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 null일 경우 예외가 발생한다")
    @Test
    void 보너스_번호가_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("3");

        assertThatThrownBy(() -> bonusNumber.isDuplicated(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
