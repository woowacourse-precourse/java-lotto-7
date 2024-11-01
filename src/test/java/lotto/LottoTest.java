package lotto;

import lotto.Controller.PurchaseController;
import lotto.View.PurchaseView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //로또 구매 금액 입력 부분
    @DisplayName("로또 구매 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_음수인_경우_예외가_발생한다() {
        PurchaseController purchaseController = new PurchaseController();
        purchaseController.purchase();
        assertThatThrownBy(() -> )
    }

    @DisplayName("로또 구매 금액이 1,000원 단위로 나누어 떨어지지 않는 경우 예외가 발생한다.")

    //당첨 번호 입력 부분
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")

    @DisplayName("당첨 번호는 주어진 범위 내에서 입력되어야 한다.")

    //보너스 번호 입력 부분
    @DisplayName("당첨 번호와 중복된 숫자가 입력된 경우 예외가 발생한다.")

    @DisplayName("보너스 번호도 주어진 번호의 범위 내에서 입력되어야 한다.")

    //통계 부분
    @DisplayName("맞춘 개수에 맞게 순위를 입력해주어야 한다.")
}
