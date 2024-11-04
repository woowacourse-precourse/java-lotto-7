package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {
    @DisplayName("금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액만큼 로또가 발행되는지 확인한다.")
    @Test
    void 로또_발행수_확인() {
        LottoMachine lottoMachine = new LottoMachine(8000);
        assertThat(lottoMachine.getLottos()).hasSize(8);
    }
}
