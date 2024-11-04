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
        int money = 5000; // 5000원을 입력하면 5장의 로또가 발급되어야 함

        List<Lotto> lottos = LottoVendingMachine.issueNewLottos(money);

        assertThat(lottos).hasSize(5); // 발급된 로또의 수가 5장인지 확인
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6); // 각 로또가 6개의 번호를 가지고 있는지 확인
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45); // 번호가 1~45 사이인지 확인
        }
    }

    @DisplayName("금액 단위가 맞지 않을 경우 예외가 발생한다.")
    @Test
    void 금액_단위가_맞지_않을_경우_예외가_발생한다() {
        int money = 1500; // 1500원은 1000원 단위가 아님

        assertThatThrownBy(() -> LottoVendingMachine.issueNewLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
