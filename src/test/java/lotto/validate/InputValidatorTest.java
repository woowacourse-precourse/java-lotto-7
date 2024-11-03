package lotto.validate;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("입력값이 빈 문자열일 경우 예외 발생")
    void 입력값이_빈_문자열일_경우() {
        assertThatThrownBy(() -> InputValidator.cost(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자를 입력했습니다.");
    }

    @Test
    @DisplayName("입력값이 구분자(,)로 끝날 경우 예외 발생")
    void 입력값이_구분자로_끝날_경우() {
        assertThatThrownBy(() -> InputValidator.winningNumber("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 마지막 입력이 구분자입니다.");
    }

    @Test
    @DisplayName("입력 금액이 1000원 단위가 아닐 경우 예외 발생")
    void 입력금액이_1000원_단위가_아닐_경우() {
        assertThatThrownBy(() -> InputValidator.cost("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("입력 로또 번호가 1 이상의 정수가 아닐 경우 예외 발생")
    void 입력로또번호가_1이상의_정수가_아닐_경우() {
        assertThatThrownBy(() -> InputValidator.winningNumber("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 1이상의 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력 로또 번호가 1부터 45 범위를 벗어날 경우 예외 발생")
    void 입력로또번호가_1부터_45범위를_벗어날_경우() {
        assertThatThrownBy(() -> InputValidator.winningNumber("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 이내여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨 번호 내에 포함된 경우 예외 발생")
    void 보너스번호가_이미_당첨번호에_포함된_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputValidator.BonusNumber("5", lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호 내에 존재합니다.");
    }

}