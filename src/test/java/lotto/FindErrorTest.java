package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class FindErrorTest {

    @Test
    @DisplayName("돈이 0 이하일 때 IllegalArgumentException 발생")
    void moneyError_돈이_0이하일_때_예외발생() {
        assertThatThrownBy(() -> FindError.moneyError("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 돈은 0이상이여야 합니다.");

        assertThatThrownBy(() -> FindError.moneyError("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 돈은 0이상이여야 합니다.");
    }

    @Test
    @DisplayName("돈이 1000원 단위가 아닐 때 IllegalArgumentException 발생")
    void moneyError_1000원_단위가_아닐_때_예외발생() {
        assertThatThrownBy(() -> FindError.moneyError("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 돈은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("입력값이 숫자가 아닐 때 IllegalArgumentException 발생")
    void moneyError_숫자가_아닐_때_예외발생() {
        assertThatThrownBy(() -> FindError.moneyError("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어날 때 IllegalArgumentException 발생")
    void validateBonusNumber_보너스_번호_범위_초과() {
        assertThatThrownBy(() -> FindError.validateBonusNumber(0, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");

        assertThatThrownBy(() -> FindError.validateBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 IllegalArgumentException 발생")
    void validateBonusNumber_보너스_번호_중복() {
        assertThatThrownBy(() -> FindError.validateBonusNumber(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("유효한 입력값으로 돈을 정상적으로 반환")
    void moneyError_유효한_입력값() {
        int money = FindError.moneyError("3000");
        assertThat(money).isEqualTo(3000);
    }
}
