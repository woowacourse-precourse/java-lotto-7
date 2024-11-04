package lotto.basic.purchase;

import lotto.checker.domain.Lottos;
import lotto.purchase.domain.FortuneMachine;
import lotto.purchase.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneMachineTest {

    @Test
    void 로또_발행_개수_테스트() {
        // given
        Money money = new Money("6000");
        FortuneMachine fortuneMachine = new FortuneMachine();

        // when
        Lottos actualValues = fortuneMachine.buyLotto(money);

        // then
        assertThat(actualValues.size()).isEqualTo(6);
    }

}
