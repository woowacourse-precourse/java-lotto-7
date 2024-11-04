package lotto.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyPolicyTest {
    MoneyPolicy moneyPolicy = new MoneyPolicy();

    @Test
    public void 돈은_숫자만_입력_되어야_한다() {
        // given
        String money = "asdf";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moneyPolicy.checkMoneyPolicy(money);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 아무것도_입력되지_않으면_예외를_발생시킨다() {
        // given
        String money = "";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moneyPolicy.checkMoneyPolicy(money);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 돈이_1000으로_나누어_떨어지지않으면_예외를_발생시킨다() {
        // given
        String money = "11100";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moneyPolicy.checkMoneyPolicy(money);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 돈이_int_범위를_넘어서면_예외를_발생시킨다() {
        // given
        String money = "10000000000000000000000000000000000000000000000000";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moneyPolicy.checkMoneyPolicy(money);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

}