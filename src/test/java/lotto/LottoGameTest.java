package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("유효하지 않은 구입금액이 주어지면 예외가 발생한다.")
    @Test
    void exceptionOnNullMoney() {
        LottoGame game = new LottoGame();
        Money money = null;

        assertThatThrownBy(() -> game.purchaseLotto(money))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("금액이 로또 개별 금액(1000)으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void exceptionOnNonDividableMoney() {
        LottoGame game = new LottoGame();
        Money money = new Money("1001");

        assertThatThrownBy(() -> game.purchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 금액에 대해 올바른 개수의 로또를 구매한다.")
    @Test
    void purchaseAppropriateAmountOfLottos() {
        LottoGame game = new LottoGame();
        Money money = new Money("15000");
        game.purchaseLotto(money);
        assertThat(game.getLottoCount()).isEqualTo(15);
    }
}