package lotto.model.money;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.fixture.MoneyFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("구입금액이 0이면 예외가 발생한다.")
    @Test
    void 구입금액이_0이면_예외가_발생한다() {
        Money money = MoneyFixture.create(0);
        assertThat(money.isZero(money)).isTrue();
    }

    @DisplayName("구입금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입금액이_로또_가격으로_나누어_떨어지지_않으면_예외가_발생한다() {
        Money money = MoneyFixture.create(1100);
        assertThat(money.isDivisible(money)).isTrue();
    }

    @DisplayName("구입금액으로 구매할 수 있는 로또 개수를 계산한다.")
    @Test
    void 구입금액으로_구매할_수_있는_로또_개수를_계산한다() {
        Money money = MoneyFixture.create(8000);
        assertThat(money.calculateLottoCount()).isEqualTo(8);
    }
}
