package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.lottoMachine.BonusNumber;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void 로또_구입_금액이_1000원보다_낮으면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률을_계산할_수_있다(){
        // given
        Money money = Money.from("8000");
        long reward = 5000;

        // when - then
        assertThat(money.caluteProfitRate(reward).profitRate()).isEqualTo(62.5);
    }
}
