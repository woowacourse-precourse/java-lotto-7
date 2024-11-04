package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일치하는 로또 숫자 개수 확인하기")
    public void 로또_당첨_숫자_개수_테스트() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(winningLotto.matchLottoCount(purchaseLotto)).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 숫자, 당첨 로또 숫자와 일치 확인하기")
    public void 보너스_숫자_일치_테스트() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.matchBonus(6)).isEqualTo(true);
    }
}
