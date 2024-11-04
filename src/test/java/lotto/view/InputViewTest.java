package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("로또 구매 금액 1000원 미만일 시 예외 발생")
    void 로또_구매_금액_1000원_미만_시_예외_발생() {
        InputView view = new InputView();

        Assertions.assertThatThrownBy(() -> view.validCanPurchaseLotto(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 미만으론 구매할 수 없음");
    }

    @Test
    @DisplayName("로또 구매 금액 1000원 이상일 시 통과")
    void 로또_구매_금액_1000원_이상_일_시_통과() {
        InputView view = new InputView();

        Assertions.assertThatCode(() -> view.validCanPurchaseLotto(1000));
    }

    @Test
    @DisplayName("로또 구매 금액으로부터 로또 개수 계산 테스트")
    void 로또_구매_금액으로_개수_계산 () {
        InputView view = new InputView();

        Assertions.assertThat(view.calculateNumberOfTotalLotto(1000)).isEqualTo(1);
    }

}
