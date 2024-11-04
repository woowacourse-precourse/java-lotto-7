package lotto.domain.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("1000원이 입력될 경우, 1개의 로또를 발급한다.")
    void givenLottoMachineAnd1000Money_whenIssueLottos_thenSizeIsOne() {
        // given
        LottoMachine lottoMachine = new LottoMachine(
                () -> List.of(1, 2, 3, 4, 5, 6),
                LottoMoney.from(BigDecimal.valueOf(1000))
        );

        // when
        List<Lotto> lottos = lottoMachine.issueLottos();

        // then
        assertThat(lottos).hasSize(1);
    }

    @Test
    @DisplayName("2000원이 입력될 경우, 두 개의 로또를 발급한다.")
    void givenLottoMachineAnd2000Money_whenIssueLottos_thenSizeIsTwo() {
        // given
        LottoMachine lottoMachine = new LottoMachine(
                () -> List.of(1, 2, 3, 4, 5, 6),
                LottoMoney.from(BigDecimal.valueOf(2000))
        );

        // when
        List<Lotto> lottos = lottoMachine.issueLottos();

        // then
        assertThat(lottos).hasSize(2);
    }

}