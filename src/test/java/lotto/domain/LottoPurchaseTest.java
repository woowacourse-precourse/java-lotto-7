package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @DisplayName("구입금액에 숫자 이외의 입력이 들어오면 예외가 발생한다.")
    @Test
    void 구입금액에_숫자_이외의_입력이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateInteger("8000qwer"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다."); //NumberFormatException은 IllegalArgumentException을 상속받아 둘다 나옴
    }

    @DisplayName("구입금액에 1000원 보다 작은 숫자가 들어오면 예외가 발생한다.")
    @Test
    void 구입금액에_1000원_보다_작은_숫자가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 999원 보다 큰 숫자여야 합니다.");
    }

    @DisplayName("구입금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchase(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1,000원 단위의 숫자여야 합니다.");
    }
}