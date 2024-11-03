package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDrawingMachineTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 겹치는 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_겹치는_경우_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 3;  // 당첨 번호에 포함된 숫자

        assertThatThrownBy(() -> new LottoDrawingMachine(winningLotto, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 46 이상의 숫자가 있으면 예외가 발생한다.")
    void 보너스_번호가_46_이상의_숫자가_있으면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 46;

        assertThatThrownBy(() -> new LottoDrawingMachine(winningLotto, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 0 이하의 숫자가 있으면 예외가 발생한다.")
    void 보너스_번호가_0_이하의_숫자가_있으면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 0;

        assertThatThrownBy(() -> new LottoDrawingMachine(winningLotto, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("구입한 로또 리스트와 당첨 로또를 비교하여 당첨 결과를 기록한다.")
    void 구입한_로또_리스트와_당첨_로또를_비교하여_당첨_결과를_기록한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoDrawingMachine machine = new LottoDrawingMachine(winningLotto, bonusNumber);

        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );

        WinningStatics winningStatics = machine.matchWinningLotto(purchasedLotto);

        assertThat(winningStatics.getFifth()).isEqualTo(1);
        assertThat(winningStatics.getFirst()).isEqualTo(1);
        assertThat(winningStatics.getSecond()).isEqualTo(1);
    }

}