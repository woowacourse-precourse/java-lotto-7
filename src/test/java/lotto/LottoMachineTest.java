package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {
    @Test
    void 로또_구매_금액이_유효한_경우() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.issueLottos(5000);

        assertEquals(5, lottos.size());
    }

    @DisplayName("로또 구매 금액이 천단위로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_천단위로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().issueLottos(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
