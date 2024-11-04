package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validatePurchaseNumber(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 1000원단위로 입력가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호와 보너스 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("구입 금액에 문자가 포함되면 예외가 발생한다.")
    void 구입_금액에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoController.parsePurchaseNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 형식의 구입금액 입니다.");
    }

    @Test
    @DisplayName("당첨 번호에 문자가 포함되면 예외가 발생한다.")
    void 당첨_번호에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoController.parseWinNumber("1,2,3,4,f,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 형식의 로또 번호입니다.");
    }

    @Test
    @DisplayName("보너스 번호에 문자가 포함되면 예외가 발생한다.")
    void 보너스_번호에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoController.parseBonusNumber("7b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 형식의 로또 번호입니다.");
    }
}
