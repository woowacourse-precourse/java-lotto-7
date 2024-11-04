package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    void 올바른_로또_금액을_입력했을_경우() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoNumbers = lottoMachine.makeLottoNumbers(5000);

        assertEquals(5, lottoNumbers.size());
    }

    @DisplayName("로또 구매 금액이 천단위로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_천단위로_나누어떨어지지_않을_경우() {
        assertThatThrownBy(() -> new LottoMachine().makeLottoNumbers(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }
}