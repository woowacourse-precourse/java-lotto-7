package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @Test
    void 필요한_개수만큼_Lotto를_생성해야_합니다(){
        int createSize = 5;

        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos = machine.buyLottos(createSize * Lotto.PRICE);

        assertThat(lottos.size()).isEqualTo(createSize);
    }

    @Test
    void 구매금액은_음수일_수_없습니다(){
        int price = -1;

        LottoMachine machine = new LottoMachine();

        assertThatThrownBy(() -> machine.buyLottos(price))
                .isInstanceOf(IllegalArgumentException.class);

    }

}