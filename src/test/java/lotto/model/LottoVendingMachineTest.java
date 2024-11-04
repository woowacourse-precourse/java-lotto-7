package lotto.model;

import lotto.model.Lotto;
import lotto.model.LottoVendingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoVendingMachineTest {

    @DisplayName("정상적인 금액이 주어졌을 때 로또를 발급한다.")
    @Test
    void 정상적인_금액이_주어졌을때_로또를_발급한다() {
        int money = 5000;

        List<Lotto> lottos = LottoVendingMachine.issueNewLottos(money);

        assertThat(lottos).hasSize(5);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        }
    }

    @DisplayName("금액 단위가 맞지 않을 경우 예외가 발생한다.")
    @Test
    void 금액_단위가_맞지_않을_경우_예외가_발생한다() {
        int money = 1500;

        assertThatThrownBy(() -> LottoVendingMachine.issueNewLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
