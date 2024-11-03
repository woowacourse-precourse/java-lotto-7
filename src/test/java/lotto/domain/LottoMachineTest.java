package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("지정 갯수 만큼 로또 발행")
    @Test
    void buyLottoTest() {
        List<Lotto> lottos = LottoMachine.buyLotto(5, new LottoGenerator()).getLottos();
        assertThat(lottos).hasSize(5);
    }

}