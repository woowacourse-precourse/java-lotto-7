package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.validate.PriceValidate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled("나중에 테스트 할 것")
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 0인 경우 예외가 발생한다.")
    @Test
    void 구매_금액_예외_테스트1() {
        assertThatThrownBy(() ->  new PriceValidate("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR + PRICE_NOT_POSITIVE_NUMBER);
    }

    @DisplayName("구매 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void 구매_금액_예외_테스트2() {
        assertThatThrownBy(() ->  new PriceValidate("-1000"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR + PRICE_NOT_POSITIVE_NUMBER);
    }

    @DisplayName("구매 금액이 1000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액_예외_테스트3() {
        assertThatThrownBy(() ->  new PriceValidate("12345"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR + PRICE_NOT_SUITABLE);
    }

    @DisplayName("구매 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 구매_금액_예외_테스트4() {
        assertThatThrownBy(() ->  new PriceValidate("chris"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR + PRICE_NOT_NUMBER);
    }
}
