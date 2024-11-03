package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @DisplayName("구입 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().buy(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().buy(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine();
            lottoMachine.setWinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)));
            lottoMachine.setBonusNumber(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 결과를 확인하기 전에 당첨 번호와 보너스 번호를 입력하지 않았다면 예외가 발생한다.")
    @Test
    void 당첨_결과를_확인하기_전에_당첨_번호와_보너스_번호를_입력하지_않았다면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().getWinningResult())
                .isInstanceOf(IllegalStateException.class);
    }
}